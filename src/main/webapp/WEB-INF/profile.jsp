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

				<div class="col-xl-3 col-lg-12">
					<div class="card">
						<div class="card-header">I tuoi dati</div>
						<div class="card-body">
							<div class="d-flex align-items-center justify-content-between">
								<div class="col-md-12 d-flex align-items-center me-3">

									<div class="col-md-12 text-right">
										<p>
											<b>Nome:</b> ${user.nome} <br> <b>Cognome:</b>
											${user.cognome}<br> <b>Email:</b> ${user.email}<br>
											<b>Telefono:</b> ${user.tel} <br>
										</p>
										<hr>
										<b>Data ultimo pagamento quota annuale:</b>
										${user.data_pagamento}
										<c:if test="${DaPagare == 'Da_pagare'}">
										<p>Quota scaduta, effettua ora un pagamento.
										<a href="<%=request.getContextPath()%>/UserProfile?action=pagaQuota" class="btn btn-primary btn-small">Paga quota</a>
										</p>
										</c:if>
										

									</div>
								</div>
							</div>
						</div>
					</div>
					<hr>
				</div>

				<div class="col-xl-9 col-lg-12">

					<div class="card">
						<div class="card-header">Le tue prenotazioni</div>
						<div class="card-body">

							<div class="table-responsive">
								<table
									class="table table-striped table-sm table-nowrap table-centered mb-0">
									<thead>
										<tr>
											<th>Id</th>
											<th>Data Inizio</th>
											<th>Data Consegna</th>
											<th>Percorrenza</th>
											<th>Luogo Parcheggio</th>
											<th>Tariffa</th>
											<th>Stato</th>
										</tr>
									</thead>
									<tbody>



										<c:forEach var="res" items="${resList}">
											<tr>

												<td>
													<h5 class="font-15 mb-1 fw-normal">
														#${res.id_prenotazione}</h5> <span class="text-muted font-13"></span>
												</td>

												<td>${res.data_inizio}</td>
												<td>${res.data_consegna}</td>
												<td>${res.percorrenza_effettiva}</td>
												<td>${res.luogo}</td>
												<td>${res.tariffa}&euro;</td>
												<td><span class="badge ${res.stato}">${res.stato}</span></td>
												<td><c:if
														test="${res.stato == 'Erogato' || res.stato == 'Da consegnare'}">
														<c:if test="${res.autoConsegnata == 'NO'}">
															<form action="UserProfile" method="post">
																<div class=" d-none">
																	<fieldset>
																		<input name="hidden" type="text" id="hidden"
																			value="consegna">
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
																		class="btn btn-primary btn-small">Consegna</button>
																</fieldset>
															</form>
														</c:if>
													</c:if></td>
												<td><c:if
														test="${res.stato == 'Erogato' || res.stato == 'Da pagare' }">
														<c:if test="${res.pagato == 'NO'}">
												

													<a href="<%=request.getContextPath()%>/UserProfile?action=pagaPrenotazione&id_prenotazione=${res.id_prenotazione}" id="form-submit"
														class="btn btn-primary btn-small">Paga</a>
								
															
														</c:if>
													</c:if></td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
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