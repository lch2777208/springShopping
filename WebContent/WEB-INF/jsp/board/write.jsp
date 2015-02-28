<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
<html>
<head>
</head>
<body>
<!-- <div class="borderLine" style="margin-left: 20px; margin-top: 20px;">
		<form action="" role="form" method="post">
			<div class="form-group">
				<label for="title">제목</label> 
				<input type="text" id="title" name="title" size="20" class="form-control" placeholder="제목"/>
			</div>
	
			<div class="form-group">
				<label for="writerName">이름</label> 
				<input type="text" id="writerName" name="writerName" class="form-control" placeholder="이름"/>
			</div>

			<div class="form-group">
				<label for="password">암호</label> 
				<input type="password" id="password" name="password" class="form-control" placeholder="암호"/>
			</div>

			<div class="form-group">
				<label for="content">내용</label> 
				<textarea id="content" name="content" class="form-control" cols="40" rows="5"></textarea>
			</div>
			
			<button id="btn_submit" class="btn btn-default">작성</button>
		</form>
	</div>
	
	<script>
		//글쓰기를 AJAX로 구현 해볼까??
		$(function(){
		 $("#btn_submit").click(function(){
			$.ajax({
				url:"WriteBoard",
				type:"post",
				data: {	"title" : $("#title").val(),
						"writerName" :$("#writerName").val(),
						"password" :$("#password").val(),
						"content" : $("#content").val()						
						}, 
				dataType: "json",   // 데이터타입을 JSON형식으로 지정
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				success: function(data,textStaus,jqXHR){
					
				},
				error:function(jqXHR,textStatus,errorThrown){
					
				}
			})

		 });
	 });
	</script> -->
<form:form modelAttribute="boardDto" action="../board/write.html" id="boardForm" method="post">
	제&nbsp;&nbsp;목 : <form:input path="title" cssClass="title" type="text" name="title" /><br/><br/>
	작성자 : <form:input path="writerName" cssClass="writerName" type="text" name="writerName" /><br/><br/>
	본&nbsp;&nbsp;문 : <form:textarea path="content" cssClass="content" name="content" rows="10"></form:textarea><br/><br/>
	<input type="submit" />
</form:form>
</body>

<script>
	$("#boardForm").on("submit", function() {
		var title = $("[name=title]").val()
		var writer = $("[name=writerName]").val()
		var content = $("[name=content]").val()
		if (title == null || title == "") { 
			alert('제목을 입력하세요');
			document.forms[0].title.focus(); 
			return false;
		}
		if (writer == null || writer == "") {
			alert('작성자를 입력하세요');
			document.forms[0].writer.focus();
			return false;
		}

		if (content == null || content == "") {
			alert('내용을 입력하세요');
			document.forms[0].content.focus();
			return false;
		}
	})
</script>
</html>