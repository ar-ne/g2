<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>登录</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../../node_modules/mdi/css/materialdesignicons.min.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../../css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="../../images/favicon.png"/>
</head>

<body>
<div class="body-wrapper">
    <div class="page-wrapper">
        <main class="auth-screen">
            <div class="mdc-layout-grid">
                <div class="mdc-layout-grid__inner">
                    <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6">
                        <div class="mdc-card">
                            <section class="mdc-card__primary bg-white">
                                <form method="post" action="/login">
                                    <div class="mdc-layout-grid">
                                        <div class="mdc-layout-grid__inner">
                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                                <label class="mdc-text-field w-100">
                                                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4">
                                                        <div class="template-demo">
                                                            <div id="username-box-wrapper">
                                                                <div id="username-box"
                                                                     class="mdc-text-field mdc-text-field--box w-100">
                                                                    <input required pattern="\S+" type="text"
                                                                           id="username" class="mdc-text-field__input"
                                                                           aria-controls="name-validation-message"
                                                                           name="username">
                                                                    <label for="username" class="mdc-text-field__label">用户名</label>
                                                                    <div class="mdc-text-field__bottom-line"></div>
                                                                </div>
                                                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg"
                                                                   id="name-validation-msg">
                                                                    用户名不能为空或包含空格
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </label>
                                            </div>

                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                                <label class="mdc-text-field w-100">
                                                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop">
                                                        <div class="template-demo">
                                                            <div id="password-box-wrapper">
                                                                <div id="password-box"
                                                                     class="mdc-text-field mdc-text-field--box w-100">
                                                                    <input required pattern="\S+" type="password"
                                                                           id="password" class="mdc-text-field__input"
                                                                           aria-controls="password-validation-message"
                                                                           name="password">
                                                                    <label for="password" class="mdc-text-field__label">密码</label>
                                                                    <div class="mdc-text-field__bottom-line"></div>
                                                                </div>
                                                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg"
                                                                   id="password-validation-msg">
                                                                    密码不能为空或包含空格
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </label>
                                            </div>

                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6">
                                                <div class="mdc-form-field">
                                                    <div class="mdc-radio demo-radio--custom">
                                                        <input class="mdc-radio__native-control" type="radio"
                                                               id="user-type" name="type" value="0" checked>
                                                        <div class="mdc-radio__background">
                                                            <div class="mdc-radio__outer-circle"></div>
                                                            <div class="mdc-radio__inner-circle"></div>
                                                        </div>
                                                    </div>
                                                    <label for="user-type">一卡通用户</label>
                                                </div>
                                            </div>

                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6">
                                                <div class="mdc-form-field">
                                                    <div class="mdc-radio demo-radio--custom">
                                                        <input class="mdc-radio__native-control" type="radio"
                                                               id="admin-type" name="type" value="1">
                                                        <div class="mdc-radio__background">
                                                            <div class="mdc-radio__outer-circle"></div>
                                                            <div class="mdc-radio__inner-circle"></div>
                                                        </div>
                                                    </div>
                                                    <label for="admin-type">后台管理</label>
                                                </div>
                                            </div>

                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6">
                                                <div class="mdc-form-field">
                                                    <div class="mdc-radio demo-radio--custom">
                                                        <input class="mdc-radio__native-control" type="radio"
                                                               id="admin2-type" name="type" value="2">
                                                        <div class="mdc-radio__background">
                                                            <div class="mdc-radio__outer-circle"></div>
                                                            <div class="mdc-radio__inner-circle"></div>
                                                        </div>
                                                    </div>
                                                    <label for="admin2-type">单位管理</label>
                                                </div>
                                            </div>

                                            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                                <button type="submit" class="mdc-button mdc-button--raised w-100"
                                                        data-mdc-auto-init="MDCRipple">
                                                    登录
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
<!-- body wrapper -->
<!-- plugins:js -->
<script src="${pageContext.request.contextPath}/node_modules/material-components-web/dist/material-components-web.min.js"></script>
<script src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>
<!-- end inject -->
<!-- Plugin js for this page-->
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="${pageContext.request.contextPath}/js/misc.js"></script>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
<!-- end inject -->
<!-- Custom js for this page-->
<!-- End custom js for this page-->
</body>

</html>