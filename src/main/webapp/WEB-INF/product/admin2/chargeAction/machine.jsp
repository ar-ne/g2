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

        #JPO {
            transform: scale(0.8);
        }

        .popup_visible #JPO {
            transform: scale(1);
        }

        #JPO1 {
            transform: scale(0.8);
        }

        .popup_visible #JPO1 {
            transform: scale(1);
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
    <aside class="mdc-persistent-drawer">
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
                        <a class="mdc-drawer-link" href="/admin2/schedule">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">grid_on</i>
                            排班管理
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link active" href="/admin2/charge">
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
    <div class="page-wrapper mdc-toolbar-fixed-adjust" id="page">
        <main class="content-wrapper drawer-minimized">
            <div class="mdc-layout-grid">
                <div class="mdc-layout-grid__inner">
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                        <div class="mdc-card">
                            <div class="mdc-layout-grid__inner">
                                <%--左半边--%>
                                <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6">
                                    <div class="mdc-layout-grid__inner">
                                        <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                            <div class="mdc-card__primary w-100">
                                                <button onclick="scan()" id="buttonScan"
                                                        class="mdc-button mdc-button--stroked thick-stroke-button mdc-ripple-upgraded w-100"
                                                        data-mdc-auto-init="MDCRipple"
                                                        style="--mdc-ripple-fg-size:115.62px; --mdc-ripple-fg-scale:1.78199; --mdc-ripple-fg-translate-start:104.79px, -32.2099px; --mdc-ripple-fg-translate-end:38.54px, -39.81px;">
                                                    <i class="material-icons">done</i>
                                                    确定
                                                </button>
                                            </div>
                                        </div>
                                        <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                            <div class="mdc-card__primary">
                                                <div id="demo-tf-box-leading-wrapper" class="w-100">
                                                    <div id="tf-box-leading-example"
                                                         class="mdc-text-field mdc-text-field--box w-100 mdc-text-field--upgraded mdc-ripple-upgraded w-100"
                                                         style="--mdc-ripple-fg-size:111.06px; --mdc-ripple-fg-scale:1.83131; --mdc-ripple-fg-translate-start:60.37px, -17.93px; --mdc-ripple-fg-translate-end:37.02px, -27.53px;">
                                                        <input type="text" id="tf-box-leading"
                                                               onkeyup="clearNoNum(this)"
                                                               class="mdc-text-field__input w-100" name="address">
                                                        <label for="tf-box-leading"
                                                               class="mdc-text-field__label">金额</label>
                                                        <div class="mdc-text-field__bottom-line"
                                                             style="transform-origin: 115.89999389648438px center"></div>
                                                    </div>
                                                </div>
                                                <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                                    <div class="mdc-card__primary">
                                                        <h1 id="name"></h1>
                                                    </div>
                                                </div>
                                                <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                                    <div class="mdc-card__primary">
                                                        <h1 id="cid"></h1>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <%--右半边--%>
                                <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6">
                                    <div class="mdc-layout-grid__inner">
                                        <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                            <div class="mdc-card__primary">
                                                <h1>单位:${mac.uni_id}</h1>
                                            </div>
                                        </div>
                                        <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                            <div class="mdc-card__primary">
                                                <h1>卡机:${mac.id}</h1>
                                            </div>
                                        </div>
                                        <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                            <div class="mdc-card__primary">
                                                <h1>地点:${mac.addr}</h1>
                                            </div>
                                        </div>
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
<div id="JPO">
    <div class="mdc-layout-grid">
        <div class="mdc-layout-grid__inner">
            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                <div class="mdc-card py-3 pl-2 d-flex flex-row align-item-center">
                    <div class="mdc--tile mdc--tile-success rounded">
                        <i class="material-icons text-white icon-md">done</i>
                    </div>
                    <div class="text-wrapper pl-1">
                        <h3 class="mdc-typography--display1 font-weight-bold mb-1 text-green">成功</h3>
                        <p class="font-weight-normal mb-0 mt-0" id="amountPaid"></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="JPO1">
    <div class="mdc-layout-grid">
        <div class="mdc-layout-grid__inner">
            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                <div class="mdc-card py-3 pl-2 d-flex flex-row align-item-center">
                    <div class="mdc--tile mdc--tile-danger rounded">
                        <i class="material-icons text-white icon-md">warning</i>
                    </div>
                    <div class="text-wrapper pl-1">
                        <h3 class="mdc-typography--display1 font-weight-bold mb-1 text-red">失败</h3>
                        <p class="font-weight-normal mb-0 mt-0" id="failText"></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- plugins:js -->
<script src="${pageContext.request.contextPath}/node_modules/material-components-web/dist/material-components-web.min.js"></script>
<script src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>
<!-- endinject -->
<!-- Plugin js for this page-->
<script src="${pageContext.request.contextPath}/node_modules/jquery-popup-overlay/jquery.popupoverlay.js"></script>
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="${pageContext.request.contextPath}/js/misc.js"></script>
<script src="${pageContext.request.contextPath}/js/material.js"></script>
<script>
    var amountDIV = $("#tf-box-leading");
    var macID = ${mac.id};
    $('#JPO').popup({
        scrolllock: true,
        transition: 'all 0.3s'
    });
    $.fn.popup.defaults.pagecontainer = '#page';

    $('#JPO1').popup({
        scrolllock: true,
        transition: 'all 0.3s'
    });
    $.fn.popup.defaults.pagecontainer = '#page';
    amountDIV.keypress(function () {
        if (event.keyCode === 13) {
            scan();
        }
    });

    function pop() {
        $('#JPO').popup('show');
    }

    function clearNoNum(obj) {
        obj.value = obj.value.replace(/[^\d.]/g, "");  //清除“数字”和“.”以外的字符
        obj.value = obj.value.replace(/^\./g, "");  //验证第一个字符是数字而不是.
        obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的.
        obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");

    }

    var erroredScan = false;

    function pJson(url, dat) {
        var d;
        $.ajaxSettings.async = false;
        $.post(url, dat, function (data) {
            try {
                d = $.parseJSON(data);
            } catch (e) {
                erroredScan = true;
            }
        });
        $.ajaxSettings.async = false;
        console.log(d);
        return d;
    }

    function decode(b64s) {
        return pJson("/admin2/charge/decodeIF", {str: b64s});
    }

    function charge(b64j) {
        var result = pJson("/admin2/charge/chargeIF", {
            cardID: b64j.card,
            macID: macID,
            amount: amountDIV.val(),
            name: b64j.name
        });
        if (result.result === 1) onSuccess(result);
        else onFailed(result);
    }

    //弹出窗口，定时关闭
    function onSuccess(result) {
        resetPage();
        $("#amountPaid")[0].innerHTML = "&nbsp;金额：" + result.amount;
        $('#JPO').popup('show');
        setTimeout(function () {
            $('#JPO').popup('hide');
        }, 3000);
    }

    function onFailed(result) {
        resetPage();
        $("#failText")[0].innerHTML = result.reason;
        $('#JPO1').popup('show');
        setTimeout(function () {
            $('#JPO1').popup('hide');
        }, 3000);
    }

    var qrResult;
    var scanWindow;

    function scan() {
        qrResult = null;
        if (amountDIV.val() === "") {
            amountDIV.focus();
            return;
        }
        amountDIV.attr("disabled", true);
        $("#buttonScan").attr("disabled", true);
        scanWindow = window.open("scan", "foo", "width=800px, height=600px, location=no, resizable=no");
    }

    function onScanned(msg) {
        qrResult = msg;
        scanWindow.close();
        doScanned();
    }

    function doScanned() {
        var result = qrResult;
        qrResult = null;
        console.log(result);
        var info = decode(result);
        if (erroredScan) {
            $("#name")[0].innerHTML = "扫描错误，请重新扫描";
            resetPage();
            return;
        }
        var name = "用户名：" + info.name;
        var card = "卡  号：" + info.card;
        $("#name")[0].innerHTML = name;
        $("#cid")[0].innerHTML = card;
        charge(info);
    }

    function resetPage() {
        amountDIV.attr("disabled", false);
        $("#buttonScan").attr("disabled", false);
        erroredScan = false;
        $("#name")[0].innerHTML = "";
        $("#cid")[0].innerHTML = "";
    }
</script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="${pageContext.request.contextPath}/js/dashboard.js"></script>
<!-- End custom js for this page-->
</body>
</html>
