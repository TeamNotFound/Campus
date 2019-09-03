<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento Corsi</title>
</head>
<%@ include file="/views/templates/header.jspf" %>

<!-- Contenuto pagina centrale -->
<div class="container-fluid">

	<!-- Content Row -->
	<div class="row">
<!-- Content Column -->
		<div class="col-lg-12 mb-4">
			<!-- Approach -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">Inserimento
						Corsi</h6>
				</div>
				<div class="card-body">

					<!-- INSERIRE CONTENUTO -->
					<form action="Corso" method="post">
						<label name="corso">Corso: </label><br> <input name="corso"
							type="text" /><br>
							<input class="btn btn-success btn-icon-split"
							type="submit" />
					</form>
					<!-- CONTENUTO -->

				</div>
				</div>
			</div>
		<!-- End Content Column -->
				
		<!-- Content Column -->
			<div class="col-lg-12 mb-4">
			<!-- Approach -->
				<div class="card shadow mb-4">
						<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">Rimozione Corsi</h6>
						</div>
					<div class="card-body">
						
				<table>
						<tr>
							<th>Corsi</th>
							<th>Elimina</th>
						</tr>
						<c:forEach items="${corsi}" var="cor">
							<tr>
								<td>${cor.corso}</td>
								<td><a href="Corso/delete/${cor.id}">Rimuovi</a></td>
							</tr>
						</c:forEach>
					</table>
				
			</div>
		</div>
	</div>
</div>
		<!-- End Content Column -->

<%@ include file="/views/templates/footer.jspf" %>