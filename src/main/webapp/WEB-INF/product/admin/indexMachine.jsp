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


</head>
<body>
<script type="text/javascript">
    /*  function doSubmit(url) {
          var data = $('#form1').serialize();
          alert(url + "?" + data);
          $.ajax({
              type: "post",
              contentType: "application/json",
              url: url + "?" + data,
              success: function (data) {
                  alert("添加成功！！！")
                  window.location = "/admin/ma";
              },
              error: function (data) {
                  console.log(data);
              }
          })
      }*/

    function del(e) {
        if (confirm("确认要删除该刷卡机和相关的收费消费信息？")) {
            window.location.href = '/admin/ma/MaDelete?id=' + e;
        }
    }

    function selec() {
        var e = document.getElementById("id");
        var e1 = e.value;
        window.location.href = '/admin/ma/chargedo?id=' + e1;
    }

    function input() {
        window.location.href = '/admin/ma/input';
    }
</script>
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
                        <a class="mdc-drawer-link " href="/admin/">
                            <%--<i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
--%>
                            <i class="material-icons mdc-drawer-item-icon" aria-hidden="true">account_circle</i>
                            首页
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/admin/unit/">
                            <i class="material-icons mdc-drawer-item-icon" aria-hidden="true">group_work</i>
                            单位管理
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link active" href="/admin/ma/">
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
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link " href="/admin/data/">
                            <i class="material-icons mdc-drawer-item-icon" aria-hidden="true">poll</i>
                            数据分析与挖掘
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
                <div class="mdc-menu-anchor">
                    <a href="#" class="mdc-toolbar__icon toggle mdc-ripple-surface" data-toggle="dropdown"
                       toggle-dropdown="notification-menu" data-mdc-auto-init="MDCRipple">
                        <i class="material-icons">notifications</i>
                        <span class="dropdown-count">2</span>
                    </a>
                    <div class="mdc-simple-menu mdc-simple-menu--right" tabindex="-1" id="notification-menu">
                        <ul class="mdc-simple-menu__items mdc-list" role="menu" aria-hidden="true">
                            <li class="mdc-list-item" role="menuitem" tabindex="0">
                                <i class="material-icons mdc-theme--primary mr-1">email</i>
                                检查更新
                            </li>
                            <li class="mdc-list-item" role="menuitem" tabindex="0">
                                <i class="material-icons mdc-theme--primary mr-1">group</i>
                                未读信息
                            </li>
                        </ul>
                    </div>
                </div>
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
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-8">

                        <form name="frm" action="/admin/ma/">
                            <div class="form-froup" style="float:left;margin-right:30px">
                                <label class="form-label">刷卡机编号：</label><input class="form-control" type="number"
                                                                               name="id" id="id"
                                                                               value='${id}'>
                            </div>
                            <div class="form-froup" style="float:left;margin-right:30px">
                                <label class="form-label">单位编号：</label><input class="form-control" type="number"
                                                                              name="Uni_id"
                                                                              value='${Uni_id}'>
                            </div>
                            <button type="submit" class="btn btn-info" style="float:left;margin-top:32px"> 查找</button>
                        </form>
                    </div>
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-2">
                        <div id="toolbar" style="text-align:center;margin-right:10px;margin-top: 30px;">
                            <a class="btn btn-success" href="/admin/ma/MaInsert">新增刷卡机</a>
                        </div>
                    </div>

                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th class="text-left">卡机编号</th>
                                    <th class="text-left">单位编号</th>
                                    <th class="text-left">放置地点</th>
                                    <th class="text-left">操作</th>
                                </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${mac}" var="m">
                                <tr>
                                    <td class="text-left">&nbsp;&nbsp;${m.id}</td>
                                    <td class="text-left">&nbsp;&nbsp;${m.uni_id}</td>
                                    <td class="text-left">&nbsp;&nbsp;${m.addr}</td>
                                    <td class="text-left"><a class="btn btn-primary"
                                                             href='/admin/ma/MaUpdate?id=${m.id}&addr=${m.addr}'>修改</a>
                                        <button class="btn btn-danger" onclick="del(${m.id})">删除</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                        <div style="margin: auto auto">
                            <button class="btn btn-info" style="float:left;" onclick="selec()">查询刷卡机消费信息</button>
                        </div>
                        <div style="margin: auto auto">
                            <button class="btn btn-info" style="float:left;" onclick="input()"> 批量导入
                            </button>
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
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- End custom js for this page-->
</body>
</html>
