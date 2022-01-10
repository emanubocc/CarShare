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


	<section class="form-area" id="simple-form">
		<div class="container">
			<div class="row">
			
				<div class="col-lg-12">
					<div class="section-heading">
						<h2>Effettua pagamento, seleziona modalità</h2>
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
    		 
    		    <div class="col-lg-3 all soon">
                  <div class="meeting-item">
                    <div class="thumb">
                      <div class="price">
                        <span>${quota}&euro;</span>
                      </div>
                      <a href="<%=request.getContextPath()%>/UserProfile?action=${pagamento}&metodo=bancomat&id_prenotazione=${id_prenotazione}"><img src="<%=request.getContextPath()%>/resources/assets/images/bancomat.png" alt=""></a>
                    </div>
                    <div class="down-content">

                      <h4>Paga con bancomat o carta di credito.</h4>
                      <a href="<%=request.getContextPath()%>/UserProfile?action=${pagamento}&metodo=bancomat&id_prenotazione=${id_prenotazione}" class="btn btn-primary" role="button" aria-pressed="true">Paga ora</a>
                    </div>
                  </div>
                </div>
                
                <div class="col-lg-3 all soon">
                  <div class="meeting-item">
                    <div class="thumb">
                      <div class="price">
                        <span>${quota}&euro;</span>
                      </div>
                      <a href="<%=request.getContextPath()%>/UserProfile?action=${pagamento}&metodo=contanti"><img src="<%=request.getContextPath()%>/resources/assets/images/contanti.png" alt=""></a>
                    </div>
                    <div class="down-content">

                      <h4>Effettua pagamento in contanti.</h4>
                      <a href="<%=request.getContextPath()%>/UserProfile?action=${pagamento}&metodo=contanti" class="btn btn-primary" role="button" aria-pressed="true">Paga ora</a>
                    </div>
                  </div>
                </div>

				<c:if test="${metodo != null}">
					<div class="col-lg-6 ">

						<div class="card">
							<div class="card-header">Pagamento</div>
							<div class="card-body">
								
								<c:if test="${metodo == 'bancomat'}">

									<form id="simple-form" action="UserProfile" method="post" style="padding:5px">

										<div class="row">
										<p> Effettua pagamento con bancomat o carta di credito. <br>&nbsp;</p>
											<div class=" d-none">
												<fieldset>
													<input name="hidden" type="text" id="hidden"
														value="bancomat">
														<input name="quotaPagamento" type="text" id="quotaPagamento"
														value="${quota}">
												</fieldset>
											</div>

											<div class="col-lg-6">
												<fieldset>
													<label>Nome sulla carta</label> <input name="fullname"
														type="text" id="fullname" value="" required>
												</fieldset>
											</div>
											<div class="col-lg-6">
												<fieldset>
													<label>Numero della carta</label> <input name="numeroCarta"
														type="tel" autocomplete="off" id="numeroCarta" value="" required>
												</fieldset>
											</div>
											<div class="col-lg-6">
												<fieldset>
													<label>Cvv </label><br> <input name="cvv" type="text"
														id="cvv" value="" required>
												</fieldset>
											</div>
											<div class="col-lg-6">
												<fieldset>
													<label>Data di scadenza </label><br> <input
														name="scadenza" type="month" id="scadenza" required>
												</fieldset>
											</div>

											<div class="col-lg-6">
												<fieldset>
													<button type="submit" id="form-submit"
														class="button float-begin">PAGA</button>
												</fieldset>
											</div>
										</div>

									</form>
								</c:if>

							</div>
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