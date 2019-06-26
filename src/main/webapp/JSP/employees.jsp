
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.caseytoews.webapp.employee.domain.Employee"%>

<div class="box">
    <h3 class="header">Employee List</h3>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>DOB</th>
        </tr>
         
 <% ArrayList<Employee> employees = (ArrayList<Employee>)request.getAttribute("empList");

for( Employee emp : employees) {
    
    

%>
    
        <tr>
            <td> <%=emp.getID() %></td>
            <td> <%=emp.getFirstName() %></td>
            <td> <%=emp.getLastName() %></td>
            <td><%= new SimpleDateFormat("yyyy/MM/dd").format(emp.getDOB())%></td>
        </tr>
    
            
  <%  
  }
    
%>



    </table>
</div>