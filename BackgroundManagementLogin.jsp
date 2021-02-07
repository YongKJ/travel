<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    
<!-- source http://www.scnoob.com More templates http://www.scnoob.com/moban -->
<head>
        <meta charset="utf-8" />
        <title>登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- App favicon -->
        <link rel="shortcut icon" href="images/favicon.ico">

        <!-- App css -->
        <link href="images/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="images/icons.min.css" rel="stylesheet" type="text/css" />
        <link href="images/app.min.css" rel="stylesheet" type="text/css" />

    </head>

    <body class="authentication-bg">

        <div class="account-pages mt-5 mb-5">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5">
                        <div class="card">

                            <div class="card-body p-4">
                                
                                <div class="text-center w-75 m-auto">
                                    <a href="#">
                                        <span><img src="images/logo.png" alt="" height="22"></span>
                                    </a>
                                    <p class="text-muted mb-4 mt-3">请输入账号和密码登录后台管理</p>
                                </div>

                                <form method="post" action="manage">

                                    <div class="form-group mb-3">
                                        <label for="emailaddress">账号</label>
                                        <input class="form-control" type="text" name="account" placeholder="请输入管理员账号">
                                    </div>

                                    <div class="form-group mb-3">
                                        <a href="pages-recoverpw.html" class="text-muted float-right"><small></small></a>
                                        <label for="password">密码</label>
                                        <input class="form-control" type="password" name="password" placeholder="请输入管理员密码">
                                    </div>

                                    <div class="form-group mb-3">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="checkbox-signin" checked>
                                            <label class="custom-control-label" for="checkbox-signin">记住我</label>
                                        </div>
                                    </div>

                                    <div class="form-group mb-0 text-center">
                                        <button class="btn btn-primary btn-block" type="submit"> 登录 </button>
                                    </div>

                                </form>
                            </div> <!-- end card-body -->
                        </div>
                        <!-- end card -->
                        

                    </div> <!-- end col -->
                </div>
                <!-- end row -->
            </div>
            <!-- end container -->
        </div>
        <!-- end page -->


        <!-- App js -->
        <script src="images/vendor.min.js"></script>
        <script src="images/app.min.js"></script>
        
    </body>

<!-- source http://www.scnoob.com More templates http://www.scnoob.com/moban -->
</html>