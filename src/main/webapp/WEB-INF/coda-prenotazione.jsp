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

			<div class="col-xl-5 col-lg-12">
					<div class="card">
						<div class="card-body">

							<h4 class="header-title mb-3">INFORMAZIONI PRENOTAZIONI FIFO</h4>

							<div class="table-responsive">
								<table
									class="table table-striped table-sm table-nowrap table-centered mb-0">
									<thead>
										<tr>
											<th>Park ID</th>
											<th>ID Prenotazione</th>
											<th>View</th>
											<th>Edit</th>
											<th>Delete</th>

										</tr>
									</thead>
									<tbody>

					
											<tr>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										
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