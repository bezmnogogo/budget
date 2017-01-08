<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<title></title>
	</head>
	<body>
	<nav>
		<a href="<c:url value="/main"/> ">Главная</a>
		<a href="<c:url value="/records/Overview/"/>">Обзор расходов</a>
		<a href="<c:url value="/categories/"/>">Категории</a>
		<a href="<c:url value="/records/mounthlyRecords"/>">По времени</a>
		<a href="<c:url value="/privateRoom/"/>">Личный кабинет</a>
	</nav>
		<h1> Добавление расходов</h1><h3>${addedMessage}</h3>
		<form method="post" action="<c:url value="/records/addPaidRecord"/> ">
			<div class="sum"> 
				<p>Сумма</p>
				<input type="text" name="sum">
			</div>
			<div>
				<p><input type="date" name="recordDate" max="NOW"></p>
			</div>
			<div>
				<p>
					<select required name="selectedCategory">
						<option selected disabled>Выберите категорию</option>
						<c:forEach var="category" items="${categories}">
							<option value="${category.getType()}">${category.getType()}</option>
						</c:forEach>
					</select>
				</p>
			</div>
			<div>
				<select name="selectedCard">
					<option selected desabled>Выберите карту</option>
					<c:forEach var="card" items="${cards}">
						<option value="${card.getCardNumber()}">${card.getCardNumber()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="person_limit">
				<p>Заметки</p>
				<textarea rows="10" cols="45" name="text"></textarea>
			</div>
			<input type="submit" name="add_button" value="Добавить">
		</form>	
	</body>
</html>
