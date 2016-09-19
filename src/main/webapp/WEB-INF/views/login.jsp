<jsp:include page="header.jsp"></jsp:include>
<div class="jumbotron text-center">
	<div class="col-lg-10">
</div>

</div>


<div class="container">

    <form method="POST" action="login" class="form-signin">
        <h2 class="form-heading text-center">Sign In</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="register">Create an account</a></h4>
        </div>

    </form>


	</div>

</body>
</html>