Listener: 监听器

01.HttpSessionBindingListener  ==>指定的类
     如果一个类实现了HttpSessionBindingListener，那么当这个对象被绑定或者删除的时候，servlet容器
     会通知这个对象！当对象接收到通知以后，才可以进行一些初始化或者销毁工作！

02.HttpSessionListener  ==>session

03.ServletContextListener  ==>application