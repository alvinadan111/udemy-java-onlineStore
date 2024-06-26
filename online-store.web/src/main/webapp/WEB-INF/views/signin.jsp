<%@ taglib prefix="shop" tagdir="/WEB-INF/tags/shop"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Sign In</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<shop:css-imports-main/>
	<shop:css-imports-signin/>
</head>
<body>

	<shop:header/>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
			
				<c:if test="${UNSUCCESSFUL_LOGIN_COUNT == null || UNSUCCESSFUL_LOGIN_COUNT < 3}">
					<form class="login100-form validate-form" action="perform_login" method="POST">
						<span class="login100-form-title p-b-26">
							Welcome
						</span>
	
						<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
							<input class="input100 has-val" type="text" name="email">
							<span class="focus-input100" data-placeholder="Email"></span>
						</div>
	
						<div class="wrap-input100 validate-input" data-validate="Enter password">
							<span class="btn-show-pass">
								<i class="zmdi zmdi-eye"></i>
							</span>
							<input class="input100 has-val" type="password" name="password">
							<span class="focus-input100" data-placeholder="Password"></span>
							
						</div>
						
						<div class="form-check">
						  <input class="form-check-input" type="checkbox" name="remember">
						  <label class="form-check-label" for="flexCheckDefault">
						    Remember Me
						  </label>
						</div>
	
						<div class="container-login100-form-btn">
							<div class="wrap-login100-form-btn">
								<div class="login100-form-bgbtn"></div>
								<button class="login100-form-btn">
									Sign In
								</button>
							</div>
						</div>
						
						<c:if test="${UNSUCCESSFUL_LOGIN_COUNT < 3}">
							<div id="sign-in-error" class="sign-in-error">
								Incorrect username or password. Please, try to signing in again.
							</div>
						</c:if>
	
						<div class="text-center p-t-115">
							<span class="txt1">
								Don't have an account?
							</span>
	
							<a class="txt2" href="signup">
								Sign Up
							</a>
						</div>
					</form>
				
				</c:if>
				
				<c:if test="${UNSUCCESSFUL_LOGIN_COUNT >= 3}">
					<div>
						There were 3 unsuccessful attempts to login into the account. Please, try to sign in later
					</div>
				</c:if>
				
			</div>
		</div>
	</div>
	
	<shop:footer/>
	<shop:js-imports-signin/>
	
	<script>
	    // Hide the error message after a certain amount of time (e.g., 5 seconds)
	    setTimeout(function() {
	        var errorMessage = document.getElementById("sign-in-error");
	        if (errorMessage) {
	            errorMessage.style.display = "none";
	        }
	    }, 3000); // 5000 milliseconds = 5 seconds
	</script>

</body>
</html>