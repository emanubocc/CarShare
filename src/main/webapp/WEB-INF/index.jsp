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
         <div class="row mt-5 pt-5">
         

         
            <div class="col-lg-6">
               <div class="caption p-4">
                  <h6>Corso di Programmazione 3</h6>
                  <h2>Progetto Esame <br><span style="color:#f5a425; font-size:46px; line-height:48px; letter-spacing:2px">CAR SHARING</span></h2>
                  <p>WebApp che sviluppa un' applicazione dedicata al Car Sharing. Basato sui principi della programmazione SOLID.
                  Sviluppata in linguaggio Java.
                  Tecnologie utilizzate: Java Servlet, Jsp (Java Servlet Pages), Javascript, JQuery, Html e CSS.</p>
                  <div class="main-button-red">
                     <div class="scroll-to-section"><a href="<%=request.getContextPath()%>/Registrazione">Registrati ora</a></div>
                  </div>
               </div>
            </div>
         
            <div class="col-lg-6 animated">
         		 <img src="<%=request.getContextPath()%>/resources/assets/images/hero-img.png" class="img-fluid float-end " style="width:450px;
    background: white; border-radius: 50%; margin-top:-30px; ">
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