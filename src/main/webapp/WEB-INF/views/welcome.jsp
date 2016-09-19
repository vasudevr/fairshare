<jsp:include page="navbar_account.jsp"></jsp:include>
<section >
	<div class="container">
		<div class="jumbotron welcome">
			<c:out value="${pageContext.request.userPrincipal.name }"></c:out>
		</div>
	</div>
</section>
</body>
</html>