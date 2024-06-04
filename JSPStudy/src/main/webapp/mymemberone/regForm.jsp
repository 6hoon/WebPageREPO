<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet" href="./css/reg-style.css" />
</head>
<body>
	<h1>회 원 가 입</h1>
	<form action="#" method="post">
		<h4>사이트 이용정보 입력</h4>
		<table>
			<tr>
				<td class="title"><label for="id"><b>아이디</b></label></td>
				<td class="content"><span>영문자, 숫자_만 입력가능, 최소 3자이상 입력하세요</span><br />
					<input class="request" type="text" name="id" id="id" size="25"
					minlength="3" maxlength="12" required placeholder="아이디 입력" required />
				</td>
			</tr>
			<tr>
				<td class="title"><label for="pass"><b>비밀번호</b></label></td>
				<td class="content"><span>영문자, 숫자, 특수문자를 포함하여 8-20자를
						입력하세요</span><br /> <input class="request" type="password" name="pass"
					id="pass" size="25" minlength="8" maxlength="20" required
					placeholder="비밀번호 입력" /></td>
			</tr>
			<tr>
				<td class="title"><label for="passCheck"><b>비밀번호 확인</b></label>
				</td>
				<td class="content"><input name="passCheck" id="passCheck"
					class="request" type="text" size="25" minlength="8" maxlength="20"
					required placeholder="비밀번호 확인" /></td>
			</tr>
		</table>

		<h4>개인정보 입력</h4>
		<table>
			<tr>
				<td class="title"><label for="name"><b>이름</b></label></td>
				<td class="content"><input type="text" class="request"
					size="25" minlength="2" maxlength="10" required name="name"
					id="name" /></td>
			</tr>
			<tr>
				<td class="title"><label><b>성별</b></label></td>
				<td class="content" style="display: flex; align-items: center">
					<label for="genderM">M</label> <input type="radio" class="request"
					value="M" name="gender" id="genderM" checked /> /&nbsp; <label
					for="genderM">W</label> <input type="radio" class="request"
					value="W" name="gender" id="genderW" />
				</td>
			</tr>
			<tr>
				<td class="title"><label for="phone2"><b>전화번호</b></label></td>
				<td class="content"><select name="phone1" id="phone1">
						<option value="02">02</option>
						<option value="010">010</option>
				</select> - <input type="text" name="phone2" id="phone2" size="4"
					maxlength="4" /> - <input type="text" name="phone3" size="4"
					maxlength="4" /></td>
			</tr>
			<tr>
				<td class="title"><label for="email"><b>E-mail</b></label></td>
				<td class="content"><input type="text" class="request"
					size="50" minlength="10" maxlength="30" required name="email"
					id="email" /></td>
			</tr>
			<tr>
				<td class="title"><label for="email"><b>주소</b></label></td>
				<td class="content"><input type="text" class="request"
					size="34" required name="zipcode" id="zipcode" />
					<button>우편번호 조회</button> <br /> <input type="text" class="request"
					size="50" required name="address1" id="address1" /> <br /> <input
					type="text" class="request" size="50" required name="address2"
					id="address2" /></td>
			</tr>
		</table>

		<div class="last">
			<button type="submit" class="createAccount">
				<b>회원가입</b>
			</button>
			<button class="cancel"
				onclick="javascript:window.location='loginForm.jsp'">
				<b>취소</b>
			</button>
		</div>
	</form>
</body>
</html>
