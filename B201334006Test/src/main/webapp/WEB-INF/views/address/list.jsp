<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="/common.js"></script>
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>직원 연락처</h1>
  <a href="create" class="btn">직원등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>주소</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="address" items="${ address }">
        <tr data-url="edit?id=${ address.id }">
          <td>${ address.id }</td>
          <td>${ address.name }</td>
          <td>${ address.phone }</td>
          <td>${ address.address }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

