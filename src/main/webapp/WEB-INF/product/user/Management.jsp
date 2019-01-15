<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" contentType="text/html; utf-8" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>校园一卡通</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/mdi/css/materialdesignicons.min.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.png"/>
</head>
<script>
    function report() {
        if ("${state}" != "冻结") {
            if (confirm("确认要挂失？")) {
                window.location.href = '/user/Management/reportless';
            }
        } else {
            alert("挂失失败，当前卡已是冻结状态");
        }
    }

    function cancel() {
        if ("${state}" != "正常") {
            if (confirm("确认要取消挂失")) {
                window.location.href = '/user/Management/cancelReportLoss';
            }
        } else {
            alert("取消挂失失败，当前卡已是正常状态");
        }
    }

    function ePassword() {
        if ("${state}" != "冻结") {
            if (confirm("确认要修改密码?")) {
                window.location.href = '/user/Management/ePassword';
            }
        } else {
            alert("你的卡已被冻结，无法修改密码");
        }

    }

    function recharge() {
        if ("${state}" != "冻结") {
            if (confirm("确认要充值")) {
                window.location.href = '/user/Management/recharge';
            }
        } else {
            alert("你的卡已被冻结，无法充值");
        }

    }
</script>
<body>
<div class="body-wrapper">
    <!-- partial:partials/_sidebar.html -->
    <aside class="mdc-persistent-drawer mdc-persistent-drawer--open">
        <nav class="mdc-persistent-drawer__drawer">
            <div class="mdc-persistent-drawer__toolbar-spacer">
                <a href="/user">
                    欢迎使用校园一卡通系统
                </a>
            </div>
            <div class="mdc-list-group">
                <nav class="mdc-list mdc-drawer-menu">
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/user">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
                            首页
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/user/QRCode">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
                            刷卡消费
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/user/QueSta">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
                            查询统计
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link active" href="/user/Management">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon active"
                               aria-hidden="true">desktop_mac</i>
                            校园卡管理
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
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-6">
                        <button class="mdc-button mdc-button--stroked secondary-stroked-button w-100" onclick="report()"
                                data-mdc-auto-init="MDCRipple">
                            <i class="mdi mdi-account-alert icon-md"></i>
                            挂失
                        </button>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-6">
                        <a class="mdc-button mdc-button--raised secondary-filled-button w-100" onclick="cancel()"
                           data-mdc-auto-init="MDCRipple">
                            <i class="mdi mdi-account-circle icon-md"></i>
                            取消挂失
                        </a>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-6">
                        <a class="mdc-button mdc-button--raised w-100" onclick="recharge()"
                           data-mdc-auto-init="MDCRipple">
                            <i class="mdi mdi-diamond icon-md"></i>
                            充值
                        </a>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-6">
                        <a class="mdc-button mdc-button--stroked w-100" onclick="ePassword()"
                           data-mdc-auto-init="MDCRipple">
                            <i class="mdi  mdi-account-settings-variant icon-md"></i>
                            修改密码
                        </a>
                    </div>
                </div>
            </div>
            <label>当前卡的状态：${state}</label><label style="color: red">${error}</label>
        </main>
        <!-- partial:partials/_footer.html -->
        <footer>
            <div class="mdc-layout-grid">
                <div class="mdc-layout-grid__inner">
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6">
                        <span class="text-muted"></span>
                    </div>
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6 d-flex justify-content-end">
                        <span class="mt-0 text-right">g2t006 用户中心</span>
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
<!-- End custom js for this page-->
</body>
</html>
