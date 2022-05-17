<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3> Information for all Employees </h3>
    <br>
    <security:authorize access="hasRole('HR')"> <input type="button" value="Salary" onclick="window.location.href = 'hr_info'">
        Only for HR staff.
    </security:authorize>

<br>
    <security:authorize access="hasRole('MANAGER')">
        <input type="button" value="Performance" onclick="window.location.href = 'manager_info'">
        Only for managers.
    </security:authorize>

</body>
</html>
