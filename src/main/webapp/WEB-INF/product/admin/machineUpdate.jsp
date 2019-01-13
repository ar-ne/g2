<%@ page pageEncoding="utf-8" contentType="text/html; utf-8" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Material Admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?v=1" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.png"/>
    <style type="text/css">
        @import url('${pageContext.request.contextPath}/css/admin.css');

        a:hover {
            background: rgba(0, 0, 0, 0.06);
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            -ms-border-radius: 5px;
            -o-border-radius: 5px;
            border-radius: 5px;
        }
    </style>
    <script type="text/javascript">
        //$(function () {
        function doSubmit(url) {
            var data = $('#frm').serialize();
            alert(url + "?" + data);
            $.ajax({
                type: "post",
                contentType: "application/json",
                url: url + "?" + data,
                success: function (data) {
                    alert("修改成功！！！");
                    window.location = "/admin/ma";
                },
                failed: function (data) {
                    alert("修改失败！！！");
                    console.log(data);
                }
            })
        }

        //  })
    </script>
</head>
<body>
<div class="body-wrapper">
    <!-- partial:partials/_sidebar.html -->
    <aside class="mdc-persistent-drawer mdc-persistent-drawer--open">
        <nav class="mdc-persistent-drawer__drawer">
            <div class="mdc-persistent-drawer__toolbar-spacer">
                <a href="index.html">
                    欢迎使用校园一卡通管理系统
                </a>
            </div>
            <div class="mdc-list-group">
                <nav class="mdc-list mdc-drawer-menu">
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link " href="/admin">
                            <%--<i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
--%>
                            <i class="material-icons mdc-drawer-item-icon" aria-hidden="true">account_circle</i>
                            首页
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/admin/unit/UnitList">
                            <i class="material-icons mdc-drawer-item-icon" aria-hidden="true">group_work</i>
                            单位管理
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link active" href="/admin/ma/MaList">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>

                            刷卡机管理
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/admin/card/">
                            <i class="material-icons mdc-drawer-item-icon" aria-hidden="true">extension</i>
                            办卡中心管理
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/admin/report/">
                            <i class="material-icons mdc-drawer-item-icon" aria-hidden="true">timeline</i>
                            统计报表管理
                        </a>
                    </div>
                </nav>
            </div>
        </nav>
    </aside>
    <!-- partial -->

    <!-- partial:partials/_navbar.html -->
    <header class="mdc-toolbar mdc-elevation--z4 mdc-toolbar--fixed">
        <div class="mdc-toolbar__row">
            <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
                <a href="#" class="menu-toggler material-icons mdc-toolbar__menu-icon">menu</a>
                <span class="mdc-toolbar__input">
          </span>
            </section>
            <section class="mdc-toolbar__section mdc-toolbar__section--align-end" role="toolbar">
                <div class="mdc-menu-anchor mr-1">
                    <a href="#" class="mdc-toolbar__icon toggle mdc-ripple-surface" data-toggle="dropdown"
                       toggle-dropdown="logout-menu" data-mdc-auto-init="MDCRipple">
                        <i class="material-icons">more_vert</i>
                    </a>
                    <div class="mdc-simple-menu mdc-simple-menu--right" tabindex="-1" id="logout-menu">
                        <ul class="mdc-simple-menu__items mdc-list" role="menu" aria-hidden="true">
                            <li class="mdc-list-item" role="menuitem" tabindex="0">
                                <i class="material-icons mdc-theme--primary mr-1">settings</i>
                                Settings
                            </li>
                            <li class="mdc-list-item" role="menuitem" tabindex="0">
                                <i class="material-icons mdc-theme--primary mr-1">power_settings_new</i>
                                Logout
                            </li>
                        </ul>
                    </div>
                </div>
            </section>
        </div>
    </header>
    <!-- partial -->
    <div class="page-wrapper mdc-toolbar-fixed-adjust">
        <main class="content-wrapper">
            <div class="mdc-layout-grid">
                <div class="mdc-layout-grid__inner">
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-10">
                        <form id="frm" action="" style="margin: auto auto">
                            <div class="form-froup">
                                <input type="hidden" name="id" value="${machine.id}"><!-- 增加隐藏变量-->
                                <label class="form-label">单位编号：</label>

                                <select class="form-control" name="Uni_id">
                                    <c:forEach items="${list}" var="l">
                                        <option value=${l} <c:if test="${machine.uni_id==l}">${"selected"}</c:if>>${l}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-froup">
                                <label class="form-label">放置地点：</label><input class="form-control" type="text"
                                                                              name="addr" value='${machine.addr}'>
                            </div>
                            <div class="form-froup">
                                <button onclick="doSubmit('/admin/ma/MaUpdateDo')" class="btn btn-info"
                                        style="float: left">保存
                                </button>
                                <button type="button" class="btn btn-danger" onclick="ret()" style="float: right"> 重置
                                </button>

                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </main>
        <!-- partial:partials/_footer.html -->
        <footer>
            <div class="mdc-layout-grid">
                <div class="mdc-layout-grid__inner">
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6">
                        <span class="text-muted"></span>
                    </div>
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6 d-flex justify-content-end">
                        <span class="mt-0 text-right">g2t006 单位管理</span>
                    </div>
                </div>
            </div>
        </footer>
        <!-- partial -->
    </div>
</div>
<!-- body wrapper -->

<!-- plugins:js -->
<script src="${pageContext.request.contextPath}/node_modules/material-components-web/dist/material-components-web.min.js"></script>
<script src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>
<!-- endinject -->
<!-- Plugin js for this page-->
<script src="${pageContext.request.contextPath}/node_modules/chart.js/dist/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/node_modules/progressbar.js/dist/progressbar.min.js"></script>
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="${pageContext.request.contextPath}/js/misc.js"></script>
<script src="${pageContext.request.contextPath}/js/material.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="${pageContext.request.contextPath}/js/dashboard.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- End custom js for this page-->
</body>
</html>
