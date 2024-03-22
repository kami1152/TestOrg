<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>등록화면</title>
<style>
label {
	display: inline-block;
	width: 120px;
}

input {
	margin-bottom: 10px;
}


</style>
</head>
<body>
	<h1>회원정보 등록양식</h1>
	<form action="user.do">
		<input type="hidden" name="action" value="insert"> 
		<label>아이디 : </label> <input type="text" id="userid" name="userid" value="${user.userid}" > <br/>
        <label>비밀번호 : </label>   <input type="password" id="userpassword" name="userpassword"><br/>
        <label>비밀번호확인 : </label>   <input type="password" id="userpassword2" name="userpassword2"><br/>
        <label>이름 : </label>   <input type="text" id="username" name="username" value="${user.username}"><br/>
        <label>나이: </label>    <input type="text" id="userage" name="userage" value="${user.userage}"><br/>
        <label>이메일: </label>  <input type="text" id="useremail" name="useremail" value="${user.useremail}"><br/>
        <div>
        	<label>직업: </label>  <input type="text" id="userjob" name="userjob" value="${user.userjob}"><br/>
        </div>
        <div>
        <label>취미: </label>
			<input type="radio" id="hobby_sport" name="userhobby" value="운동" ${user.userhobby == '운동' ? 'checked' : ''}>
			<label for="hobby_sport">운동</label>
			<input type="radio" id="hobby_movie" name="userhobby" value="영화" ${user.userhobby == '영화' ? 'checked' : ''}>
			<label for="hobby_movie">영화</label>
			<input type="radio" id="hobby_game" name="userhobby" value="게임" ${user.userhobby == '게임' ? 'checked' : ''}>
			<label for="hobby_game">게임</label>
        
        </div>
		<div>
			<input type="submit" value="등록"> <a href="user.do?action=list">취소</a>
		</div>

	</form>

</body>
</html>