<html>
<head>
<title>Prenotazione al Corso</title>
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
                  <h6 class="m-0 font-weight-bold text-primary">Prenotazione al Corso</h6>
                </div>
                <div class="card-body">
					
                <!-- INSERIRE CONTENUTO -->
                <table>
						<tr>
							<th>Data</th>
							<th>Prenota</th>
						</tr>
						<c:forEach items="${date}" var="d">
							<tr>
								<td>${d.dataAppello}</td>
								<td><a
									href="/Campus/Prenotazione/PrenotazioneEsame/${d.id}">Prenota</a></td>
							</tr>
						</c:forEach>
					</table>
					<!-- CONTENUTO -->

				</div>
              </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- Fine Contenuto pagina centrale -->
      
      
<%@ include file="/views/templates/footer.jspf" %>