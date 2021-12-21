<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>

<c:set var="pageTitle" scope="request" value="Prenotazione"/>

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
        <div class="col-lg-6 align-self-center">
          <div class="row">
            <div class="col-lg-12">

              <form id="simple-form" action="UserProfile" method="post">
                <div class="row">
                
                  <div class="col-lg-12">
                    <h2>Prenotazione</h2>
                  </div>
                  
                  <div class="col-lg-12">
                    <fieldset>
                     <span class="p-2">Data inizio noleggio:</span>
                      <input name="data_inizio" type="date" id="data_inizio" onblur="calcolaTotale()">
                    </fieldset>
                  </div>
                  <hr class="blank">
                  <div class="col-lg-12">
                    <fieldset>
                     <span class="p-2">Data consegna noleggio:</span>
                       <input name="data_consegna" type="date" id="data_consegna" onblur="calcolaTotale()">
                    </fieldset>
                  </div>
                  <hr class="blank">
                  <div class="col-lg-6">
                    <fieldset>
                     <span class="p-2">Percorrenza:</span>
                    <input name="percorrenza" type="number" id="percorrenza" onblur="calcolaTotale()" >
                  </fieldset>
                  </div>
                  
				   <div class="col-lg-6">
                   	<fieldset>
                   	 <span class="p-2">Scegli parcheggio:</span>
                  		<select name="park" id="park">
				   		<c:forEach var="park" items="${ParkList}">
				    		<option value="${park.id_parcheggio}">${park.luogo}</option>
				  		</c:forEach>
				  		</select>
				  	 </fieldset>
				  	</div>
					
				  <hr class="blank">
                  <div class="col-lg-6">
                     <span class="p-2">Totale stimato in euro :  <input type="text" name="total" id="total" class="white-bg" disabled/></span>
                  </div>
                   
                  <div class="col-lg-6">
                    <fieldset>
                          <button type="submit" id="form-submit" class="button float-end">PRENOTA</button>
                    </fieldset>
                  </div>
                </div>
              </form>
              <c:if test="${result != null}">
             	 <c:choose>
			  		<c:when test="${result == 'Success'}">
						<div class="alert alert-success mt-2" role="alert">
							<p>Inserimento prenotazione avvenuto con successo!</p>
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

<script>
function calcolaTotale(){
  
	const date1 = new Date( document.getElementById('data_inizio').value );
	const date2 = new Date( document.getElementById('data_consegna').value );
	
	const diffTime = Math.abs(date2 - date1);
	const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)); 
    var percorrenza = document.getElementById('percorrenza').value;
    
    var tot = 0;
    tot = (diffDays*50) + (percorrenza*0.75);
    
    document.getElementById('total').value = tot;
}
</script>

<!-- FINE FOOTER --> 
</body>

</html>