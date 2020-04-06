<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="margin-top: 1.5rem; margin-bottom: 1.5rem;">
		<div class="row">
			<div class="col-2">
			</div>
			<div class="col-8 text-center">
				<h4>스프링 MVC 5 <mark>게시판</mark></h4>
				<span><strong>Technologies used:</strong></span><br />
				<span>Spring MVC 5, Spring Data JPA, Hibernate, Maven, Bootstrap</span><hr />
			</div>
			<div class="col-2">
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form class="form-inline" style="justify-content: center;" action="search" method="get">
					<select class="form-control" name="searchType" required>
					  <option value="title">제목</option>
					  <option value="author">글쓴이</option>
					</select>
					<input class="form-control" type="text" name="search" placeholder="검색하세요" required>
					<button class="btn btn-outline-success" type="submit">검색</button>
				</form>
				<br />
				<form action="list" method="post">
					<table class="table table-striped">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col" style="width:5%;">Check</th>
					      <th scope="col" style="width:5%;">Index</th>
					      <th scope="col" style="width:50%;">Title</th>
					      <th scope="col" style="width:10%;">Author</th>
					      <th scope="col" style="width:15%;">Date</th>
					      <th scope="col" style="width:5%;">View</th>
					      <th scope="col" style="width:10%;">Action</th>
					    </tr>
					  </thead>
					  <tbody>
						<c:forEach items="${listNotice}" var="notice" varStatus="status">
					  	<tr>
					  	  <th><input type="checkbox" name="del-id" value="${notice.id}"></th>
					      <th scope="row">${status.index + 1}</th>
					      <td>
					      	<a href="detail?id=${notice.id}">${notice.title}</a>
					      </td>
					      <td>${notice.author}</td>
					      <td>
					      	<fmt:formatDate pattern="yyyy년 MM월 dd일" value="${notice.date}"/>
					      </td>
					      <td>
					      	<fmt:formatNumber value="${notice.view}"/>
					      </td>
					      <td>
					      	<a href="edit?id=${notice.id}">Edit</a>
					      </td>
					    </tr>
						</c:forEach>
					  </tbody>
					</table>
					<a href="create" class="btn btn-primary" role="button">Create</a>
					<input type="submit" class="btn btn-danger" name="delete" value="Delete ALL">
				</form>
			</div>
		</div>
	</div>
</body>
</html>