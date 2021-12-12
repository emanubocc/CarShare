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
                    <h2>AGGIUNGI AUTO</h2>
                  </div>
                  
                  <div class=" d-none">
                      <input name="hidden" type="text" id="hidden" value="auto">
                  </div>
                  
                  <div class="col-lg-6">
                    <fieldset>
                      <input name="targa" type="text" id="targa" placeholder="TARGA" required="">
                    </fieldset>
                  </div>
                  
                  <div class="col-lg-6">
                    <fieldset>
                      <input name="modello" type="text" id="modello" placeholder="MODELLO" required="">
                    </fieldset>
                  </div>
                  
                   <div class="col-lg-6">
                   	<fieldset>
                  		<select name="park" id="park">
				   		<c:forEach var="park" items="${ParkList}">
				    		<option value="${park.id_parcheggio}">${park.luogo}</option>
				  		</c:forEach>
				  		</select>
				  	 </fieldset>
				  	</div>
				  	
				  <div class="col-lg-6">
                    <fieldset>
                      <input type="file" id="imgUrl" name="imgUrl">
                    </fieldset>
                  </div>
                  
                  <div class="col-lg-12">
                    <fieldset>
                          <button type="submit" id="form-submit" class="button">AGGIUNGI AUTO</button>
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