<%@ page import="app.model.StatistiqueCategorie" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<StatistiqueCategorie> statistiqueCategorieList = (List<StatistiqueCategorie>) request.getAttribute("stats"); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Backoffice | Dashboard</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/dist/css/adminlte.min.css">
</head>

<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <%@ include file="partials/sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Dashboard</h1>
                    </div>
                    <!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item">Admin</li>
                            <li class="breadcrumb-item active"><strong>Dashboard</strong></li>
                        </ol>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->
        <!-- /.card-header -->
        <div class="card-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Categories</th>
                    <th>Nombre Encheres</th>
                    <th>Revenu</th>
                    <th>Encheres Gagnees</th>
                    <th>Encheres Perdues</th>
                </tr>
                </thead>
                <tbody>
                <% for (StatistiqueCategorie stat : statistiqueCategorieList) { %>

                <tr>
                    <td><%= stat.getLibelleCategorie() %></td>
                    <td><%= stat.getNombreEnchere() %></td>
                    <td><%= stat.getRevenu() %></td>
                    <td><%= stat.getEnchereGagnee() %> (<%= stat.getWinRate() %>)%</td>
                    <td><%= stat.getEncherePerdue() %> (<%= stat.getLossRate() %>)%</td>
                </tr>

                <% } %>
                </tbody>
            </table>
        </div>
        <!-- /.card-body -->

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>

<%@ include file="partials/footer.jsp" %>

</body>

</html>
