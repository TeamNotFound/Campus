<html>
<head>
<title>Inserimento Facoltà</title>
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
						Facoltà</h6>
				</div>
				<div class="card-body">

					<!-- INSERIRE CONTENUTO -->
					<form action="Facolta" method="post">
						<label name="facolta">Facoltà: </label><br> <input
							name="facolta" type="text" /><br>
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
					<h6 class="m-0 font-weight-bold text-primary">Aggiungi corsi a
						Facoltà</h6>
				</div>
				<div class="card-body">

					<!-- INSERIRE CONTENUTO -->
					<form action="CorsiFacolta" method="post">
						<select name="facolta">
							<c:forEach items="${facolta}" var="f">
								<option value="${f.id}">${f.facolta}</option>
							</c:forEach>
						</select> <select name="corso">
							<c:forEach items="${corsi}" var="c">
								<option value="${c.id}">${c.corso}</option>
							</c:forEach>
						</select> <input class="btn btn-success btn-icon-split"
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
					<h6 class="m-0 font-weight-bold text-primary">Rimozione Corsi o Facoltà</h6>
				</div>
				<div class="card-body">

					<!-- INSERIRE CONTENUTO -->

					<table>
						<tr>
							<th>Facolta</th>
							<th>Elimina</th>
						</tr>
						<c:forEach items="${facolta}" var="fac">
							<tr>
								<td><a href="Facolta/${fac.id}">${fac.facolta}</a></td>
								<td><a href="Facolta/delete/${fac.id}">Rimuovi</a></td>
							</tr>
						</c:forEach>
					</table>
					
					<br>

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


					<!-- CONTENUTO -->

				</div>
			</div>
		</div>
		<!-- End Content Column -->



	</div>
	<!-- /.container-fluid -->

</div>
<!-- Fine Contenuto pagina centrale -->


<%@ include file="/views/templates/footer.jspf" %>