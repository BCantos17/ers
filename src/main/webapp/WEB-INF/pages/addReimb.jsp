<div id="new-reimbursement" style="display:none;">
	<form method="post" action="reimbursement.add.do">
        <div class="modal-body">
			<label for="amnt" class="ui-hidden-accessible">Amount:</label>
			<input class="form-control" type="number" name="amount" id="amnt" placeholder="00.00" step="0.01" >
			
			<label for="descript" class="ui-hidden-accessible" >Description:</label>
			<input class="form-control" type="text" name="description" id="descript" style=" font-size:14pt;" placeholder="...">
			
			<label for="type" class="ui-hidden-accessible">Type</label> 
			<select class="btn btn-warning dropdown-toggle" id="select-type" name="type" >
				<option value="null" selected="selected" class="dropdown-item btn btn-secondary dropdown-toggle" > View Options </option>
				<option value="1" > Lodging </option>
				<option value="2" > Travel </option>
				<option value="3" > Food </option>
				<option value="4" > Other </option>
			</select>
			<font color="red" id="error-message"></font>
 		</div>
	</form>
</div>