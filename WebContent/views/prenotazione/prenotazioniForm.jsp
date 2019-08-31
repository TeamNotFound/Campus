<html>
<head>
<title>Assegnazione Professore</title>
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
                  <h6 class="m-0 font-weight-bold text-primary">Assegnazione Professore</h6>
                </div>
                <div class="card-body">
					
                <!-- INSERIRE CONTENUTO -->
					<h1>${facolta.facolta}</h1>
					<c:forEach items="${facolta.corsi }" var="c">
						<a href="/Campus/Prenotazione/Corso/${c.id }"> ${c.corso} </a>
						<br>
					</c:forEach>
					<!-- CONTENUTO -->

				</div>
              </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- Fine Contenuto pagina centrale -->
      
      
<%@ include file="/views/templates/footer.jspf" %>