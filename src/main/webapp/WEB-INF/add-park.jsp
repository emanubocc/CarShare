<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>

<c:set var="pageTitle" scope="request" value="Registrazione"/>

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
        <div class="col-lg-6 align-self-center ">
          <div class="row">
            <div class="col-lg-12">

              <form id="simple-form" action="Home" method="post">
                <div class="row">
                
                  <div class="col-lg-12">
                    <h2>AGGIUNGI PARCHEGGIO</h2>
                     <p class="fw-bold big p-2"> Inserisci il luogo del parcheggio da inserire.</p>
                  </div>
                  
                   <div class="d-none">
                      <input name="hidden" type="text" id="hidden" value="park">
                  </div>
                  
                  <div class="col-lg-12">
                    <fieldset>
                      <input name="luogo" type="text" id="luogo" placeholder="LUOGO" required="">
                    </fieldset>
                  </div>
                           
                  <div class="col-lg-12">
                    <fieldset>
                          <button type="submit" id="form-submit" class="button">AGGIUNGI PARCHEGGIO</button>
                    </fieldset>
                  </div>
                </div>
              </form>
              <c:if test="${result != null}">
             	 <c:choose>
			  		<c:when test="${result == 'Success'}">
						<div class="alert alert-success mt-2" role="alert">
							<p>Inserimento avvenuto con successo!</p>
						</div>	
					</c:when>
					<c:otherwise>
						<div class="alert alert-danger mt-2" role="alert">
							<p>Errore: ${result}</p> 
						</div>	
    				</c:otherwise>
    			</c:choose>
    		 </c:if>
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