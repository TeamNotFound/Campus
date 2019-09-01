<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html lang="it">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Primo Accesso al Portale</title>

  <!-- Custom fonts for this template-->
  <link href="../Campus/views/templates/dashboard/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../Campus/views/templates/dashboard/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Primo Accesso? Registrati come rettore!</h1>
              </div>

				<form class="user" action="FirstAccess" method="post"> 
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" name="nome" id="nome" placeholder="Nome Professore">
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" name="cognome" id="cognome" placeholder="Cognome">
                  </div>
                </div>

                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="date" id="nascita-data" name="nascita-data" class="form-control form-control-user" placeholder="Data Nascita">
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" name="nascita-luogo" id="nascita-luogo" placeholder="Luogo Nascita">
                  </div>
                </div>

                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="fiscale" name="fiscale" placeholder="Codice Fiscale">
                  </div>
                  
                </div>

                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0"> <label for="sesso">Sesso:</label><br>

                  <input type="radio" id="uomo" name="sesso" value="uomo" checked="checked"/>
                  <label for="uomo">Uomo</label>

                  <input type="radio" id="sesso" name="sesso" value="donna"/>
                  <label for="donna">Donna</label><br>
                   </div>
                  
                </div>



                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="titoli" name="titoli" placeholder="Titoli di studio">
                  </div>
                  
                </div>




                 <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="username" name="username" placeholder="Username">
                  </div>
                  <div class="col-sm-6">
                    <input type="password" class="form-control form-control-user" id="password" name="password" placeholder="Password">
                  </div>
                </div>

              <input class="btn btn-success btn-icon-split" type="submit" />

              </form>
              
              
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="../Campus/views/templates/dashboard/vendor/jquery/jquery.min.js"></script>
  <script src="../Campus/views/templates/dashboard/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../Campus/views/templates/dashboard/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../Campus/views/templates/dashboard/js/sb-admin-2.min.js"></script>

</body>

</html>
