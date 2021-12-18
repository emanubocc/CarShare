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
        <div class="col-lg-6 align-self-center">
          <div class="row">
            <div class="col-lg-12">

              <form id="simple-form" action="Registrazione" method="post">
                <div class="row">
                
                  <div class="col-lg-12">
                    <h2>REGISTRAZIONE</h2>
                  </div>
                  
                  <div class="col-lg-6">
                    <fieldset>
                      <input name="nome" type="text" id="nome" placeholder="NOME" required="">
                    </fieldset>
                  </div>
                  
                  <div class="col-lg-6">
                    <fieldset>
                      <input name="cognome" type="text" id="cognome" placeholder="COGNOME" required="">
                    </fieldset>
                  </div>
                  
                  <div class="col-lg-6">
                    <fieldset>
                    <input name="email" type="text" id="email" pattern="[^ @]*@[^ @]*" placeholder="EMAIL..." required="">
                  </fieldset>
                  </div>
                  
                  <div class="col-lg-6">
                    <fieldset>
                    <input name="tel" type="tel" id="tel" placeholder="TELEFONO..." required="">
                  </fieldset>
                  </div>
                  
                  <div class="col-lg-12">
                    <fieldset>
                       <span class="p-2" style="font-size:10px">Utilizza una password forte, almeno 8 caratteri una lettera maiuscola numeri e simboli:</span>
                    <input class="m-0" name="password" type="password" id="password" placeholder="PASSWORD..." required="">
						
						<div class="p-2">
							<progress id="strength" value="0" max="5"></progress>
						</div>

                  </fieldset>
                  </div>
                  
                  <div class="col-lg-12">
                    <fieldset>
                          <button type="submit" id="form-submit" class="button mt-2">REGISTRATI</button>
                    </fieldset>
                  </div>
                </div>
              </form>
              <c:if test="${resultLogin != null}">
             	 <c:choose>
			  		<c:when test="${resultLogin == 'Success'}">
						<div class="alert alert-success mt-2" role="alert">
							<p>Inserimento avvenuto con successo!</p>
						</div>	
					</c:when>
					<c:otherwise>
						<div class="alert alert-danger mt-2" role="alert">
							<p>Errore: ${resultLogin}</p> 
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
function passwordStrength(pw) {
	  return /.{4,}/.test(pw) * (  /* at least 8 characters */
	    /.{8,}/.test(pw)          /* bonus if longer */
	    + /[a-z]/.test(pw)         /* a lower letter */
	    + /[A-Z]/.test(pw)         /* a upper letter */
	    + /\d/.test(pw)            /* a digit */
	    + /[^A-Za-z0-9]/.test(pw)  /* a special character */
	   )
	}

	let pwInput = document.getElementById("password")

	 pwInput.addEventListener('keyup', function() { 
	 document.getElementById("strength").value = 
	 passwordStrength(pwInput.value)
	})
</script>

<!-- FINE FOOTER --> 
</body>

</html>