<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String loginID = (String) session.getAttribute("loginID");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>log in</title>
<link rel="stylesheet" href="./css/login-style.css" />
</head>
<body>
	<%
	if (loginID == null) { // 로그인 전
	%>
	<form action="loginProc.jsp" method="post">
		<fieldset style="margin: 0 auto; width: 330px">
			<legend style="margin: 0 auto; text-align: center">
				<h1>로그인</h1>
			</legend>

			<div class="con">
				<div class="login">
					<div>
						<input type="text" name="userId" id="id" placeholder="ID"
							size="30" /><br /> <input type="text" name="pass"
							placeholder="PASSWORD" size="30" />
					</div>
					<input class="loginLogo" type="submit" name="login" id="login"
						value="로그인" />
				</div>

				<div class="loginBot">
					<button type="button" onclick="javascript:window.location='regForm.jsp'">회원가입</button>
					<button type="button" onclick="#">아이디 찾기</button>
					<button type="button" onclick="#">비밀번호 찾기</button>
				</div>
			</div>
		</fieldset>
	</form>
	<%
	} else { // 로그인 후
	%>

	<%
	}
	%>
</body>
</html>