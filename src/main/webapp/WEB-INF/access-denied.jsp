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

	<section class="main-content">
   		<div class="container">
     	 <div class="row">
         	<div class="col-lg-8 mt-2 pt-5 pb-5">
				<div class="alert alert-danger " role="alert">
			  		<h4 class="alert-heading">Accesso Negato!</h4>
			  			<p>Siamo spiacenti ma per accedere a questa pagina devi loggarti come <b>${role}</b>.</p>
			  				<hr>
			 			<p class="mb-0">Per effettuare il login inserisci le tue credenziali a questa pagina.</p>
			 			<a class="btn btn-primary mt-2 p-2" href="<%=request.getContextPath()%>/Login">Login</a>
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