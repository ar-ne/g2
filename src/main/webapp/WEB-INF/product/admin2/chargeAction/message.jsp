<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<script>
    var msg = eval("${jMsg}");
    for (var key in msg) {
        console.log(key);  //键
        console.log(msg[key]);  //值
    }
</script>
</body>
</html>
