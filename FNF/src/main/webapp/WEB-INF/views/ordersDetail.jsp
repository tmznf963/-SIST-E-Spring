<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Controller에서 받은 data값 -->
<c:set var="order" value="${data}" /> 

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
$(function(){
	
});
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
				<li><hr></li>
				<li>[상품관리]</li>
				<li><a href="/sellerPL">상품리스트</a></li>
				<li><a href="/sellerPR">상품등록</a></li>
				<li><hr></li>
				<li>[주문관리]</li>
				<li><a href="/sellerOL">전체주문관리</a></li>
				<li><hr></li>
				<li>[취소|교환|반품|환불]</li>
				<li><a href="#">취소내역</a></li>
				<li><a href="#">교환내역</a></li>
				<li><a href="#">반품내역</a></li>
				<li><a href="#">환불내역</a></li>
				<li><hr></li>
				<li>[메시지]</li>
				<li><a href="/sellerRMSG">받은메시지</a></li>
				<li><a href="/sellerSMSG">보낸메시지</a></li>
			</ul>
		</div>
		<!-- /사이드바 -->
<!-- ---------------------상품테이블------------------------------- -->
					<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12" style="padding-left: 30px;">
								<div class="x_panel">
									<div class="x_title">
										<h1 style="padding-top: 20px;">주문 관리</h1>
										<h3>주문보기</h3>
										<hr>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">

                <form action="ordermainup" class="form-horizontal"  method="post" >
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <h4><b>주문상품정보</b></h4>
                            <div class="table-responsive">
                                <table class="table table-bordered" >
                                    <thead>
                                        <tr style="background-color: #f1f1f1" >
                                            <th style="text-align: center;">상품이미지</th>
                                            <th style="text-align: center;">상품명</th>
                                            <th style="text-align: center;">상품코드</th>
                                            <th style="text-align: center;">판매가</th>
                                            <th style="text-align: center;">주문수량</th>
                                            <th style="text-align: center;">판매가합</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                            <tr>
                                                <td style="text-align: center;vertical-align: middle;">
                                                    <a href="/productsub/fo/4908/12/productview.sd" target="_blank"><img src="/data/img/pr/thumb/14eb6015a3294a87929699e41cb937fc.jpg" /></a>
                                                </td>
                                                <td style="text-align: center;vertical-align: middle;">
                                                    생화같은 조화
                                                </td>
                                                <td style="text-align: center;vertical-align: middle;">SD-0000000012</td>
                                                <td style="text-align: center;vertical-align: middle;">
                                                    20,000원
                                                </td>
                                                <td style="text-align: center;vertical-align: middle;">
                                                    1
                                                </td>
                                                <td style="text-align: center;vertical-align: middle;">
                                                    20,000원
                                                </td>
                                            </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <h4><b>결제정보</b></h4>
                            <div class="table-responsive">
                                <table class="table table-bordered" >
                                    <colgroup>
                                        <col style="background-color: #f1f1f1;text-align: center" width="20%">
                                        <col width="80%">
                                    </colgroup>
                                    <tr>
                                        <th style="text-align: center;">주문번호</th>
                                        <td>SD_1543216770049</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">결제타입</th>
                                        <td>
                                                무통장입금
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">배송비</th>
                                        <td>
                                            0원
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">사용 적립금</th>
                                        <td>
                                            원
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">지급(예정) 적립금</th>
                                        <td>
                                            원
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">결제금액</th>
                                        <td>
                                            20,000원
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">주문상태</th>
                                        <td>
                                            취소완료
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    
<!-- 										<div class="row form-inline"> -->
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <h4><b>배송정보</b></h4>
                            <div class="table-responsive">
                                <table class="table table-bordered" >
                                    <colgroup>
                                        <col style="background-color: #f1f1f1;" width="20%">
                                        <col width="80%">
                                    </colgroup>
                                    <tr>
                                        <th style="text-align: center;vertical-align: middle;">받으시는 분</th>
                                        <td>
                                            <input class="form-control" id="odma_name" name="odma_name" type="text" value="멤버1" />															
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;vertical-align: middle;">휴대전화</th>
                                        <td>
                                            <input class="form-control" id="odma_phone" name="odma_phone" type="text" value="011-1234-1229" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;vertical-align: middle;">유선전화</th>
                                        <td>
                                            <input class="form-control" id="odma_tel" name="odma_tel" type="text" value="02-1234-1224" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;vertical-align: middle;">배송지</th>
                                        <td>
                                            <input type="button" class="form-control btn btn-info" onclick="getZipcode();" value="우편번호 검색"><br/>
                                            <input type="text" class="form-control" placeholder="우편번호" name="odma_zipcode" id="odma_zipcode" value="34672" readonly="readonly" >
                                            <input type="text" class="form-control" placeholder="기본주소" name="odma_addr1" id="odma_addr1" value="대전 동구 판교1길 3" readonly="readonly" style="margin-top: 5px;">
                                            <input type="text" class="form-control" placeholder="상세주소" name="odma_addr2" value="1" style="margin-top: 5px;">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;vertical-align: middle;">배송업체</th>
                                        <td>
                                            <select class="form-control" id="odm_pccseq" name="odm_pccseq" >
                                                <option value="">선택</option>
                                                
                                                    <option value="1" selected="selected" >우체국</option>
                                                
                                                    <option value="2"  >CJ대한통운</option>
                                                
                                                    <option value="3"  >한진택배</option>
                                                
                                                    <option value="4"  >로젠택배</option>
                                                
                                                    <option value="5"  >KGB택배</option>
                                                
                                                    <option value="6"  >KG옐로우캡택배</option>
                                                
                                                    <option value="7"  >우체국EMS</option>
                                                
                                                    <option value="8"  >디에이치엘</option>
                                                
                                                    <option value="9"  >페덱스</option>
                                                
                                                    <option value="10"  >유피에스</option>
                                                
                                                    <option value="11"  >하나로택배</option>
                                                
                                                    <option value="12"  >대신택배</option>
                                                
                                                    <option value="13"  >일양로지스택배</option>
                                                
                                                    <option value="14"  >포스트박스</option>
                                                
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;vertical-align: middle;">송장번호</th>
                                        <td class="form-inline">
                                            <input class="form-control" id="odm_delinum" name="odm_delinum" type="text" value="121651651651" />
                                            
                                                <a href="http://service.epost.go.kr/trace.RetrieveRegiPrclDeliv.postal?sid1=121651651651" target="_blank">배송추적</a>
                                            
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <h4><b>주문메모</b></h4>
                            <div class="table-responsive">
                                <table class="table table-bordered" >
                                    <colgroup>
                                        <col style="background-color: #f1f1f1;" width="20%">
                                        <col width="80%">
                                    </colgroup>
                                    <tr>
                                        <th style="text-align: center;vertical-align: middle;">주문메모</th>
                                        <td>
                                            <textarea class="form-control" id="odm_memo" name="odm_memo" rows="5" style="width: 100%;"></textarea>															
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-7 col-sm-12 text-right">
                            <button type="button" class="btn btn-success" onclick="dataUp()" ><i class="fa fa-save"></i> 저장</button>
                            <button type="button" class="btn btn-primary" onclick="dataList()"><i class="fa fa-list-ul"></i> 리스트</button>
                        </div>
                        <div class="col-md-5 col-sm-12 text-right">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
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

