<div class="box">
	<h3 class="header">Remove an Employee</h3>
	<form method="POST">
		<table>
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

		${deleteResponse ne null? 'Response Code:  '+= deleteResponse.code : ""}
		${deleteResponse ne null? 'Description:  '+= deleteResponse.dscr : ""}
	</form>
</div>