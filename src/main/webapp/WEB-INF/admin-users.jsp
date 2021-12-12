<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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


	<section class="form-area" id="simple-form">
		<div class="container">
			<div class="row">

				<div class="col-xl-6 col-lg-12">
					<div class="card">
						<div class="card-body">

							<h4 class="header-title mb-3">INFORMAZIONI UTENTI</h4>

							<div class="table-responsive">
								<table
									class="table table-striped table-sm table-nowrap table-centered mb-0">
									<thead>
										<tr>
											<th>Id</th>
											<th>Utente</th>
											<th>Abbonato</th>
											<th>Riconsegna</th>
											<th></th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="user" items="${listUser}">
											<tr>
												<td>&nbsp;<c:out value="${user.id}" /></td>
												<td>
													<h5 class="font-15 mb-1 fw-normal">
														<c:out value="${user.nome}" />
														<c:out value="${user.cognome}" />
													</h5> <span class="text-muted font-13"><c:out
															value="${user.email}" /></span>
												</td>
												<td><span class="badge badge-success-lighten ">
														Confermato </span></td>
												<td><span class="badge badge-success-lighten ">
														Confermato </span></td>
												<td class="table-action"><a
													href="vedi?id=<c:out value='${user.id}' />"
													class="action-icon"> <i class="fa fa-eye"></i>&nbsp;
												</a></td>
												<td><a href="edit?id=<c:out value='${user.id}' />"
													class="action-icon"> <i class="fa fa-pencil"></i>&nbsp;
												</a></td>
												<td><a href="delete?id=<c:out value='${user.id}' />"
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


				


			</div>
		</div>
	</section>



	<!--  FINE CONTENT -->

	<span class="badge badge-success-lighten float-end">Ok</span>
	<span class="badge badge-danger-lighten float-end">Lost lead</span>
	<span class="badge badge-warning-lighten float-end">Cold lead</span>


	<!-- FOOTER -->
	<jsp:include page="includes/cs-footer.jsp"></jsp:include>
	<!-- FINE FOOTER -->
</body>

</html>