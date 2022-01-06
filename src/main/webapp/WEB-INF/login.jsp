<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<c:set var="pageTitle" scope="request" value="Login" />

<!-- HEAD -->
<jsp:include page="includes/cs-head.jsp"></jsp:include>
<!-- FINE HEAD -->

<body>
	<!-- MENU -->
	<jsp:include page="includes/cs-menu.jsp"></jsp:include>
	<!-- FINE MENU -->

	<!-- CONTENT -->

	<section class="form-area" id="simple-form">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-4 align-self-center">
					<div class="row">
					
				<c:if test="${resultLogin != null}">
             	 <c:choose>
			  		<c:when test="${resultLogin == 'Success'}">
						<div class="alert alert-success mt-2" role="alert">
							<p>Login avvenuto con successo!</p>
						</div>	
					</c:when>
					<c:when test="${resultLogin == 'Logout'}">
						<div class="alert alert-success mt-2" role="alert">
							<p>Logout avvenuto con successo!</p>
						</div>	
					</c:when>
					<c:otherwise>
						<div class="alert alert-danger mt-2" role="alert">
							<p>Errore: ${resultLogin}</p> 
						</div>	
    				</c:otherwise>
    			</c:choose>
    		 </c:if>
						<div class="col-lg-12">
						
							<form id="simple-form" action="Login" method="post" >
								<div class="row">

									<div class="text-center">
										<a href="/CarShare" class="logo">CAR SHARING ${user.role}</a>
										<h1 class="display-5 mb-0">Login</h1>
										<div class="subheading-1 mb-5">to continue to app</div>
									</div>

									<div class="col-lg-12">
										<fieldset>
											<input name="email" type="text" id="email"
												pattern="[^ @]*@[^ @]*" placeholder="EMAIL..." required="">
										</fieldset>
									</div>

									<div class="col-lg-12">
										<fieldset>
											<input name="password" type="password" id="password"
												placeholder="PASSWORD..." required="">
										</fieldset>
									</div>

									<div class="form-group d-flex align-items-center justify-content-between mt-0 mb-2">
										<fieldset>
											<button type="submit" id="form-submit" class="button">Login</button>
										</fieldset>
										
									</div>
								</div>
							</form>
						</div>
						
						<div class="text-center mt-2">
							<a class="small fw-500 text-decoration-none link-white" href="Registrazione">Hai bisogno di un account? Registrati!</a>
						</div>
					
					</div>
					
				
				</div>
			</div>
		</div>
	</section>

	<!--  FINE CONTENT -->


	<!-- FOOTER -->
	<jsp:include page="includes/cs-footer.jsp"></jsp:include>
	<!-- FINE FOOTER -->
</body>

</html>