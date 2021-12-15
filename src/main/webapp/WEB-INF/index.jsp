<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>

<c:set var="pageTitle" scope="request" value="Homepage"/>

<!-- HEAD -->
<jsp:include page="includes/cs-head.jsp"></jsp:include>
<!-- FINE HEAD -->

<body>
<!-- MENU -->
<jsp:include page="includes/cs-menu.jsp"></jsp:include>
<!-- FINE MENU -->


<!-- CONTENT -->
<section class="section main-banner" id="top" data-section="section1">
   <div class="header-text">
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <div class="caption p-2">
                  <h6>Corso di Programmazione 3</h6>
                  <h2>Progetto Esame - CAR SHARING</h2>
                  <p>WebApp che sviluppa un applicazione dedicata al Car Sharing. Realizzata mediante l'uso di Servlet come controllo e Jsp che fanno da presentation layer.</p>
                  <div class="main-button-red">
                     <div class="scroll-to-section"><a href="<%=request.getContextPath()%>/Registrazione">Registrati ora</a></div>
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