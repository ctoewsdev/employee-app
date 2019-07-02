<div class="section-box">
	<h3 class="header">Find An Employee By ID</h3>
	<form method="POST">
		<table class="right-table">
			<tr>
				<td>ID:</td>
				<td><input type="text" name="idToFind" /></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right"><input type="submit"
					name="action" value="find"></td>
			</tr>
		</table>
	</form>
	<div class="responses">
		<!-- += operator requires EL 3.0 (Java EE 7 or higher -->
		${findResponse ne null? 'Code: '+= findResponse.code += '<br>': ""}
		${findResponse ne null? 'Description: '+= findResponse.dscr : ""}
		${foundEmp ne null? '<br>Employee: '+= foundEmp.lastName +=', ' += foundEmp.firstName : ""}
	</div>
</div>