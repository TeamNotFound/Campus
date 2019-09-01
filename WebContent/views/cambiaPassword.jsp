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
                  <h6 class="m-0 font-weight-bold text-primary">Cambia Password</h6>
                </div>
                <div class="card-body">
					
                <!-- INSERIRE CONTENUTO -->
                
				<form action="${pageContext.request.contextPath}/CambiaPassword" method="post">
				<label id="oldPassword">Vecchia Password:</label><br>
				<input type="password" name="oldPassword" id="oldPassword" /><br>
				
				<label id="newPassword">nuova Password:</label><br>
				<input type="password" name="newPassword" id="newPassword" /><br>

				<input class="btn btn-success btn-icon-split" type="submit" value="Cambia Password" />
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