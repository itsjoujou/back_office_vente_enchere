<%@ page import="app.model.DemandeRecharge" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<DemandeRecharge> demandeRechargeList = (List<DemandeRecharge>) request.getAttribute("demandes"); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Backoffice | Liste Demandes</title>

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
                        <h1 class="m-0">Demandes Recharge</h1>
                    </div>
                    <!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item">Admin</li>
                            <li class="breadcrumb-item active"><strong>Demandes Recharge</strong></li>
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
                    <th style="width: 40px">#</th>
                    <th>Libelle Categorie</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <% for (DemandeRecharge demandeRecharge : demandeRechargeList) { %>
                <tr>
                    <td><%= demandeRecharge.getUser().getUsername() %></td>
                    <td><%= demandeRecharge.getMontant() %></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/demandes_recharge/<%= demandeRecharge.getId() %>" class="btn btn-primary">Valider</a>
                    </td>
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
<script src="/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>

<%@ include file="partials/footer.jsp" %>

</body>

</html>
