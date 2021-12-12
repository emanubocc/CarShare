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
               <div class="caption">
                  <h6>Hello Students</h6>
                  <h2>Welcome to Education</h2>
                  <p>This is an edu meeting HTML CSS template provided by <a rel="nofollow" href="https://templatemo.com/page/1" target="_blank">TemplateMo website</a>. This is a Bootstrap v5.1.3 layout. The video background is taken from Pexels website, a group of young people by <a rel="nofollow" href="https://www.pexels.com/@pressmaster" target="_blank">Pressmaster</a>.</p>
                  <div class="main-button-red">
                     <div class="scroll-to-section"><a href="#contact">${result}Join Us Now!</a></div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>
<section class="our-courses" id="courses">
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
            <div class="section-heading">
               <h2>Our Popular Courses</h2>
            </div>
         </div>
         <div class="col-lg-12">
            <div class="owl-courses-item owl-carousel">
               <div class="item">
                  <img src="resources/assets/images/course-01.jpg" alt="Course One">
                  <div class="down-content">
                     <h4>Morbi tincidunt elit vitae justo rhoncus</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$160</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-02.jpg" alt="Course Two">
                  <div class="down-content">
                     <h4>Curabitur molestie dignissim purus vel</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$180</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-03.jpg" alt="">
                  <div class="down-content">
                     <h4>Nulla at ipsum a mauris egestas tempor</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$140</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-04.jpg" alt="">
                  <div class="down-content">
                     <h4>Aenean molestie quis libero gravida</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$120</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-01.jpg" alt="">
                  <div class="down-content">
                     <h4>Lorem ipsum dolor sit amet adipiscing elit</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$250</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-02.jpg" alt="">
                  <div class="down-content">
                     <h4>TemplateMo is the best website for Free CSS</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$270</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-03.jpg" alt="">
                  <div class="down-content">
                     <h4>Web Design Templates at your finger tips</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$340</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-04.jpg" alt="">
                  <div class="down-content">
                     <h4>Please visit our website again</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$360</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-01.jpg" alt="">
                  <div class="down-content">
                     <h4>Responsive HTML Templates for you</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$400</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-02.jpg" alt="">
                  <div class="down-content">
                     <h4>Download Free CSS Layouts for your business</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$430</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-03.jpg" alt="">
                  <div class="down-content">
                     <h4>Morbi in libero blandit lectus cursus</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$480</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="resources/assets/images/course-04.jpg" alt="">
                  <div class="down-content">
                     <h4>Curabitur molestie dignissim purus</h4>
                     <div class="info">
                        <div class="row">
                           <div class="col-8">
                              <ul>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                                 <li><i class="fa fa-star"></i></li>
                              </ul>
                           </div>
                           <div class="col-4">
                              <span>$560</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>
<section class="upcoming-meetings" id="meetings">
   <div class="container">
      <div class="row">
         <div class="col-lg-4">
            <div class="categories">
               <h4>Meeting Catgories</h4>
               <ul>
                  <li><a href="#">Sed tempus enim leo</a></li>
                  <li><a href="#">Aenean molestie quis</a></li>
                  <li><a href="#">Cras et metus vestibulum</a></li>
                  <li><a href="#">Nam et condimentum</a></li>
                  <li><a href="#">Phasellus nec sapien</a></li>
               </ul>
               <div class="main-button-red">
                  <a href="meetings.html">All Upcoming Meetings</a>
               </div>
            </div>
         </div>
         <div class="col-lg-8">
            <div class="row">
               <div class="col-lg-6">
                  <div class="meeting-item">
                     <div class="thumb">
                        <div class="price">
                           <span>$22.00</span>
                        </div>
                        <a href="meeting-details.html"><img src="resources/assets/images/meeting-01.jpg" alt="New Lecturer Meeting"></a>
                     </div>
                     <div class="down-content">
                        <div class="date">
                           <h6>Nov <span>10</span></h6>
                        </div>
                           <h4>New Lecturers Meeting</h4>
                        <p>Morbi in libero blandit lectus<br>cursus ullamcorper.</p>
                     </div>
                  </div>
               </div>
               <div class="col-lg-6">
                  <div class="meeting-item">
                     <div class="thumb">
                        <div class="price">
                           <span>$36.00</span>
                        </div>
                        <a href="meeting-details.html"><img src="resources/assets/images/meeting-02.jpg" alt="Online Teaching"></a>
                     </div>
                     <div class="down-content">
                        <div class="date">
                           <h6>Nov <span>24</span></h6>
                        </div>
                           <h4>Online Teaching Techniques</h4>
                        <p>Morbi in libero blandit lectus<br>cursus ullamcorper.</p>
                     </div>
                  </div>
               </div>
               <div class="col-lg-6">
                  <div class="meeting-item">
                     <div class="thumb">
                        <div class="price">
                           <span>$14.00</span>
                        </div>
                        <a href="#"><img src="resources/assets/images/meeting-03.jpg" alt="Higher Education"></a>
                     </div>
                     <div class="down-content">
                        <div class="date">
                           <h6>Nov <span>26</span></h6>
                        </div>
                           <h4>Higher Education Conference</h4>
                        <p>Morbi in libero blandit lectus<br>cursus ullamcorper.</p>
                     </div>
                  </div>
               </div>
               <div class="col-lg-6">
                  <div class="meeting-item">
                     <div class="thumb">
                        <div class="price">
                           <span>$48.00</span>
                        </div>
                        <a href="meeting-details.html"><img src="resources/assets/images/meeting-04.jpg" alt="Student Training"></a>
                     </div>
                     <div class="down-content">
                        <div class="date">
                           <h6>Nov <span>30</span></h6>
                        </div>
                           <h4>Student Training Meetup</h4>
                        <p>Morbi in libero blandit lectus<br>cursus ullamcorper.</p>
                     </div>
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