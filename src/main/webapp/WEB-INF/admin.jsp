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


	<section class="admin-area" id="admin">
		<div class="container">
			<div class="row">

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
						<div class="card-header">Parco Auto</div>
						<c:forEach var="car" items="${CarList}">
							<div class="card-body">
								<div class="d-flex align-items-center justify-content-between">
									<div class="col-md-12 d-flex align-items-center me-3">
										<div class="col-md-3 avatar avatar-xl me-3">
											<img src="<%=request.getContextPath()%>/resources/assets/images/${car.imgUrl}"
												alt="${car.modello}" class="avatar-img img-fluid">
										</div>
										<div class="col-md-5 d-flex flex-column fw-bold">
											<a href="#"
												class="text-dark line-height-normal mb-1">${car.modello}</a>
											<div>
												<p class="small text-muted">
													Targa: <span class="badge-soft-primary">${car.targa}</span>
												</p>
												<p class="small text-muted">Situata: ${car.luogo}</p>
												<p class="small text-muted">Stato: ${car.stato}</p>
											</div>
										</div>
										<div class="col-md-2 text-right">
											<a href="<%=request.getContextPath()%>/Admin/Home?action=moveCar&Targa=${car.targa}"
											class="btn btn-primary" role="button" aria-pressed="true">
											Sposta</a>											
										</div>
										<div class="col-md-2 text-right">
											<a href="<%=request.getContextPath()%>/Admin/Home?action=deleteCar&Targa=${car.targa}"
											class="btn btn-danger" role="button" aria-pressed="true">
											Elimina</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="card-footer position-relative">
							<p>Totale auto: ${fn:length(CarList)}</p>
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-12">
					<div class="card">
						<div class="card-header">Parcheggi</div>
						<div class="">
							<div class=" align-items-center justify-content-between">
								<c:forEach var="park" items="${ParkList}">
									<div class="col-md-12 d-flex align-items-center me-3 card-body">

										<div class="col-md-10 text-right">
											<p class="fw-bold">ID PARCHEGGIO: ${park.id_parcheggio}</p>
											<p class="small text-muted">${park.luogo}</p>
										</div>

										<div class="col-md-2 text-right">
											<a href="<%=request.getContextPath()%>/Admin/Home?action=deletePark&idPark=${park.id_parcheggio}"
											class="btn btn-danger" role="button" aria-pressed="true">
											Elimina</a>
										</div>

									</div>
								</c:forEach>
							</div>
						</div>
					</div>
					<hr>
					<div class="card">
						<div class="card-header"></div>

						<div class="card-footer position-relative">
							<a class="stretched-link line-height-normal" href="<%=request.getContextPath()%>/Admin/Home?action=aggiungiAuto">
								<p class="text-xs d-flex align-items-center justify-content-between text-dark">
									Aggiungi Autoveicolo <i class="fa fa-plus"></i>
								</p>
							</a>
						</div>
						<div class="card-footer position-relative">
							<a class="stretched-link line-height-normal" href="<%=request.getContextPath()%>/Admin/Home?action=aggiungiParcheggio">
								<p class="text-xs d-flex align-items-center justify-content-between text-dark">
									Aggiungi Parcheggio <i class="fa fa-plus"></i>
								</p>
							</a>
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