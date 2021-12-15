<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>

<c:set var="pageTitle" scope="request" value="Login Admin" />

<!-- HEAD -->
<jsp:include page="includes/cs-head.jsp"></jsp:include>
<!-- FINE HEAD -->

<body>
	<!-- MENU -->
	<jsp:include page="includes/cs-menu.jsp"></jsp:include>
	<!-- FINE MENU -->

	<!-- CONTENT -->


	<section>
		<div class="container">
			<div class="row">
			
				<div class="col-lg-12">
					<div class="section-heading">
						<h2>Benvenuto, ${user.nome}</h2>
					</div>
				</div>

			<c:if test="${result != null}">
			  <div class="col-xl-12 col-lg-12">
             	 <c:choose>
			  		<c:when test="${result == 'Success'}">
						<div class="alert alert-success mt-2" role="alert">
							<p>Operazione avvenuta con successo!</p>
						</div>	
					</c:when>
					<c:otherwise>
						<div class="alert alert-danger mt-2" role="alert">
							<p>Errore: ${result}</p> 
						</div>	
    				</c:otherwise>
    			</c:choose>
    		  </div>
    		</c:if>
    		 
				<div class="col-xl-6 col-lg-12">
						<div class="card">
							<div class="card-header">I tuoi dati</div>
							<div class="card-body">
								<div class="d-flex align-items-center justify-content-between">
									<div class="col-md-12 d-flex align-items-center me-3">

										<div class="col-md-12 text-right">
											<p>
												<b>Nome:</b> ${user.nome} <br> <b>Cognome:</b>
												${user.cognome}<br> <b>Email:</b> ${user.email}<br>
												<b>Telefono:</b> ${user.tel}
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					<hr>
				</div>

				<div class="col-xl-6 col-lg-12">
						<div class="card">
							<div class="card-header">I tuoi dati</div>
							<div class="card-body">
								<div class="d-flex align-items-center justify-content-between">
									<div class="col-md-12 d-flex align-items-center me-3">

										<div class="col-md-12 text-right">
											<p>
												<b>Nome:</b> ${user.nome} <br> <b>Cognome:</b>
												${user.cognome}<br> <b>Email:</b> ${user.email}<br>
												<b>Telefono:</b> ${user.tel}
											</p>
										</div>
									</div>
								</div>
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