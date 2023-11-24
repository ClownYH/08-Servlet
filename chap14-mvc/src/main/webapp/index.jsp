<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
    <jsp:forward page="WEB-INF/views/main/insertEmp.jsp"/>
    <%-- 마치 바로 등록 페이지로 넘어간 것처럼 보이지만 인덱스 페이지에서 실행되고 있는 것임--%>

</body>
</html>