<html>
<head>
    <jsp:include flush="true" page="/JSP/headblock.jsp" />
    </head>
<body>

    <div class="left-col">
        <jsp:include flush="true" page="/JSP/employees.jsp" />
    </div>
    
    <div class="right-col">
        <jsp:include flush="true" page="/JSP/addEmployee.jsp" />
        <jsp:include flush="true" page="/JSP/findEmployee.jsp" />
        <jsp:include flush="true" page="/JSP/deleteEmployee.jsp" />
    </div>
    
</body>
</html>
