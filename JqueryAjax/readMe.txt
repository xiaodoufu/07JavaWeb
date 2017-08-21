jQuery实现AJAX
    简化了我们的操作！
    
    $.ajax({
     url:"服务器地址",
     type:"请求方式",
     data:"需要传递的数据",
     dataType:"预期服务器返回的数据类型",
     beforeSend:"发送请求之前执行的函数",
     success:"成功之后的回调函数",
     error:"失败之后的回调函数",
     complete:"请求完成之后调用的函数"   （无论成功还是失败）
    })