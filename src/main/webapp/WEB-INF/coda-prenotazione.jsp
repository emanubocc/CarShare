<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>

<c:set var="pageTitle" scope="request" value="Coda Prenotazioni" />

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
			<div class="row">
				
				
				<c:forEach var="parks" items="${parkResList}">
				
				<div class="col-xl-6 col-lg-12">
					<div class="card">
						<div class="card-body">

							

										<c:forEach var="res" items="${parks}" varStatus="theCount">
										<c:if test="${theCount.index == 0}">
										 <h4 class="header-title mb-3">PRENOTAZIONI PARCHEGGIO: ${res.luogo}</h4>

										<div class="table-responsive">
											<table
												class="table table-striped table-sm table-nowrap table-centered mb-0">
												<thead>
													<tr>
														
														<th>Id</th>
														
														<th>Data Noleggio</th>
														
														<th>Stato</th>
														<th>Conferma</th>
														<th>Cancella</th>
														
													</tr>
												</thead>
												<tbody>
										</c:if>
										
											<tr>
												<td>&nbsp;#<c:out value="${res.id_prenotazione}" /></td>
												
												
												<td><p class="nope">${res.data_inizio} / ${res.data_consegna}</p></td>
												
												<td><span class="badge ${res.stato}"> ${res.stato} </span></td>
												<td> 
													<c:if test="${res.stato == 'Prenotato'}">
													<form action="Home" method="post">
														<div class=" d-none">
															<fieldset>
																<input name="hidden" type="text" id="hidden"
																	value="confermaCoda">
															</fieldset>
														</div>
														<div class=" d-none">
														<fieldset>
															<input type="text" name="id_prenotazione"
																id="id_prenotazione" value="${res.id_prenotazione}">
														</fieldset>
														</div>
														<fieldset>
															<button type="submit" id="form-submit"
																class="btn btn-primary btn-small">Conferma</button>
														</fieldset>
													</form>
													</c:if>
												</td>
												
												<td><a href="<%=request.getContextPath()%>/Admin/Home?action=vediUtenti&deleteReservation=${res.id_prenotazione}"
													class="action-icon"> <i class="fa fa-remove"></i>&nbsp;
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<p> &nbsp;</p>
				</div>
				
				</c:forEach>
			


			</div>
		</div>
	</section>



	<!--  FINE CONTENT -->



	<!-- FOOTER -->
	<jsp:include page="includes/cs-footer.jsp"></jsp:include>
	<!-- FINE FOOTER -->
</body>

</html>