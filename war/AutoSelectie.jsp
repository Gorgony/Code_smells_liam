<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Selecteer Auto</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<link href="http://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet" type="text/css"></link>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function toggle() {
		var e = document.getElementById("auto");
		var choice = e.options[e.selectedIndex].value;
		var e2 = document.getElementById("nieuweAutoGegevens");
		if (choice == "nieuweAuto") {
			e2.style.visibility = "visible";
			document.getElementById("merk").required = true;
			document.getElementById("model").required = true;
			document.getElementById("kenteken").required = true;
			document.getElementById("bouwjaar").required = true;
		} else {
			e2.style.visibility = "hidden";
			document.getElementById("merk").required = false;
			document.getElementById("model").required = false;
			document.getElementById("kenteken").required = false;
			document.getElementById("bouwjaar").required = false;
		}
	}
</script>
</head>
<body>
	<div id="content">
		<form action='AutoAanmaken.do' method='get'>
			<div>
				<label class="label">Auto</label>
				<select name="auto" id="auto" onchange="toggle()">
					<option value="nieuweAuto">Nieuwe Auto</option>
					<c:forEach items="${geselecteerdeKlant.alleAutos}" var="current">
						<option value="${current.kenteken}">
							<c:out value="${current.kenteken}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<div id="nieuweAutoGegevens">
				<div>
					<label class="label">Merk</label>
					<input type="text" name="merk" id="merk" placeholder="Merk" required></input>
				</div>
				<div>
					<label class="label">Model</label>
					<input type="text" name="model" id="model" placeholder="Model" required></input>
				</div>
				<div>
					<label class="label">Kenteken</label>
					<input type="text" name="kenteken" id="kenteken" placeholder="Kenteken" required></input>
				</div>
				<div>
					<label class="label">Bouwjaar</label>
					<input type="number" min="1900" name="bouwjaar" id="bouwjaar" max="${sessionScope.huidigJaar}" required></input>
				</div>
			</div>
			<div class="button">
				<input type="submit" value="Volgende"></input>
			</div>
		</form>
	</div>
</body>
</html>