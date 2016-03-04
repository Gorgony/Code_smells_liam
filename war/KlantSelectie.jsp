<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Selecteer Klant</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<link href="http://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet" type="text/css"></link>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function toggle() {
		var e = document.getElementById("klant");
		var choice = e.options[e.selectedIndex].value;
		var e2 = document.getElementById("nieuweKlantGegevens");
		if (choice == "nieuweKlant") {
			e2.style.visibility = "visible";
			document.getElementById("voornaam").required = true;
			document.getElementById("achternaam").required = true;
			document.getElementById("geboortedatum").required = true;
			document.getElementById("straatnaam").required = true;
			document.getElementById("huisnummer").required = true;
			document.getElementById("postcode").required = true;
			document.getElementById("woonplaats").required = true;
		} else {
			e2.style.visibility = "hidden";
			document.getElementById("voornaam").required = false;
			document.getElementById("achternaam").required = false;
			document.getElementById("geboortedatum").required = false;
			document.getElementById("straatnaam").required = false;
			document.getElementById("huisnummer").required = false;
			document.getElementById("postcode").required = false;
			document.getElementById("woonplaats").required = false;
		}
	}
</script>
</head>
<body>
	<div id="content">
		<form action='KlantAanmaken.do' method="get">
			<div>
				<label class="label">Klant</label>
				<select name="klant" id="klant" onchange="toggle()">
					<option value="nieuweKlant">Nieuwe Klant</option>
					<c:forEach items="${applicationScope.alleKlanten}" var="current">
						<option value="${current.voornaam}-${current.tussenvoegsel}-${current.achternaam}">
							<c:out value="${current.volledigeNaam}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<div id="nieuweKlantGegevens">
				<div>
					<label class="label">Voornaam</label>
					<input type="text" name="voornaam" id="voornaam" placeholder="Voornaam" required></input>
				</div>
				<div>
					<label class="label">Tussenvoegsel</label>
					<input type="text" name="tussenvoegsel" id="tussenvoegsel" placeholder="Tussenvoegsel"></input>
				</div>
				<div>
					<label class="label">Achternaam</label>
					<input type="text" name="achternaam" id="achternaam" placeholder="Achternaam" required></input>
				</div>
				<div>
					<label class="label">Geboortedatum</label>
					<input type="date" name="geboortedatum" id="geboortedatum" required></input>
				</div>
				<div>
					<label class="label">Straatnaam</label>
					<input type="text" name="straatnaam" id="straatnaam" placeholder="Straatnaam" required></input>
				</div>
				<div>
					<label class="label">Huisnummer</label>
					<input type="number" min="1" name="huisnummer" id="huisnummer" placeholder="Huisnummer" required></input>
				</div>
				<div>
					<label class="label">Toevoeging</label>
					<input type="text" name="toevoeging" id="toevoeging" placeholder="Toevoeging"></input>
				</div>
				<div>
					<label class="label">Postcode</label>
					<input type="text" name="postcode" id="postcode" placeholder="Postcode" required></input>
				</div>
				<div>
					<label class="label">Woonplaats</label>
					<input type="text" name="woonplaats" id="woonplaats" placeholder="Woonplaats" required></input>
				</div>
			</div>
			<div class="button">
				<input type="submit" value="Volgende"></input>
			</div>
		</form>
	</div>
</body>
</html>