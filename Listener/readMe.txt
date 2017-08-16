Listener: 监听器

 下面三个接口都是继承了 EventListener接口

01.HttpSessionBindingListener  ==>指定的类
     如果一个类实现了HttpSessionBindingListener，那么当这个对象被绑定或者删除的时候，servlet容器
     会通知这个对象！当对象接收到通知以后，才可以进行一些初始化或者销毁工作！

02.HttpSessionListener  ==>session
    注意点：  需要在web.xml文件中配置我们的监听器
     <listener>
          <listener-class>cn.bdqn.sessionListener.User</listener-class>
     </listener>
    
    sessionDestroyed什么时候执行的？
      001.session失效
      002.session超时
     
03.ServletContextListener  ==>application
 和HttpSessionListener有点相似！
 因为 
  01. 他们两个都需要在web.xml文件中配置==》都是在服务器启动的时候实例化！
  02. ServletContextListener的销毁是   在服务器关闭的时候
  