<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
  <header class="header-area header-sticky">
      <div class="container">
          <div class="row">
              <div class="col-12">
                  <nav class="main-nav">
                      <!-- ***** Logo Start ***** -->
                      <a href="<%=request.getContextPath()%>" class="logo">
                          CAR SHARING
                      </a>
                      <!-- ***** Logo End ***** -->
                      <!-- ***** Menu Start ***** -->
                      <ul class="nav">
                          <li><a href="<%=request.getContextPath()%>" class="active">Home</a></li>
                          <li><a href="<%=request.getContextPath()%>/Login">Login</a></li>
                         <li class="has-sub">
                          	<a href="#">User</a>
                          	   <ul class="sub-menu">
                          	   	  <li><a href="<%=request.getContextPath()%>/Registrazione">Registrazione</a></li>
                                  <li><a href="<%=request.getContextPath()%>/Prenota">Prenota</a></li>
                              </ul>
                          </li>
                         
                          <li class="has-sub">
                          	<a href="#">Admin</a>
                          	   <ul class="sub-menu">
                          	   	  <li><a href="<%=request.getContextPath()%>/Admin/Home">Pannello Admin</a></li>
                                  <li><a href="<%=request.getContextPath()%>/Admin/Home?action=vediUtenti">Lista Utenti</a></li>
                              </ul>
                          </li>
                          
                          <c:if test="${user != null}">
                          <li class="has-sub account" ><a href="#" class="email">${user.email}&nbsp;</a>
                          	 <ul class="sub-menu ">
                          	      <li><a href="<%=request.getContextPath()%>/Logout">Logout</a></li>
                          	 </ul>
                          </li> 
                          </c:if>
                         
                      </ul>        
                      <a class='menu-trigger'>
                          <span>Menu</span>
                      </a>
                      <!-- ***** Menu End ***** -->
                  </nav>
              </div>
          </div>
      </div>
  </header>