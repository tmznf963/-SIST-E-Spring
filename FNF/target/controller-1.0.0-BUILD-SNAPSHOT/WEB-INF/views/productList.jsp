<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <%
   HttpSession Session = request.getSession(true);
   String sellerid="김민호";//String sellerid = request.getParameter("id");// id=넘어오는 name값
   Session.setAttribute("sellerid", sellerid);//세션에 저장
   //${sessionScope.sellerid}
   
   String id = (String)Session.getAttribute("sellerid");//sellerid세션의 값 ="id"
  %>
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
<style>
	th,td{
		text-align :center;
	}
</style>
<script src="js/jquery.min.js"></script> 
<script>
$(function(){
	$.ajax({
		url :  "sellerPL",
		dataType : "json",
		method : "POST",
		success : function(result){
			//alert(typeof result.data[0].price);
			//console.log(result.data);
			var result = result.data;
			if(result.length == 0){
				var str ="";
					str +="<tr><td colspan='9' style='text-align:center'>등록된 상품이 없습니다.</td></tr>";
				$('#ListAll').html(str);
			}else{
				$("#count").text(result.length);//.css({"color" : "blue", "font-weight" : "bold","font-size":"2em"});
				var str="";
				for(var i = 0 ; i <result.length ; i++){
					str +="<tr>";
					str += "<td>";
	                str +="<input name='ck_sub' type='checkbox' value='21'/>";
	                str +="    <input name='prd_prcseq' type='hidden' value='100'/>";
	                str +="</td>";
	                str +="<td>"+result[i].pcode+"</td>";
	                str +="<td>"+result[i].pname+"</td>";
	                str +="<td>";
	                str +="    <img src='img/"+result[i].filename+"' width='50' height='75'/>";
	                str +="</td>";
	                str +="<td>"+result[i].category+"&nbsp;&gt;&nbsp;"+result[i].category2+"</td>";
	                str +="<td class='text-right'>";
	                str +=""+addComma(result[i].price)+"";
	                str +="</td>";
	                str +="<td>"+result[i].sell_num+"</td>";
	                str +="<td>"+result[i].writedate+"</td>";
	                str +="<td>";			//    /sellerPD/{idx}
	                str +="    <a href='sellerPD/"+result[i].idx+"'><button class='btn btn-info btn-xs'  type='button' title='보기'>보기</button></a>";
	                str +="    <button class='btn btn-warning btn-xs'  type='button' title='수정' >수정</button>";
	                str +="    <button class='btn btn-danger btn-xs'  type='button' title='삭제' >삭제</button>";
	                str +="</td>";
					str +="</tr>";
					//<a href='detail/"+result[i].idx+"'> == localhost:8080/fnf/detail/4
				}
				$('#ListAll').html(str);
			}
		},
		error : function(err){
			console.log("err : " +err);
		}
	});//ajax
});//function

//가격 세자리마다 , 찍기
function addComma(num) {
  var regexp = /\B(?=(\d{3})+(?!\d))/g;
  return num.toString().replace(regexp, ',');
}
</script>
</head>
<body>
<!-- ------------------------------------------------------------------------------- -->
<jsp:include page="header.jsp"></jsp:include>
<!-- ------------------------------------------------------------------------------- -->

<section id="aa-popular-category" style="
    padding-top: 0px;
    padding-bottom: 0px;
">
	<div id="wrapper" style="padding-left: 300px; padding-right: 300px;">
		<!-- 사이드바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li><img src="img/user.png" id="us"
					class="img-reponsive img-circle" width="100px" height="100px">
				</li>
				<li><a href="#">[상품관리]</a></li>
				<li><a href="productList.jsp">상품리스트[수정:삭제]</a></li>
				<li><a href="productInsert.jsp">상품등록</a></li>
				<li><a href="#"><hr></a></li>
				<li><a href="#">[주문관리]</a></li>
				<li><a href="orderList.html">전체주문관리</a></li>
				<li><a href="#"><hr></a></li>
				<li><a href="#">[취소|교환|반품|환불]</a></li>
				<li><a href="orderCancel.html">취소내역</a></li>
				<li><a href="orderSwap.html">교환내역</a></li>
				<li><a href="orderReturn.html">반품내역</a></li>
				<li><a href="orderRefund.html">환불내역</a></li>
			</ul>
		</div>
		<!-- /사이드바 -->
<!-- ---------------------상품테이블------------------------------- -->

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12" style="padding-left: 30px;">
        <div class="x_panel">
            <div class="x_title">
            <h2 style="padding-top: 40px;">주문관리</h1>
                <h3>상품 리스트</h3>
                <hr>
                <ul class="nav navbar-right panel_toolbox">
                    <li>[<span id="count"></span> / ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">

                <div class="table-responsive">
                    <table class="table table-hover table1">
                        <thead>
                            <tr>
                                <th>
                                    <input id="ck_main" name="ck_main" type="checkbox" />
                                </th>
                                <th>상품코드</th>
                                <th>상품명</th>
                                <th>상품이미지</th>
                                <th>카테고리</th>
                                <th>판매가</th>
                                <th>판매수</th>
                                <th>등록일</th>
                                <th>관리</th>
                            </tr>
                        </thead>
                        <tbody id="ListAll"></tbody>
                        </table>
                    </div>
<!-- -------------------------------------------------------------------- -->
<!-- -------------------------------------------------------------------- -->
<!-- -------------------------------------------------------------------- -->
<!-- ------------------------------번호판 넣을 자리-------------------------------------- -->

						</div>
                    </div>
                    </div>
                    </div>
                    <hr>
                    
<!-- ------------------------------------------------------ -->
</div>
</section>



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

