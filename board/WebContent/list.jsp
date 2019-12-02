<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet" href="./bootstrap/4.1.3/css/bootstrap.css">
</head>
<body>
<h1>게시글 리스트</h1>
<table class="table">
    <tr>
        <th>번호</th>
        <th>
	        <form action="list.do" > 
	        	<select name="category" onchange="this.form.submit()">
	        		<option value="">카테고리 선택</option>
	        		<option value="all" >모두</option>
	        		<option value="일반" >일반</option>
	        		<option value="공지사항" >공지사항</option>
	        	</select>
	        </form>
        </th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    <c:forEach items="${articleList}" var="article">
        <tr>
            <td>${article.idx}</td>
            <td>${article.category}</td>
            <td><a href="content.do?idx=${article.idx }">${article.title}</a></td>
            <td>${article.writer}</td>
            <td>${article.reg_date}</td>
            <td>${article.hit_count}</td>
        </tr>
    </c:forEach>
</table>
<a href="write.do" class="btn btn-outline-primary">글쓰기</a>
</body>
</html>