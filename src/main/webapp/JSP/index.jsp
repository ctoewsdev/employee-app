
<html>
    <jsp:include flush="true" page="/JSP/head.jsp" flush="true" />
<body>

    <div class="empTable">
        <jsp:include flush="true" page="/JSP/employees.jsp" flush="true" />
    </div>
    
    <div class="forms">
        <jsp:include flush="true" page="/JSP/addEmployees.jsp" flush="true" />
        <jsp:include flush="true" page="/JSP/findEmployees.jsp" flush="true" />
        <jsp:include flush="true" page="/JSP/deleteEmployees.jsp" flush="true" />
    </div>
    
</body>
</html>
