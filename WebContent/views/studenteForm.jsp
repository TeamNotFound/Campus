<html>
<head>
<title>Inserimento Studente</title>
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
                  <h6 class="m-0 font-weight-bold text-primary">Inserimento Studente</h6>
                </div>
                <div class="card-body">
					
                <!-- INSERIRE CONTENUTO -->
					<form action="Studente" method="post">
						<label for="nome">Nome: </label><br> <input id="nome"
							name="nome" type="text"><br> <label for="cognome">Cognome:
						</label><br> <input id="cognome" name="cognome" type="text"><br>

						<label for="nascita-data">Data Nascita</label><br> <input
							type="date" id="nascita-data" name="nascita-data" /><br> <label
							for="nascita-luogo">Luogo Nascita</label><br> <input
							type="text" id="nascita-luogo" name="nascita-luogo" /><br> <label
							for="fiscale">Codice Fiscale</label><br> <input type="text"
							id="fiscale" name="fiscale" /><br> <label for="sesso">Sesso:</label><br>

						<input type="radio" id="uomo" name="sesso" value="uomo" /> <label
							for="uomo">Uomo</label><br> <input type="radio" id="sesso"
							name="sesso" value="donna" /> <label for="donna">Donna</label><br>

						<label for="facolta">Facoltà: </label><br> <select
							id="facolta" name="facolta">
							<c:forEach items="${facolta}" var="fac">
								<option value="${fac.id}">${fac.facolta}</option>
							</c:forEach>
						</select><br> <label for="username">Username: </label><br> <input
							id="username" name="username" type="text"><br> <label
							for="password">Password: </label><br> <input id="password"
							name="password" type="password"><br>

						<input class="btn btn-success btn-icon-split" type="submit" />
					</form>
					<!-- CONTENUTO -->

				</div>
              </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- Fine Contenuto pagina centrale -->
      
      
<%@ include file="/views/templates/footer.jspf" %>