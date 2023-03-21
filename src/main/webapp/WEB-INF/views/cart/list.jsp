<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
 
    $("#btnList").click(function(){
        location.href="${path}/product/list";
    });
 
    $("#btnDelete").click(function(){
        if(confirm("장바구니를 비우시겠습니까?")){
            location.href="${path}/cart/deleteAll";
        }
    });
});
</script>
</head>
<body>
<h2>장바구니</h2>
<c:choose>
    <c:when test="${map.count == 0 }">
		장바구니가 비었습니다.
    </c:when>
    
    <c:otherwise>
    <!-- map.count가 0이 아닐때, 즉 자료가 있을때 -->
    <!-- form을 실행한다.  -->
    <!-- form의 id를 form1로 하고, method 방식을 post로 한다. 그리고 update페이지로 이동시킨다. -->
        <form id="form1" name="form1" method="post" action="/cart/update">
            <table border="1" style="width:400px">
                <tr>
                    <th>상품명</th>
                    <th>단가</th>
                    <th>수량</th>
                    <th>금액</th>
                    <th>&nbsp;</th>
                </tr>
                <!-- map에 있는 list출력하기 위해 forEach문을 사용해 row라는 변수에 넣는다. -->
            <c:forEach var="row" items="${map.list}">
                <tr align="center">
                    <td>${row.productNum}</td>
                    
                    <td>                  
	                    <!-- fmt:formatNumber 태그는 숫자를 양식에 맞춰서 문자열로 변환해주는 태그이다 -->
	                    <fmt:formatNumber value="${row.productPrice}" pattern="#,###,###" />
                    </td>                            
                            
                    <td>
                    	<input type="number" name="cartAmount" style="width:30px;" value="<fmt:formatNumber value="${row.cartAmount}" pattern="#,###,###" />">
                        <input type="hidden" name="cartNum" value="${row.cartNum}">                                                           
                    </td>
                    <td>
                    	<fmt:formatNumber value="${row.money}" pattern="#,###,###" />
                    </td>
                    <td>
                    	<a href="${path}/cwl/cart/delete?cartNum=${row.cartNum}">[삭제]</a>
                    </td>
                </tr>
            </c:forEach>
                <tr>
                    <td colspan="5" align="right">
                        장바구니 금액 합계 :
                        <fmt:formatNumber value="${map.sumMoney}"
                            pattern="#,###,###" /><br>
                        배송료 : ${map.fee}<br>
                        총합계 : <fmt:formatNumber value="${map.sum}"
                            pattern="#,###,###" />
                    </td>
                </tr>
            </table>
            <button id="btnUpdate">수정</button>
            <button type="button" id="btnDelete">장바구니 비우기</button>

        </form>
    </c:otherwise>
</c:choose>
<button type="button" id="btnList">상품목록</button>
</body>
</html>