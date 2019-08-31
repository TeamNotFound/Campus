<html>
<head>
<title>Rimozione cattedra</title>
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
                  <h6 class="m-0 font-weight-bold text-primary">Rimozione cattedra</h6>
                </div>
                <div class="card-body">
					
                <!-- INSERIRE CONTENUTO -->
					<h4>Professore</h4>
					<br>
					<h6>Nome: ${cattedra.professore.nome }</h6>
					<h6>Cognome: ${cattedra.professore.cognome }</h6>
					<hr>
					<h4>Cattedra</h4>
					<h6>Facolta: ${cattedra.facolta.facolta }</h6>
					<h6>Corso: ${cattedra.corso.corso }</h6>
					<hr>
					<h4>Rimuovi</h4>
					<form
						action="/Campus/RimozioneCattedra/${cattedra.corso.id}-${cattedra.professore.id }-${cattedra.facolta.id }"
						method="post">
						<input type="hidden" name="corsoId" value=${cattedra.corso.id }>
						<input type="hidden" name="facoltaId"
							value=${cattedra.facolta.id }> <input type="hidden"
							name="profId" value=${cattedra.professore.id }> 
						<input class="btn btn-success btn-icon-split" type="submit"  value="Invia"/>
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