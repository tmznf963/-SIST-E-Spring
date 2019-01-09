<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <header id="aa-header">
    <!-- start header top  -->
    <div class="aa-header-top">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="aa-header-top-area">
              <!-- start header top left -->
              <div class="aa-header-top-left">
              </div>

              <!-- 상단바  -->
              <div class="aa-header-top-right">
                <ul class="aa-head-top-nav-right">
                  <li><a href="#">로그인</a></li>
                  <li class="hidden-xs"><a href="#">회원가입</a></li>
                  <li class="hidden-xs"><a href="#">고객센터</a></li>
                  <!-- <li class="hidden-xs"><a href="#">마이페이지</a></li> -->
                  <!-- <li class="hidden-xs"><a href="checkout.html">Checkout</a></li> -->
                  <li><a href="#" data-toggle="modal" data-target="#login-modal">마이페이지</a></li>
                  <li><a href="#" data-toggle="modal" data-target="#login-modal">장바구니</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- 로그인 확인창 -->  
  <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">                      
        <div class="modal-body">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4>로그인이 필요한 서비스입니다.<br/>로그인 하시겠습니까?</h4>
          <button class="aa-browse-btn" type="submit">로그인</button>
          <button class="aa-browse-btn" type="button" data-dismiss="modal" aria-hidden="true">취소</button>
          <form class="aa-login-form" action="">
            <div class="aa-register-now">
              <a href="#">회원가입 하러가기</a>
            </div>
          </form>
        </div>                        
      </div>
    </div>
  </div>  


<!-- 로고 -->
  <div class="aa-logo">
    <a href="index.html"><img src="img/logo2.png" alt="logo img"></a>
  </div>


  <div class="aa-header-bottom">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="aa-header-bottom-area">
        
              <!-- 검색 창 -->
                <div class="aa-search-box">
                  <form action="">
                    <input type="text" name="search" id="" placeholder="검색어 입력">
                    <button type="submit"><span class="fa fa-search"></span></button>
                  </form>
                </div>

              </div>
            </div>
        </div>
      </div>
    </div>
  <!-- 메뉴 -->
  </header>
   <section id="menu">
    <div class="container">
      <div class="menu-area">
        <!-- Navbar -->
        <div class="navbar navbar-default" role="navigation">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>          
          </div>
          <div class="navbar-collapse collapse">
            <!-- Left nav -->
            <ul class="nav navbar-nav">
              <li><a href="productn.html">농산물<span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="#">채소</a></li>
                  <li><a href="#">과일</a></li>
                  <li><a href="#">쌀·잡곡류</a></li>
                  <li><a href="#">견과류</a></li>                                                
                </ul>
              </li>
              <li><a href="products.html">수산물 <span class="caret"></span></a>
                <ul class="dropdown-menu">  
                  <li><a href="#">생선</a></li>                                                                
                  <li><a href="#">갑각류</a></li>              
                  <li><a href="#">해조류</a></li>
                  <li><a href="#">건어물</a></li>
                </ul>
              </li>
              <li><a href="productg.html">가공식품 <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="#">즙류</a></li>
                  <li><a href="#">분말류</a></li>
                  <li><a href="#">잼류</a></li>
                </ul>
              </li>
             <li><a href="#">추천상품 <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="#">농산물</a></li>
                  <li><a href="#">수산물</a></li>
                  <li><a href="#">가공식품</a></li>               
                </ul>
              </li>
              <li><a href="#">인기상품 <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="#">농산물</a></li>
                  <li><a href="#">수산물</a></li> 
                  <li><a href="#">가공식품</a></li>                 
                </ul>
              </li>
              <li><a href="#">Event</span></a>
                <!-- <ul class="dropdown-menu">                
                  <li><a href="#">진행중인 이벤트</a></li>
                  <li><a href="#">지난 이벤트</a></li>              
                </ul> -->
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>       
    </div>
  </section>
</body>
</html>