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
                        <a class="mdc-drawer-link active" href="/user/QueSta">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
                            查询统计
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/user/Management">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
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
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                        <div class="mdc-card">
                            <form method="post" action="/user/QueSta/cmlist">
                                <div class="mdc-layout-grid__inner mdc-card__primary">
                                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                        <div class="mdc-layout-grid__inner">
                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-4">
                                                <div id="demo-tf-box-leading-wrapper" class="w-100">
                                                    <div id="tf-box-leading-example"
                                                         class="mdc-text-field mdc-text-field--box mdc-text-field--with-leading-icon w-100">
                                                        <i class="material-icons mdc-text-field__icon" tabindex="0">monetization_on</i>
                                                        <input type="number" id="tf-box-leading" name="money"
                                                               class="mdc-text-field__input w-100">
                                                        <label for="tf-box-leading" name="money"
                                                               class="mdc-text-field__label">消费金额</label>
                                                        <div class="mdc-text-field__bottom-line"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-4">
                                                <div id="hero-js-select" class="mdc-select w-100" role="listbox">
                                                    <div class="mdc-select__surface" tabindex="0">
                                                        <div class="mdc-select__label">请选择消费卡机编号</div>
                                                        <div id="macID" class="mdc-select__selected-text"></div>
                                                        <div class="mdc-select__bottom-line"></div>
                                                    </div>
                                                    <div class="mdc-simple-menu mdc-select__menu">
                                                        <ul class="mdc-list mdc-simple-menu__items">
                                                            <c:forEach items="${macIDList}" var="macID">
                                                                <li class="mdc-list-item" role="option" tabindex="0"
                                                                    name="macID">
                                                                        ${macID}
                                                                </li>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-2">
                                                <button class="mdc-button mdc-button--raised w-100" type="submit"
                                                        data-mdc-auto-init="MDCRipple">
                                                    查询
                                                </button>
                                            </div>
                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-2">
                                                <a href="/user/QueSta/stastic"
                                                   class="mdc-button mdc-button--raised w-100"
                                                   data-mdc-auto-init="MDCRipple">
                                                    统计
                                                </a>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                        <table class="table table-hoverable" id="consume">
                                            <thead>
                                            <tr>
                                                <th class="text-left">消费编号</th>
                                                <th class="text-left">校园卡编号</th>
                                                <th class="text-left">消费时间</th>
                                                <th class="text-left">消费卡机编号</th>
                                                <th class="text-left">消费金额</th>
                                                <th class="text-left">消费结果</th>
                                                <th class="text-left">失败原因</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${cosumelist}" var="c">
                                                <tr id="tr_id_${c.id}">
                                                    <td class="text-left">${c.id}</td>
                                                    <td class="text-left">${c.car_id}</td>
                                                    <td class="text-left">${c.time}</td>
                                                    <td class="text-left">${c.mac_id}</td>
                                                    <td class="text-left">${c.amount}</td>
                                                    <td class="text-left">${c.result}</td>
                                                    <td class="text-left">${c.reason}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <input type="hidden" id="macIDinner" name="macID" value="">
                            </form>
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
<script>
    $('#macID').bind('DOMNodeInserted', function (e) {
        var inner = e.target.innerHTML;
        document.getElementById("macIDinner").value = inner;
    });
</script>
<!-- End custom js for this page-->
</body>
</html>
