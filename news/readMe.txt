数据源： DataSource
 创建连接交给连接池！
javax.sql.DataSource建立与数据库的链接！

数据库连接池：Connection  Poll
  01.负责管理和释放数据库连接的一个缓冲池技术！
  02.自动分配连接对象并对闲置的链接对象进行回收！
  03.连接池配置到Tomcat中的conf文件夹下面的context.xml文件


JNDI(Java  Naming And  Directory Interface) 
java命名和目录接口！


我们之前使用JDBC技术连接数据库必须使用JDBC API！
现在使用数据源或者连接池的技术来访问数据库，必须使用 JNDI！


<Resource  
name="jdbc/news"
auth="Container" 
type="javax.sql.DataSource"
driverClassName="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/news?Unicode=true&characterEncoding=utf-8"
username="root"
password=""
/>


name:自定义的连接池名称，外部需要访问我们这个连接池，就是通过name属性值找到的！
auth：连接池被谁管理！Container容器！ Tomcat
type：对象的类型
driverClassName ：数据库的驱动类名
url：数据库的地址
username:登录数据库的用户名
password:登录数据库的密码
maxActive:连接池的最大数据库连接数量  ，最大并发访问的数量
minIdle: 最小空闲连接
maxIdle: 最小空闲连接
maxWait: 超时等待时间以毫秒为单位 

sql心跳：确保我们客户端的链接始终是有效的链接！








分页：
 01.获取总记录数
 02.SELECT * FROM news_detail  LIMIT 0,3
  显示新闻表中  从 第一条数据开始  ==》0    显示 3条   ===》页大小 pageSize
  
  问题？
  
  01.用户懂吗？
  02.用户只知道点击上一页，下一页...... 不知道 数据的起始位置
  03.我们必须把用户点击的当前页 ， 转换成查询数据库中数据开始的位置（目的）
    

分析：

  01. 用户点击第1页  pageIndex=1
                 我们的sql语句怎么写
                    LIMIT 0,3
 
  02. 用户点击第2页  pageIndex=2
                 我们的sql语句怎么写
                    LIMIT 3,3
                    
  03. 用户点击第3页  pageIndex=3
                 我们的sql语句怎么写
                    LIMIT 6,3
 
  3是每页显示的数量，页大小   pageSize
   
  我们数据开始的位置=（pageIndex-1）*pageSize
  
  
  
  






























