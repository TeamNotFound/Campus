<html>
<head>
<title>Prenotazione Esame</title>
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
                  <h6 class="m-0 font-weight-bold text-primary">Prenotazione Esame</h6>
                </div>
                <div class="card-body">
					
                <!-- INSERIRE CONTENUTO -->
					<h4>Studente</h4>
					<h6>Nome: ${account.utente.nome }</h6>
					<h6>Cognome: ${account.utente.cognome }</h6>
					<hr>
					<h4>Appello</h4>
					<br>
					<h6>Facolta: ${dataPrenotata.facolta.facolta }</h6>
					<h6>Corso: ${dataPrenotata.corso.corso }</h6>
					<h6>Professore: ${dataPrenotata.professore.cognome }
						${dataPrenotata.professore.nome }</h6>
					<h6>Data appello: ${dataPrenotata.dataAppello}</h6>
					<hr>

					<h6>Prenotati</h6>
					<form
						action="/Campus/Prenotazione/PrenotazioneEsame/${ dataPrenotata.id}"
						method="post">
						<input type="hidden" name="dataPrenotaId"
							value=${dataPrenotata.id }>
							
							<input class="btn btn-success btn-icon-split" type="submit" value="Invia"/>
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