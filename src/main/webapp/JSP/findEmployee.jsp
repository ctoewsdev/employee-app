<div class="box">
	<h3 class="header">Find An Employee By ID</h3>
	<form method="POST">
		<table>
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

		${findResponse ne null? 'Response Code:  '+= findResponse.code : ""}
		${findResponse ne null? 'Description:  '+= findResponse.dscr : ""}
		${foundEmp.firstName} ${foundEmp.lastName}
	</form>

</div>
