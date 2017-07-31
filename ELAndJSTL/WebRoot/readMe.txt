EL 表达式(Expression  Language)：是为了 简化jsp页面！ 替换我们的java小脚本！ 

语法： ${表达式}  这里的表达式 是 作用域中的key

基于 四大作用域                               对应的是
pageContext                  pageScope
request                      requestScope
session                      sessionScope
application                  applicationScope


之前 向  作用域中赋值！
使用 .setAttribute("StringKey",ObjectValue)

我们只要是把 任何需要的对象，放进作用域！
那么我们就可以使用el表达式来获取我们存储的对象！

如果我们没有指定作用域！
会按照 pageScope==>requestScope==>sessionScope==>applicationScope


我们的el表达式多数情况下，是和jstl标签 联合使用！


JSTL （JSP  Standard  Tag Library）jsp的标签库：是一个不断完善的jsp标签库！
 
  core  format   xml  sql
  
使用：
  01.在需要的页面 引入 jstl标签库
  02.使用标签









