<html>
<head>
<title>Assegnazione Professore</title>
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
                  <h6 class="m-0 font-weight-bold text-primary">Assegnazione Professore</h6>
                </div>
                <div class="card-body">
					<form action="AssegnazioneCattedra" method="post">

						<label for="prof">Professore:</label> <select id="prof"
							name="prof">
							<c:forEach items="${professori}" var="prof">
								<option value="${prof.id}">${prof.nome}${prof.cognome}</option>
							</c:forEach>
						</select><br>
						<br> <label for="facolta">Facoltà:</label> <select
							id="facolta" name="facolta">
							<c:forEach items="${facolta}" var="fac">
								<option value="${fac.id}">${fac.facolta}</option>
							</c:forEach>
						</select><br>
						<br> <label for="corso">Corso:</label> <select id="corso"
							name="corso">
							<c:forEach items="${corsi}" var="corso">
								<option value="${corso.id}">${corso.corso}</option>
							</c:forEach>
						</select><br>
						<br> <input class="btn btn-success btn-icon-split"
							type="submit" />

					</form>
				</div>
              </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- Fine Contenuto pagina centrale -->
      
      
<%@ include file="/templates/footer.jspf" %>