<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" contentType="text/html; utf-8" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>单位管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/mdi/css/materialdesignicons.min.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <style type="text/css">
        a:hover {
            background: rgba(0, 0, 0, 0.06);
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            -ms-border-radius: 5px;
            -o-border-radius: 5px;
            border-radius: 5px;
        }
    </style>
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.png"/>
</head>
<body>
<div class="body-wrapper">
    <!-- partial:partials/_sidebar.html -->
    <aside class="mdc-persistent-drawer mdc-persistent-drawer--open">
        <nav class="mdc-persistent-drawer__drawer">
            <div class="mdc-persistent-drawer__toolbar-spacer">
                <a href="index">
                    欢迎使用校园一卡通管理系统
                </a>
            </div>
            <div class="mdc-list-group">
                <nav class="mdc-list mdc-drawer-menu">
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/admin2">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
                            首页
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/admin2/stuff">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">dashboard</i>
                            员工列表
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link active" href="/admin2/schedule">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">grid_on</i>
                            排班管理
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/admin2/charge">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">pages</i>
                            收费系统
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
                                <i class="material-icons mdc-theme--primary mr-1">power_settings_new</i>
                                <a href="/logout">Logout</a>
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
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                        <div class="mdc-card">
                            <%--按钮/输入框区--%>
                            <div class="mdc-card__primary">
                                <div class="mdc-layout-grid__inner">
                                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-6 w-100"></div>

                                    <%--添加按钮--%>
                                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4 w-100">
                                        <a href="/admin2/schedule/add"
                                           class="mdc-button mdc-button--stroked mdc-ripple-upgraded w-100"
                                           data-mdc-auto-init="MDCRipple"
                                           style="--mdc-ripple-fg-size:60.2325px; --mdc-ripple-fg-scale:1.93662; --mdc-ripple-fg-translate-start:32.9175px, -5.18249px; --mdc-ripple-fg-translate-end:20.255px, -12.3825px;">
                                            <i class="material-icons mdc-button__icon">add_box</i>
                                            添加
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <%--表格区--%>
                            <div class="mdc-card__primary">
                                <div class="mdc-layout-grid__inner">
                                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                        <c:if test="${list.size()!=0}">
                                            <table class="table table-hoverable w-100">
                                                <thead>
                                                <tr>
                                                    <th class="text-left">排班编号</th>
                                                    <th class="text-left">开始时间</th>
                                                    <th class="text-left">结束时间</th>
                                                    <th class="text-left">地点</th>
                                                    <th class="text-left">操作</th>
                                                </thead>

                                                <tbody>
                                                <c:forEach items="${list}" var="i">
                                                    <tr id="tr_id_${i.id}">
                                                        <td class="text-left">${i.id}</td>
                                                        <td ${i.start==null?"style='color: lightgray;'":""}
                                                                class="text-left">${i.start==null?"空":i.start}</td>
                                                        <td ${i.stop==null?"style='color: lightgray;'":""}
                                                                class="text-left">${i.stop==null?"空":i.stop}</td>
                                                        <td ${i.address==null?"style='color: lightgray;'":""}
                                                                class="text-left">${i.address==null?"空":i.address}</td>
                                                        <td class="text-left">
                                                            <a href="/admin2/schedule/edit?id=${i.id}"
                                                               class="col mdc-button mdc-ripple-upgraded"
                                                               data-mdc-auto-init="MDCRipple"
                                                               style="--mdc-ripple-fg-size:27.9375px; --mdc-ripple-fg-scale:2.23298; --mdc-ripple-fg-translate-start:5.19373px, -3.39374px; --mdc-ripple-fg-translate-end:9.3125px, -1.96875px;">
                                                                <i class="material-icons text-green">edit</i></a>
                                                            <button onclick="confirmInfo(${i.id})"
                                                                    class="col mdc-button mdc-ripple-upgraded"
                                                                    data-mdc-auto-init="MDCRipple"
                                                                    style="--mdc-ripple-fg-size:27.9375px; --mdc-ripple-fg-scale:2.23298;">
                                                                <i class="material-icons text-red">delete_forever</i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${list.size()==0}">
                                            <h2>排班信息为空</h2>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
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
<script>
    function confirmInfo(e) {
        if (confirm("确认删除？")) {
            //console.log(e);
            window.location.href = "/admin2/schedule/del?id=" + e;
        }
    }
</script>
<!-- End custom js for this page-->
</body>
</html>
