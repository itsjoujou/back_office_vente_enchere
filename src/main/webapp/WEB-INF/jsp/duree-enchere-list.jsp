<%@ page import="app.model.DureeEnchere" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<DureeEnchere> dureeEnchereList = (List<DureeEnchere>) request.getAttribute("duree_enchere"); %>
<% SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy"); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Backoffice | Duree Enchere</title>

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
                        <h1 class="m-0">Duree enchere</h1>
                    </div>
                    <!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item">Admin</li>
                            <li class="breadcrumb-item active"><strong>Duree enchere</strong></li>
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
                    <th>Date</th>
                    <th>Min</th>
                    <th>Max</th>
                </tr>
                </thead>
                <tbody>
                <% for (DureeEnchere enchere : dureeEnchereList) { %>
                <tr>
                    <td><%= formater.format(enchere.getDateDebut()) %></td>
                    <td><%= enchere.getDureeMin() %>h</td>
                    <td><%= enchere.getDureeMax() %>h</td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <!-- /.card-body -->
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- jquery validation -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Nouvelle duree</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form action="${pageContext.request.contextPath}/admin/duree_enchere" method="post" id="quickForm">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="dureeMin">Duree Min</label>
                                        <input type="number" name="dureeMin" class="form-control" id="dureeMin" placeholder="Enter duration">
                                        <label for="dureeMax">Duree Max</label>
                                        <input type="number" name="dureeMax" class="form-control" id="dureeMax" placeholder="Enter duration">
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </form>
                        </div>
                        <!-- /.card -->
                    </div>
                    <!--/.col (left) -->
                    <!-- right column -->
                    <div class="col-md-6">

                    </div>
                    <!--/.col (right) -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
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
</body>

<%@ include file="partials/footer.jsp" %>

</html>
