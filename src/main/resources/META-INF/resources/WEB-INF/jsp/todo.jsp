	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="discription"> Discription</form:label>
				<form:input type="txt" path="discription" required="required" />
				<form:errors path="discription" cssClass="text-warning"/>
			</fieldset>
			
			<fieldset class="mb-3">
				<form:label path="localdate">Target Date</form:label>
				<form:input type="LocalDate" path="localdate" required="required" />
				<form:errors path="localdate" cssClass="text-warning"/>
			</fieldset>
			
			<form:input type="hidden" path="done" required="required" />
			<form:input type="hidden" path="id" required="required" />
			
			<input type="submit" class="btm btm success">
		</form:form>
		</div>
		
		<%@ include file="common/footer.jspf" %>
		
		<script type="text/javascript">
		$('#localdate').datepicker({
		    format:'yyyy-mm-dd'
		});
		</script>
	
</body>
</html>