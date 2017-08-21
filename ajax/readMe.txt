传统的web和ajax的区别：
01.发送的方式
        传统的web采用的是同步发送！把整个表单中的所有内容同时发给服务器！
    ajax异步发送！表单中的个别元素，先行一步到达服务器！  

02. 服务器的响应方式
      传统的web响应一整个页面！整个页面刷新！
   ajax响应的是用户需要的数据！某个模块在刷新！   
 
03.客户端的处理方式不同   
       传统的web必须等待整个网页加载完毕之后，才能进行下一步的操作！
    ajax动态的刷新局部内容，不影响用户的其他操作！
 
 
Ajax （Asynchronous JavaScript And  Xml）    一种局部刷新的技术！  
 
核心对象： XMLHttpRequest
   常用的属性：
   01. readyState ：XMLHttpRequest的状态码
          0：没有完成初始化
          1：请求准备好，可以发送请求
          2：请求发送完成
          3：开始读取相应
          4：读取相应完毕
    02.status：HTTP的状态码
          200：服务器正确返回响应
          400：参数有误，请求不完整
          404：资源未在服务器上发现
          500: 服务器内部错误
          ......
    03. responseText:文本的方式获取响应的内容
    04.responseXML: xml的方式获取响应的内容 ,dom对象！ 
   常用的方法：
     01.open(method,url,async)
        method:请求的方式
        url:服务器的地址，get请求时，可以在url上拼接参数
        async：是否异步    true:异步
     02.send(data)
                 如果是get方式请求可以是null，也可以不写！
                 如果是post请求 必须加上data!         
                 
                 
                 
     03.setRequestHeader(key,value):设置请求头
     04.getResponseHeader(key):获取指定的响应信息
     
  事件： 回调函数  onreadystatechange   ajax请求成功之后回调用的函数！
                  
         
 
 
 
 