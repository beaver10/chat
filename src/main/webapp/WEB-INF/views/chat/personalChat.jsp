<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>채팅방</title>
<!-- <link href="https://fonts.googleapis.com/css2?family=Dokdo&family=Gaegu&family=Gugi&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/css/personalChat.css">
</head>
<body>
<div class="inner">
      <div class="chat-container">
           <div class="title-container">
               <span class="glyphicon glyphicon-list list"></span>
               <span class="title"><i class="fa fa-comments-o" ></i> 채팅</span>
               <span class="glyphicon glyphicon-cog option"></span>
               <div class="function-conatiner">
                   <ul>
                       <li><span class = "glyphicon glyphicon-cog"> 채팅기능</span></li>
                       <li class = " cursor autoReload" ><span class = "glyphicon glyphicon-play"></span> RELOAD자동</li>

                       <li class = " cursor exit-btn"><span class="glyphicon glyphicon-log-out"></span> 채팅방나가기</li>
                   </ul>
               </div>
           </div>
           <div class="print"></div>
          
           <div class="text-container">
	       	 <input type="hidden" id="reciver" value="${dto.memberId}"> 
		 	 <input type="hidden" id="sender" value="${sessionScope.memberId}"> 
			 <input type="hidden" id="room"> 
			 <input type="hidden" id="listSize">
	         <textarea placeholder="메세지를 입력하세요." class="text"></textarea>
	         <span class="send-btn glyphicon glyphicon-send"></span>
         </div>
     </div>
  </div>

  <script type="text/javascript">
	$(".function-conatiner").hide()
	$(".option").click(function () { 
		    $(".function-conatiner").toggle()
	})

	//생성된 룸정보 확인
	checkRoomInfo();
	function checkRoomInfo(){
		let sender = $("#sender").val();
		let reciver = $("#reciver").val();
		$.ajax({
			url: "../chat/getRoomNumber",
			method: "post",
			dataType: "json",
			data: {"sendId":sender, "recvId":reciver},
			success: function(data){
				$("#room").val(data);
				getMessageList();
				return;
			}
		})
	}	

    //메세지 내역 가져오기
	function getMessageList() {
		let sender = $("#sender").val();
		let room = $("#room").val();
		$("#reportRoom").val(room)
		$.ajax({
			url: "../chat/chatList",
			method: "post",
			dataType: "json",
			data: {"sendId":sender, "room":room},
			success: function(data){
				$("#listSize").val(data.length)
				let count = 0;
				if(data.length != 0){
					count = data[0].exitCount;
				}
				let s = "<ul class='show-message'>";
				for(i=0; i<data.length; i++){
					if(sender == data[i].sendId){
						s += "<li class='chat-info'>";
						//본인이 전송한 메세지 관련 정보
						s += "<div class='right-container'>";
						s += "<pre class='sender-content'>"+data[i].content+"</pre>";
						s += "<span class='send-time right-time'>"+data[i].sendTime
						if(data[i].readCheck == 0){
						s += "<span class ='unread-message'>  미확인</span>"
						}
						s += "</span>";
						s += "</div>";
						s += "</li>";
					}else{
		                s += "<li class='chat-info'>";
		                //상대방이 전송한 메세지 관련 정보
		                s += "<div class='left-container'>";
		                // //상대방의 프로필
		                // if(data[i].photo != null){
			            //     s += "<img class='profile-img' src='../profile_image/"+data[i].photo+"' alt='프로필이미지'>";
		                // }else{
			            //     s += "<img class='profile-img' src='../profile_image/basic.jpg' alt='프로필이미지'>";
		                // }
		                s += "<span class='reciver-id'>"+data[i].sendId+"</span>";
		                s += "<pre class='reciver-content'>"+data[i].content+"</pre>";
		                s += "<span class='send-time left-time'>"+data[i].sendTime+"</span>";
		                s += "</div>";
		                s += "</li>";
					}
					//상대방이 채팅방을 나갔을때 보여지는 부분
					if(data[i].exitCount > 0){
						s += "<pre class='exit-message '><span class='glyphicon glyphicon-log-out'></span> 상대방이 채팅방을 나가셨습니다.</pre>"
						$(".text").attr({
							readonly:'readonly',
							placeholder:'메세지 전송이 불가능합니다.'
						})
						$(".send-btn").hide();
				 	}
				}
				
					
				s +="</ul>";
				$(".print").html(s);
				//스크롤을 제일 아래로 내려준다. 
				$(".show-message").scrollTop($(".show-message")[0].scrollHeight);
				
			}
		})
	}
	//메세지 글자 수 체크 최대 1000자
	$(".text").keyup(function(){
		let content = $(this).val()
		let contentSize = (content.length+content.split('\n').length-1);
		if(contentSize > 1000){
			alert("1000자 이하로 입력해주세요")
			$(this).val(content.substring(0, 1000));
			return;
		}
	})

    //메세지 전송
	$(".send-btn").click(function() {
		let sender = $("#sender").val();
		let reciver = $("#reciver").val();
		let content = $(".text").val();
		let room = $("#room").val();
		if(content.trim() == ""){
			alert("메세지를 입력해주세요")
			 $(".text").val("");
			 $(".text").focus("");
			return
		}
		$.ajax({
			url: "../chat/send",
			method: "post",
			data: {"sendId":sender, "recvId":reciver, "content":content, "room":room},
			success: function(){
				$(".text").val("");
				$(".text").focus();
				getMessageList();
			}
		})
		
	});
	//엔터로키로 메세지 전송
	$(".text").keydown(function(key) {
	//13번은 엔터키
    if (key.keyCode == 13) {
    	  //shift키를 누르지 않았을 경우
    	  if (!key.shiftKey){
    		  $('.send-btn').trigger('click');
          }
    	}
	});


    //채팅방 나가기
	$(".exit-btn").click(function() {
		if($("#listSize").val() == 0){
			alert("채팅 내역이 없습니다.")
			return;
		}
		let exitId = $("#sender").val();
		let roomInfo = $("#room").val();
		let check = confirm("채팅방을 나가시 겠습니까?");
		if(check == true){
			$.ajax({
		  		url: "../chat/exit",
				method: "post",
		  		data: {"exitId":exitId, "room":roomInfo},
				success: function(){
					location.href = "list";
					window.close();
				}	
			});
	  		
		}
  	});


    //채팅목록으로 이동하기
	$(".list").click(function() {
		if($("#listSize").val()>0){
			location.href='../chat/list';
		}else{
			alert("채팅 내역이 없습니다.");
			return;
		}
	});

    //단축키로 reload기능 실행
  	$(window).keydown(function(key) {
        if (key.keyCode == 65 && key.shiftKey) {
        	$(".autoReload").trigger('click');
        }else if (key.keyCode == 83 && key.shiftKey) {
        	$(".stopReload").trigger('click');
		}else if (key.keyCode == 90 && key.shiftKey){
        	$(".manualReload").trigger('click');
		} 
    });


    //reload버튼 관련 이벤트
	$(".autoReload").click(function() {
		StartReload()
	})

	//실시간 채팅 실행
   	function StartReload() {
   		getMessageList();
   		alert("auto reload start")
   	   	reload = setInterval(getMessageList, 1000);
   	}
    
    
</script>
</body>
</html>
