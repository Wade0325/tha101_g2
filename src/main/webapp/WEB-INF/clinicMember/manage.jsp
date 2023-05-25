<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../index/css/nav.css" />
<link rel="stylesheet" href="css/member.css" />
<title>manager.jsp</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>
<body>
	<table class="table" border="1" cellpadding="10">
		<thead>
			<tr>
				<th scope="col">診所編號</th>
				<th scope="col">診所名稱</th>
				<th scope="col">診所負責人</th>
				<th scope="col">診所信箱</th>
				<th scope="col">診所密碼</th>
				<th scope="col">診所電話</th>
				<th scope="col">診所會員創建日期</th>
				<th scope="col">診所地址</th>
				<th scope="col">診所照片</th>
				<th scope="col">診所服務</th>
				<th scope="col">診所會員最後更新日期</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty clinicMemberList}">
				<c:forEach var="clinicMember" items="${clinicMemberList}">
					<tr>
						<td>${clinicMember.clinicId}</td>
						<td id="clinicName${clinicMember.clinicId}" contenteditable="true">${clinicMember.clinicName}</td>
						<td id="clinicPrincipal${clinicMember.clinicId}"
							contenteditable="true">${clinicMember.clinicPrincipal}</td>
						<td id="clinicEmail${clinicMember.clinicId}"
							contenteditable="true">${clinicMember.clinicEmail}</td>
						<td id="clinicPassword${clinicMember.clinicId}"
							contenteditable="true">${clinicMember.clinicPassword}</td>
						<td id="clinicPhone${clinicMember.clinicId}"
							contenteditable="true">${clinicMember.clinicPhone}</td>
						<td id="clinicMemberCreateDate${clinicMember.clinicId}">${clinicMember.clinicMemberCreateDate}</td>
						<td id="clinicAddress${clinicMember.clinicId}"
							contenteditable="true">${clinicMember.clinicAddress}</td>
						<td id="clinicPhoto${clinicMember.clinicId}"
							contenteditable="true">${clinicMember.clinicPhoto}</td>
						<td id="clinicService${clinicMember.clinicId}"
							contenteditable="true">${clinicMember.clinicService}</td>
						<td id="clinicMemberLastUpdateDate${clinicMember.clinicId}">${clinicMember.clinicMemberLastUpdateDate}</td>

						<td>
							<button type="button" class="btn btn-dark"
								onclick="onSaveClick(${clinicMember.id})">Save</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger"
								onclick="onRemoveClick(${clinicMember.id})">Remove</button>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<div id="msg" class="error"></div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>
	<script src="../index/js/nav.js"></script>
	<script src="js/manage.js"></script>
</body>
</html>