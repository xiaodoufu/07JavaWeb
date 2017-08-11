package cn.bdqn.servlet;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.service.NewsDetailService;
import cn.bdqn.service.ServiceFactory;

/**
 * 文件新增   ===》上传
 * 
 * 分析：
 *01.form表单提交的时候  有文件！enctype="multipart/form-data"
 *02.针对与文件上传 我们需要引入2个jar
 *   fileupload 文件上传的jar   依赖于  io.jar
 *03.我们的form表单中  不只是有文件，还有 普通的 文本输入框
 *   这时候 我们能  按照同一种方式 进行处理吗？？？  No!
 *04.是文件 我们按照文件的方式 处理  
 *     001.我们怎么知道用户的请求是文件上传类型？
 *       ServletFileUpload中有一个isMultipartContent(HttpServletRequest)方法
 *         根据用户的请求  我们可以判断  是否是文件上传类型的请求！ 返回 boolean
 *       
 *       ServletFileUpload中还有一个重要的方法parseRequest(HttpServletRequest)
 *        根据用户的请求,会把我们form表单中的每一项（不管是文件还是普通文本都封装成了
 *        一个FileItem对象，这个方法返回一个所有FileItem的List集合
 *       
 *     002.怎么处理文件？
 *      FileItem 接口 
 *          中有一系列的方法   可以解析是否是文件还是普通文本！
 *           getInputStream() 把上传文件加载到内存中                                       输入流
 *           getOutputStream() 把内存中的数据写入到服务器的文件中                输出流
 *           
 *           如果是文件类型，想获取文件名使用 getName()
 *           如果是普通文本，想获取字段名使用 getFieldName()
 *          
 *           怎么知道 是文件 还是 普通字段？？
 *            有一个方法 isFormField()  返回boolean
 *            true :普通字段
 *            false:文件
 *        
 *       DiskFileItemFactory 核心的实现类  
 *           可以设置我们缓冲区的大小 setSizeThreshold(int sizeThreshold)  1024*1024          默认大小 10kb
 *           设置文件临时存放的位置    setRepository(File repository)    new  File("e:\temp")    默认路径System.getProperty("java.io.temdir")
 *    
 *   是普通的文本输入框   我们按照普通的方式 处理  
 *   
 *   
 *  实现文件上传的步骤：
 *  01.创建DiskFileItemFactory对象 设置缓冲区的大小  存放的位置  ，可以不设置 有默认值
 *  02.通过DiskFileItemFactory对象 创建出 ServletFileUpload  ，就可以知道我们的请求是否是文件上传类型
 *  03.通过ServletFileUpload对象的  parseRequest方法 获取List<FileItem>
 *  04.对list集合进行遍历，每遍历一次都要使用FileItem类中的isFormField（）来判断是否为文件
 *      001.普通字段  使用 getFieldName()  和getString() 来获取字段名和字段值
 *      002.文件   使用getInputStream  getName  getOutputStream
 */
public class AddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("临时文件的位置：" + System.getProperty("java.io.temdir"));
		// 因为新增新闻 需要一个新闻对象
		News_Detail detail = new News_Detail();

		// 01.创建DiskFileItemFactory对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 02.通过DiskFileItemFactory对象 创建出 ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 判断是不是 文件上传请求
		boolean flag = upload.isMultipartContent(request);

		if (flag) {
			// 03.通过ServletFileUpload对象的 parseRequest方法 获取List<FileItem>
			try {
				List<FileItem> items = upload.parseRequest(request);
				// 04.对list集合进行遍历，每遍历一次都要使用FileItem类中的isFormField（）来判断是否为文件
				Iterator<FileItem> its = items.iterator();
				while (its.hasNext()) {
					// 获取每一项
					FileItem item = its.next();
					if (item.isFormField()) { // 普通字段
						// 001.普通字段 使用 getFieldName() 和getString() 来获取字段名和字段值
						String fieldName = item.getFieldName();
						if (fieldName.equals("title")) {
							detail.setTitle(item.getString("utf-8"));
						} else if (fieldName.equals("author")) {
							detail.setAuthor(item.getString("utf-8"));
						} else if (fieldName.equals("summary")) {
							detail.setSummary(item.getString("utf-8"));
						} else if (fieldName.equals("content")) {
							detail.setContent(item.getString("utf-8"));
						} else if (fieldName.equals("createDate")) {
							detail.setCreateDate(new SimpleDateFormat(
									"MM/dd/yyyy").parse(item.getString("utf-8")));
						} else if (fieldName.equals("categoryId")) {
							detail.setCategoryId(Integer.parseInt(item
									.getString("utf-8")));
						}
					} else { // 文件上传
						// 指定文件上传的位置getServletContext() 获取的是项目在服务器的位置 ==>
						// E:\apache-tomcat-7.0.77\webapps\news
						String uploadPath = request.getSession()
								.getServletContext().getRealPath("upload/");
						File file = new File(uploadPath);
						if (!file.exists()) {// 不存在 我们创建
							file.mkdirs();
						}
						String fileName = item.getName(); // 文件名称
						if (!fileName.equals("") && fileName != null) { // 判断用户是否选择了文件
							File uploadFile = new File(fileName); // 上传的文件
							File saveFile = new File(uploadPath,
									uploadFile.getName());
							// 真正的输出
							item.write(saveFile);
							detail.setPicPath(uploadFile.getName());
						}
					}
				}

				NewsDetailService service = (NewsDetailService) ServiceFactory
						.getServiceImpl("NewsDetailService");
				int num = service.add(detail);
				if (num > 0) { // 新增成功
					resp.sendRedirect("listServlet");
				} else {
					resp.sendRedirect("FindCategoryServlet");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
