<html>
<head>
<title>Inserimento Appello</title>
</head>
<%@ include file="/templates/header.jspf" %>

	<!-- Contenuto pagina centrale -->
        <div class="container-fluid">

          <!-- Content Row -->
          <div class="row">

            <!-- Content Column -->
            <div class="col-lg-12 mb-4">
            <!-- Approach -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Inserimento Appello</h6>
                </div>
                <div class="card-body">
					
                <!-- INSERIRE CONTENUTO -->

					<h4>Aggiungi professore</h4>
					<label>Nome professore: ${account.utente.nome}</label><br> <label>Cognome
						professore: ${ account.utente.cognome}</label><br>
					<hr>

					<h4>Aggiungi facolta e corso</h4>



					<form action="AppelloInserimento" method="post">

						<select name="cattedra">
							<c:forEach items="${cattedre}" var="c">
								<option value="${c.facolta.id}-${c.corso.id}">${c.facolta.facolta}
									- ${c.corso.corso}</option>
							</c:forEach>
						</select>


						<h4>Inserimento data appello</h4>
						<label>Data appello</label><br> <input type="date"
							name="data" placeholder="Data">
							
							<input class="btn btn-success btn-icon-split"
							type="submit" name="insData"/>
					</form>

					<!-- CONTENUTO -->

				</div>
              </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- Fine Contenuto pagina centrale -->
      
      
<%@ include file="/templates/footer.jspf" %>

