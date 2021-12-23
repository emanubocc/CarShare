<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>

<c:set var="pageTitle" scope="request" value="Admin Users" />

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

				<div class="col-xl-5 col-lg-12">
					<div class="card">
						<div class="card-body">

							<h4 class="header-title mb-3">INFORMAZIONI UTENTI</h4>

							<div class="table-responsive">
								<table
									class="table table-striped table-sm table-nowrap table-centered mb-0">
									<thead>
										<tr>
											<th>User ID</th>
											<th>Info</th>
											<th>View</th>
											<th>Edit</th>
											<th>Delete</th>

										</tr>
									</thead>
									<tbody>

										<c:forEach var="user" items="${listUser}">
											<tr>
												<td>&nbsp;#<c:out value="${user.id}" /></td>
												<td>
													<h5 class="font-15 mb-1 fw-normal">
														<c:out value="${user.nome}" />
														<c:out value="${user.cognome}" />
													</h5> <span class="text-muted font-13"><c:out
															value="${user.email}" /></span><br>
															<span class="text-muted font-13"><c:out
															value="${user.tel}" /></span>
												</td>
												<td class="table-action"><a
													href="<%=request.getContextPath()%>/Admin/Home?action=vediUtenti&View=${user.id}"
													class="action-icon"> <i class="fa fa-eye"></i>&nbsp;</a></td>
													
												<td><a href=""
													class="action-icon"> <i class="fa fa-pencil"></i>&nbsp;
												</a></td>
												
												<td><a href=""
													class="action-icon"> <i class="fa fa-remove"></i>&nbsp;
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				<c:if test="${resList != null}">
				<div class="col-xl-7 col-lg-12">
					<div class="card">
						<div class="card-body">

							<h4 class="header-title mb-3">INFORMAZIONI PRENOTAZIONI</h4>

							<div class="table-responsive">
								<table
									class="table table-striped table-sm table-nowrap table-centered mb-0">
									<thead>
										<tr>
											<th>ID Utente</th>
											<th>ID Prenotazione</th>
											<th>Pagato</th>
											<th>Auto consegnata</th>
											<th>Stato</th>

										</tr>
									</thead>
									<tbody>

										<c:forEach var="res" items="${resList}">
											<tr>
												<td>&nbsp;#<c:out value="${res.id_utente}" /></td>
												<td>&nbsp;#<c:out value="${res.id_prenotazione}" /></td>
												
												<td><p class="nope">${res.pagato}</p></td>
												<td><p class="nope">${res.autoConsegnata}</p></td>
												<td><span class="badge ${res.stato}"> ${res.stato} </span></td>
												<td>
													<c:if test="${res.stato == 'Prenotato'}">
													<form action="Home" method="post">
														<div class=" d-none">
															<fieldset>
																<input name="hidden" type="text" id="hidden"
																	value="conferma">
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
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${resList == null}">
					<div class="col-xl-7 col-lg-12">
					<div class="alert alert-warning mt-2" role="alert">
						<p>Seleziona la vista di un utente per visualizzare le prenotazioni.</p>
					</div>
					</div>
				</c:if>

				


			</div>
		</div>
	</section>



	<!--  FINE CONTENT -->



	<!-- FOOTER -->
	<jsp:include page="includes/cs-footer.jsp"></jsp:include>
	<!-- FINE FOOTER -->
</body>

</html>