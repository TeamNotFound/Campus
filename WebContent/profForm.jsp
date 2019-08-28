<html>
<head>
<title>Inserimento Professore</title>
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
                  <h6 class="m-0 font-weight-bold text-primary">Inserimento Professore</h6>
                </div>
                <div class="card-body">
					
                <!-- INSERIRE CONTENUTO -->
					<form action="InserimentoProfessore" method="post">

						<label for="nome">Nome Professore</label><br> <input
							type="text" id="nome" name="nome" /><br> <label
							for="cognome">Cognome Professore</label><br> <input
							type="text" id="cognome" name="cognome" /><br> <label
							for="nascita-data">Data Nascita</label><br> <input
							type="date" id="nascita-data" name="nascita-data" /><br> <label
							for="nascita-luogo">Luogo Nascita</label><br> <input
							type="text" id="nascita-luogo" name="nascita-luogo" /><br> <label
							for="fiscale">Codice Fiscale</label><br> <input type="text"
							id="fiscale" name="fiscale" /><br> <label for="sesso">Sesso:</label><br>

						<input type="radio" id="uomo" name="sesso" value="uomo" /> <label
							for="uomo">Uomo</label><br> <input type="radio" id="sesso"
							name="sesso" value="donna" /> <label for="donna">Donna</label><br>

						<label for="titoli">Titoli di studio</label><br> <input
							type="text" id="titoli" name="titoli" /><br>

						<hr>

						<label for="username">Username</label><br> <input type="text"
							id="username" name="username" /><br> <label for="password">Password</label><br>
						<input type="text" id="password" name="password" /><br>
						<input class="btn btn-success btn-icon-split"
							type="submit" />

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