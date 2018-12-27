<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Controller에서 받은 data값 -->
<c:set var="product" value="${data}" />  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피셔스 앤 파머스</title>
<!-- Font awesome -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">   
<!-- SmartMenus jQuery Bootstrap Addon CSS -->
<link href="css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
<!-- Product view slider -->
<link rel="stylesheet" type="text/css" href="css/jquery.simpleLens.css">    
<!-- slick slider -->
<link rel="stylesheet" type="text/css" href="css/slick.css">
<!-- price picker slider -->
<link rel="stylesheet" type="text/css" href="css/nouislider.css">
<!-- Theme color -->
<link id="switcher" href="css/theme-color/default-theme.css" rel="stylesheet">
<!-- <link id="switcher" href="css/theme-color/bridge-theme.css" rel="stylesheet"> -->
<!-- Top Slider CSS -->
<link href="css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
<!-- Main style sheet -->
<link href="css/style1.css" rel="stylesheet">    
<!-- Google Font -->
<link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
<link href="css/sidebar.css" rel="stylesheet">
<link href="css/style2.css" rel="stylesheet">
<script src="js/jquery.min.js"></script> 
<script>
    function prqsIn(){
		var $prqs_content = $('#prqs_content');
		if( '' == $prqs_content.val() ){
			alert('내용을 입력해주십시오.');
			return;
		}
		if( 400 < $prqs_content.val().length ){
			alert('400자 이하로 작성해주십시오.');
			return;
		}
	}
</script>
</head>
<body>
<!-- ---------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<jsp:include page="header.jsp"></jsp:include>
<!-- ------------------------------------------------------------------------------- -->





<!-- ------------------------------------------------------------------------------- -->
<!-- catg header banner section -->
	
		<section id="aa-catg-head-banner">
			<img src="img/de8eb79d9eee487bb5117bbd9c98c898.jpg" alt="상품상세 배경이미지">
			<div class="aa-catg-head-banner-area">
				<div class="container">
					<div class="aa-catg-head-banner-content">
						<h2>상품상세</h2>
						<ol class="breadcrumb" style="background-color:transparent;">
							<li><a href="/home/fo/index.sd">Home</a></li>
							<li><a>${product.category}</a></li>
							<li> / </li>
							<li><a>${product.category2}</a></li>
						</ol>
					</div>
				</div>
			</div>
		</section>
	
	<!-- / catg header banner section -->

<!-- ------------------------------------------------------------------- -->
	<!-- product category -->
	<section id="aa-product-details">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
				
					<form class="form-horizontal" id="frm" name="frm" method="post">
						
						<div class="aa-product-details-area">
							<div class="aa-product-details-content">
								<div class="row">
									<!-- Modal view slider -->
									<div class="col-md-5 col-sm-5 col-xs-12">
										<div class="aa-product-view-slider">
											<div id="demo-1" class="simpleLens-gallery-container">
												<div class="simpleLens-container">
													<div class="simpleLens-big-image-container">
														<a data-lens-image="img/${product.filename}" class="simpleLens-lens-image">
															<img src="img/${product.filename}" class="simpleLens-big-image">
														</a>
													</div>
												</div>
												<div class="simpleLens-thumbnails-container">
													<!-- <a data-big-image="img/1.jpg" data-lens-image="img/1.jpg" class="simpleLens-thumbnail-wrapper" href="#"> 
														<img src="img/1.jpg" alt="고구마">
													</a> -->
												</div>
											</div>
										</div>
									</div>
									
									<!-- Modal view content -->
									<div class="col-md-7 col-sm-7 col-xs-12">
<!-- 										<div class="table-responsive"> -->
											<table class="table table-pr" style="margin-bottom:5px;">
												<colgroup>
													<col width="30%">
													<col width="70%">
												</colgroup>
												<tr>
													<th class="active text-success">상품명</th>
													<td>${product.pname}</td>
												</tr>
													<tr>
														<th class="active text-success">상품코드</th>
														<td>${product.pcode}</td>
													</tr>
												<tr>
													<th class="active text-success">카테고리</th>
													<td>${product.category} > ${product.category2}</td>
												</tr>
													<tr>
														<th class="active text-success">원산지</th>
														<td>${product.origin}</td>
													</tr>
													<tr>
														<th class="active text-success">단위</th>
														<td>${product.unit}</td>
													</tr>
					                                <tr>
														<th class="active text-success">판매가</th>
														<td><span>${product.price}</span>원</td>
													</tr>
												<tr>
													<th class="active text-success">수량</th>
													<td class="form-inline has-success">
														<input class="form-control" name="product_count" id="product_count" type="number" value="1" onchange="eaCheck(this);"/>
													</td>
												</tr>
											</table>
<!-- 	</div> -->
										
										<div class="row">
											<div class="col-sm-12 col-xs-12">
			                                	<a class="aa-add-to-cart-btn" href="javascript:basketIn('D');" title="바로구매">바로구매</a>
			                                	<a class="aa-add-to-cart-btn" href="javascript:basketIn('N');" title="장바구니">장바구니</a> 
												<a class="aa-add-to-cart-btn" href="javascript:wishIn();" title="관심상품">관심상품</a>
			                                </div>
			                                <div class="col-sm-12 col-xs-12">
			                                </div>
										</div>
									</div>
								</div>
							</div>
							<div class="aa-product-details-bottom">
								<ul class="nav nav-tabs" >
									<li><a href="#description" data-toggle="tab">상품정보</a></li>
									<li><a href="#review" data-toggle="tab">상품문의</a></li>
								</ul>
	
								<!-- Tab panes -->
								<div class="tab-content">
									<div class="tab-pane fade in active" id="description" style="word-break:break-all;overflow: auto">
										<p>${productpcontents}</p>
									</div>
									<div class="tab-pane fade" id="review">
										<div class="aa-product-review-area">
											<h5><span id="prqscnt">0</span>개의 문의가 있습니다.</h5>
											<ul class="aa-review-nav" id="prqsel">
												<!-- 댓글 추가 폼 -->
													<li>
														<div class="media">
															<div class="media-body">
																<strong style="margin-right:10px;">member1</strong>|
																<span style="margin:0 10px 0 10px">2018-12-14 18:12</span>|
																<a href="#" onclick="prqsDel(this,14);return false;" style="margin-left:10px;"><i class="fa fa-trash"></i>삭제</a>
																<p style="margin-top:10px;word-break:break-all;">sdfsdf</p>
															</div>
														</div>
													</li>
												<!-- 댓글 추가 폼 -->
											</ul>
											<!-- review form -->
											<div class="aa-review-form">
												<div class="">
													<label for="prqs_content">상품문의 등록</label>
													<textarea class="form-control" rows="4" id="prqs_content" name="prqs_content" placeholder="400자까지 등록가능합니다."></textarea>
												</div>
												<button type="button" class="btn btn-default aa-review-submit" onclick="prqsIn();" style="margin-top:5px">확인</button>
											</div>
										</div>
									</div>									
								</div>
							</div>
							
							
												
							<!-- Related product -->
			
														
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- / product category -->

  



<!-- ------------------------------------------------------- -->
<!-- footer -->  
  <jsp:include page="footer.jsp"></jsp:include>
 <!-- / footer -->
 <!-- ------------------------------------------------------- -->
 
  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.js"></script>  
  <!-- SmartMenus jQuery plugin -->
  <script type="text/javascript" src="js/jquery.smartmenus.js"></script>
  <!-- SmartMenus jQuery Bootstrap Addon -->
  <script type="text/javascript" src="js/jquery.smartmenus.bootstrap.js"></script>  
  <!-- To Slider JS -->
  <script src="js/sequence.js"></script>
  <script src="js/sequence-theme.modern-slide-in.js"></script>  
  <!-- Product view slider -->
  <script type="text/javascript" src="js/jquery.simpleGallery.js"></script>
  <script type="text/javascript" src="js/jquery.simpleLens.js"></script>
  <!-- slick slider -->
  <script type="text/javascript" src="js/slick.js"></script>
  <!-- Price picker slider -->
  <script type="text/javascript" src="js/nouislider.js"></script>
  <!-- Custom js -->
  <script src="js/custom.js"></script> 
</body>
</html>