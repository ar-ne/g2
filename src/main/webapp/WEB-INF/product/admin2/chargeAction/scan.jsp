<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title id="result"></title>
    <script>
        function reply(msg) {
            window.opener.onScanned(msg);
        }
    </script>
    <script src="${pageContext.request.contextPath}/js/webqr/llqrcode.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/webqr/webqr.js"></script>
    <script src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>
</head>
<body>
<div id="outdiv"></div>
<canvas id="qr-canvas" width="800" height="600" style="display: none;"></canvas>
<script>
    $(document).ready(load());
    $('#result').bind('DOMNodeInserted', function (e) {
        var inner = e.target.innerHTML;
        console.log(inner);
        if (inner.indexOf("wait") === -1)
            reply(inner);
    });
</script>
</body>
</html>
