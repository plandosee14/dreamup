<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <div class="container-fluid text-center bg-grey">
	<h2>프로젝트 소개</h2>
	<br>
	<c:forEach items="${projectList}" var="projectList">
		<div class="row text-center">
			<div class="col-sm-4">
				<div class="thumbnail">
					<a href="projectView.do?pro_no=${projectList.pro_no}"><img
						src="img/thumnail/${projectList.pro_thumbnail}"
						alt="${projectList.pro_thumbnail}" width="800" height="600"></a>
					<div class="container">
						<div class="progress">
							<div class="progress-bar progress-bar-striped active"
								role="progressbar" aria-valuenow="${projectList.progress}"
								aria-valuemin="0" aria-valuemax="100"
								style="width: ${projectList.progress}%">${projectList.progress}%</div>
						</div>
					</div>

					<p>
						<strong>타이틀 : ${projectList.pro_title}</strong>
					</p>

					<p>목표 금액 : ${projectList.pro_goal}원</p>
					<p>종료 기간 : ${projectList.pro_end}</p>
					<p>잔여 기간 : ${projectList.due_date}일</p>
					<p>현재 달성률 : ${projectList.progress}%</p>
					<p>후원자 수 : ${projectList.su_count} 명</p>
				</div>
			</div>
	</c:forEach> --%>

<h3>등록 프로젝트 목록</h3>
 <table class="table table-striped">
    <thead>
      <tr>

		<th>#</th>
		<th>타이틀</th>
		<th>카테고리</th>
		<th>마감일</th>
		<th>후원자수</th>
	</tr>
	</thead>

	<c:if test="${!empty myProject.pro_no}">
		<tr>
			<td><a href="projectView.do?pro_no=${myProject.pro_no}"><img
					src="img/thumnail/${myProject.pro_thumbnail}"
					alt="
					${myProject.pro_thumbnail}" width="150" height="150"></a></td>
			<td>${myProject.pro_title}</td>
			<td>${myProject.pro_catagory}</td>
			<td>${myProject.pro_end}</td>
			<td>${myProject.su_count}</td>
		</tr>
	</c:if>

</table>

 <table class="table table-striped">
    <thead>
      <tr>

		<th>후원자</th>
		<th>후원금액</th>
		<th>배송주소</th>
		<th>후원일자</th>
	</tr>
	</thead>
	<c:forEach items="${supportMoneyList}" var="supportMoneyList">
		<tr>
			<th>${supportMoneyList.su_name}</th>
			<th>${supportMoneyList.su_money}</th>
			<th>${supportMoneyList.su_address}</th>
			<th>${supportMoneyList.su_date}</th>
		</tr>
	</c:forEach>