<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Werkzaamheden Overzicht</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<link href="http://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet" type="text/css"></link>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
	<div id="content">
		<div>
			<a href="KlantSelectie.jsp">Nieuwe Werkzaamheid Aanmaken</a>
		</div>
		<table>
			<tr>
				<th>Type</th>
				<th>Kenteken</th>
				<th>Klant</th>
				<th>Opmerking</th>
			</tr>
			<c:forEach items="${applicationScope.alleWerkzaamheden}" var="current">
				<tr>
					<td>
						<c:out value="${current.werkzaamheidsType}" />
					</td>
					<td>
						<c:out value="${current.auto.kenteken}" />
					</td>
					<td>
						<c:out value="${current.klant.volledigeNaam}" />
					</td>
					<td>
						<c:out value="${current.opmerkingAanmaken}" />
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>