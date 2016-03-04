<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Werkzaamheid aanmaken</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<link href="http://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet" type="text/css"></link>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div id="content">
		<form action='WerkzaamheidAanmaken.do' method='get'>
			<div>
				<div>
					<label class="label">Type</label>
					<select name="type" id="type">
						<option value="reparatie">Reparatie</option>
						<option value="onderhoud">Onderhoud</option>
					</select>
				</div>
				<label class="label">Manuren</label>
				<select name="manuren" id="manuren">
					<c:forEach items="${sessionScope.mogelijkeManuren}" var="current">
						<option value="${current}">
							<c:out value="${current}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<label class="label">Opmerkingen</label>
				<textarea name="opmerking" id="opmerking" required cols="40" rows="4" style="resize: none"></textarea>
			</div>
			<div class="button">
				<input type="submit" name="aangemaakt" value="Maak werkzaamheid aan"></input>
			</div>
		</form>
	</div>
</body>
</html>
