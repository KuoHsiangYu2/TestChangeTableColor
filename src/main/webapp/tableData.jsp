<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<style type="text/css">
td {
	border-collapse: collapse;
	border-spacing: 0;
	margin: 0;
	padding: 4px;
	height: 30px;
}

table {
	border-collapse: collapse;
	width: 100%;
}

.clickTd {
	color: black;
}

.theSelect {
	color: black;
}
</style>
<title>tableData.jsp</title>
</head>
<body>
	<div align="center">
		<p>tableData.jsp</p>
		<br />
		<div align="left">
			<button id="saveDataButton">儲存勾選列之背景顏色</button>
		</div>
		<br />
		<table id="CustomerTable" border="1">
			<thead>
				<tr>
					<th width="1%">
						<input id="allCheckbox1" type="checkbox" />
					</th>
					<th>顏色</th>
					<th>角色名稱</th>
					<th>角色年齡</th>
					<th>特殊能力</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customerBeanList}" var="unit" varStatus="unitStatus">
					<tr>
						<td width="1%">
							<input type="checkbox" name="selectCheckbox" value="${unit.getCustomerObjKey()}" />
						</td>
						<td>
							<select id="the_select_${unitStatus.index}" class="theSelect">
								<option value="#FFFFFF" style="background-color: #FFFFFF;">請選擇</option>
								<option value="#98CCF6" style="background-color: #98CCF6;">1</option>
								<option value="#CCFFFF" style="background-color: #0099ff;">2</option>
								<option value="#CCFF66" style="background-color: #CCFF66;">3</option>
								<option value="#FFFF66" style="background-color: #FFFF66;">4</option>
								<option value="#FFCC66" style="background-color: #FFCC66;">5</option>
								<option value="#FF9966" style="background-color: #FF9966;">6</option>
							</select>
							<script type="text/javascript">
								/* 設定下拉式選單預設選到到使用者之前選中的項目 */
								var optionUnit = document.getElementById("the_select_${unitStatus.index}");
								optionUnit.value = String("${unit.getBackgroundColor()}").toString();
							</script>
						</td>
						<td>${unit.getRoleName()}</td>
						<td>${unit.getAge()}</td>
						<td>${unit.getAbility()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		var pageContext = String("${pageContext.request.contextPath}").toString();
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tableData.js"></script>
</body>
</html>