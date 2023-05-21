<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../index/css/nav.css" />
<link rel="stylesheet" href="css/member.css" />
<title>manager.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">USERNAME</th>
				<th scope="col">PASSWORD</th>
				<th scope="col">NICKNAME</th>
				<th scope="col">PASS</th>
				<th scope="col">ROLE</th>
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty memberList}">
				<c:forEach var="member" items="${memberList}">
					<tr>
						<td>${member.id}</td>
						<td id="username${member.id}">${member.username}</td>
						<td id="password${member.id}">${member.password}</td>
						<td id="nickname${member.id}" contenteditable="true">${member.nickname}</td>
						<td>
							<select id="pass${member.id}">
								<option value="0">false</option>
								<option value="1" <c:if test="${member.pass}">selected</c:if>>true</option>
							</select>
						</td>
						<td>
							<select id="roleId${member.id}">
								<option value="1">Admin</option>
								<option value="2" <c:if test="${member.roleId == 2}">selected</c:if>>User</option>
							</select>
						</td>
						<td>
							<button type="button" class="btn btn-dark" onclick="onSaveClick(${member.id})">Save</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger" onclick="onRemoveClick(${member.id})">Remove</button>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<div id="msg" class="error"></div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>
	<script src="../index/js/nav.js"></script>
	<script src="js/manage.js"></script>
</body>
</html>