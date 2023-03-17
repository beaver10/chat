<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<html>
<head>
<style>
div.header {
   position: sticky;
   top: 0;
   background-color: blue;
}
a {
	font-weight:bold;
	text-decoration:none;
	color: red;
}
</style>
<title>채팅</title>
<link rel="stylesheet" href="/resources/chat.css" />
<script
   src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
   <div class="chat_wrap">
      <div class="header">
         <h3>채 팅 방 </h3>
      </div>
      <div id="chat"></div>
      <script id="temp" type="text/x-handlebars-template">
      {{#each .}}
      <div class="{{printLeftRight sender}}">
      	<div class="sender" style="display:{{printImg sender}}">
			{{sender}}
		</div>
      	<div class="message">
			{{message}} 
		</div>
      	<div class="date">{{chatDate}}</div>
      </div>
      {{/each}}
      </script>
      <script id="temp1" type="text/x-handlebars-template">
      	<div class="{{printLeftRight sender}}">
      	<div class="sender" style="display:{{printImg sender}}">
			{{sender}}
		</div>
      	<div class="message">
			{{message}}
		</div>
      	<div class="date">{{regdate}}</div>
      	</div>
      </script>
      <script>
         var memberId = "${memberId}";
         Handlebars.registerHelper("printLeftRight", function(sender) {
            if (memberId != sender) {
               return "left";
            } else {
               return "right";
            }
         });
         Handlebars.registerHelper("printNone", function(sender) {
             if (memberId != sender) return "none";             
         });
         Handlebars.registerHelper("printImg", function(sender) {
             if (memberId== sender) return "none";             
         });
      </script>
      <div class="input-div">
         <textarea id="txtMessage" placeholder="메세지를 입력한 후 리턴키를 누르세요!"></textarea>
      </div>
   </div>
</body>
<script type="text/javascript">
   getList();
   var memberId = "${memberId}";

   
   $("#txtMessage").on("keydown", function(e) {
      if (e.keyCode == 13 && !e.shiftKey) {
         e.preventDefault();
         var message = $("#txtMessage").val();
         if (message == "") {
            alert("내용을 입력하세요!");
            return;
         }
         $("#txtMessage").val("");
         
       	 //메세지 테이블에 등록
         $.ajax({
        	 type: "post",
        	 url: "/chat/add",
        	 data: {"sender": memberId, "message":message},
        	 success: function(data){
        		//메세지 보내기...
                sock.send(memberId + "|" + message + "|" + data);
        		//sock.send("insert");
        	 }
         });
      }
   });

   //웹소켓 생성
   var sock = new SockJS("http://localhost/echo/");
   sock.onmessage = onMessage;
   
   //서버로부터 메세지 받기...
   function onMessage(msg) {
      var items = msg.data.split("|");
      var sender = items[0];   
      var message = items[1];
      var id= items[2];
      var date = items[3];
      
      var data = {
         "message" : message,
         "sender" : sender,
         "chatDate" : date,
         "id": id,
      };

      var template = Handlebars.compile($("#temp1").html());
      $("#chat").append(template(data));

      //스크롤바 아래 고정
      window.scrollTo(0, $('#chat').prop('scrollHeight'));
   }

    function getList() {
      $.ajax({
         type : "get",
         url : "/chat.json",
         dataType : "json",
         success : function(data) {
            var template = Handlebars.compile($("#temp").html());
            $("#chat").html(template(data));
         }
      });
   } 
</script>
</html>



