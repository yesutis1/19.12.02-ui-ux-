<%@page import="java.sql.*"%>
<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
<link rel="stylesheet" href="./bootstrap/4.1.3/css/bootstrap.css">
</head>
<body>
<h1>게시글 조회</h1>
<c:forEach items="${articleList}" var="article">
<table class="table">
	<tr>
        <th>번호</th>
        <td>${article.idx}</td>
        <th>카테고리</th>
        <td>${article.category}</td>
        <th>글제목</th>
        <td>${article.title}</td>
        <th>작성자</th>
        <td>${article.writer}</td>
        <th>작성일</th>
        <td>${article.reg_date}</td>
        <th>수정일</th>
        <td>${article.mod_date}</td>
        <th>조회수</th>
        <td>${article.hit_count}</td>
    </tr>
    <tr>
    	<th colspan="2">제목</th>
        <td colspan="7">${article.title}</td>
    </tr>
    <tr>
    	<th colspan="2">내용</th>
        <td colspan="7">${article.content}</td>
    </tr>
</table>
<a href="delete.do?idx=${article.idx}" class="btn btn-outline-danger btn-sm">게시글 삭제</a>
<a href="modify.do?idx=${article.idx}" class="btn btn-outline-success btn-sm">게시글 수정</a>
</c:forEach>
<a href="list.do" class="btn btn-outline-primary btn-sm">목록으로</a>
</body>
</html>