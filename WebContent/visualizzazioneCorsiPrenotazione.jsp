<html>
<head>
<title>Corsi disponibili</title>
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
                  <h6 class="m-0 font-weight-bold text-primary">Corsi disponibili</h6>
                </div>
                <div class="card-body">
					
                <!-- INSERIRE CONTENUTO -->
					<c:forEach items="corsi" var="c">
						<a href="/Campus/PrenotazioneCorso/${c.id}">${c.corso}</a>
					</c:forEach>

					<!-- CONTENUTO -->

				</div>
              </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- Fine Contenuto pagina centrale -->
      
      
<%@ include file="/templates/footer.jspf" %>