<div class="section-box">
	<h3 class="header">Remove an Employee</h3>
	<form method="POST">
		<table class="right-table">
			<tr>
				<td>ID:</td>
				<td><input type="text" name="idToDelete" /></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right"><input type="submit"
					name="action" value="delete"></td>
			</tr>
		</table>
    <div class="responses">
        <!-- += operator requires EL 3.0 (Java EE 7 or higher -->
        ${deleteResponse ne null? 'Code: '+= deleteResponse.code += '<br>': ""}
        ${deleteResponse ne null? 'Description: '+= deleteResponse.dscr : ""}
        ${deleteEmp ne null? '<br>Employee: '+= deleteEmp.lastName +=', ' += deleteEmp.firstName : ""}
    </div>
	</form>
</div>