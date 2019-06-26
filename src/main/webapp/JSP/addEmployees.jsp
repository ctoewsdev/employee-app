<div class="box">
    <h3 class="header">Add Employees</h3>
    <FORM METHOD="POST">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="addID" /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="addFirstName" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="addLastName" /></td>
            </tr>
            <tr>
                <td>DOB:</td>
                <td><input type="text" name="addDOB" placeholder="YYYY/MM/DD" /></td>
            </tr>
            <tr>
                <td></td>
                <td style="text-align: right"><INPUT TYPE="SUBMIT"
                    VALUE="Add Employees" name="add"></td>
             </tr>
        </table>
             ${resultCodeAdd}
    </FORM>
</div>