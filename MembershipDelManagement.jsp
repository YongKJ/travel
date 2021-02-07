<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    
<!-- source http://www.scnoob.com More templates http://www.scnoob.com/moban -->
<head>
        <meta charset="utf-8" />
        <title>后台管理</title>
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

    <body>

        <!-- Begin page -->
        <div id="wrapper">

            <!-- ========== Left Sidebar Start ========== -->
            <div class="left-side-menu">

                <div class="slimscroll-menu">


                    <!--- Sidemenu -->
                    <div id="sidebar-menu">

                        <ul class="metismenu" id="side-menu">

                            <li class="menu-title">后台管理</li>

                            <li>
                                <a href="javascript: void(0);">
                                    <i class="fe-user"></i>
                                    <span> 用户管理 </span>
                                    <span class="menu-arrow"></span>
                                </a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li>
                                        <a href="manage?tableName=Busertable&tableOperation=add">添加用户</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Busertable&tableOperation=modOne">修改用户</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Busertable&tableOperation=del">删除用户</a>
                                    </li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript: void(0);">
                                    <i class="dripicons-store"></i>
                                    <span> 景点管理 </span>
                                    <span class="menu-arrow"></span>
                                </a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li>
                                        <a href="manage?tableName=Attractions&tableOperation=add">添加景点</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Attractions&tableOperation=modOne">修改景点</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Attractions&tableOperation=del">删除景点</a>
                                    </li>
                                </ul>
                            </li>

                            <li class="active">
                                <a href="javascript: void(0);" class="active">
                                    <i class="fe-dollar-sign"></i>
                                    <span> 团费管理 </span>
                                    <span class="menu-arrow"></span>
                                </a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li>
                                        <a href="manage?tableName=Membership&tableOperation=add">添加团费</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Membership&tableOperation=modOne">修改团费</a>
                                    </li>
                                    <li class="active">
                                        <a href="manage?tableName=Membership&tableOperation=del">删除团费</a>
                                    </li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript: void(0);">
                                    <i class="dripicons-blog"></i>
                                    <span> 博客管理 </span>
                                    <span class="menu-arrow"></span>
                                </a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li>
                                        <a href="manage?tableName=Strategy&tableOperation=add">添加博客</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Strategy&tableOperation=modOne">修改博客</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Strategy&tableOperation=del">删除博客</a>
                                    </li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript: void(0);">
                                    <i class="dripicons-star"></i>
                                    <span> 关注管理 </span>
                                    <span class="menu-arrow"></span>
                                </a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li>
                                        <a href="manage?tableName=Attention&tableOperation=add">添加关注</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Attention&tableOperation=modOne">修改关注</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Attention&tableOperation=del">删除关注</a>
                                    </li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript: void(0);">
                                    <i class="fe-message-circle"></i>
                                    <span> 评论管理 </span>
                                    <span class="menu-arrow"></span>
                                </a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li>
                                        <a href="manage?tableName=Userevaluation&tableOperation=add">添加评论</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Userevaluation&tableOperation=modOne">修改评论</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Userevaluation&tableOperation=del">删除评论</a>
                                    </li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript: void(0);">
                                    <i class="dripicons-to-do"></i>
                                    <span> 订单管理 </span>
                                    <span class="menu-arrow"></span>
                                </a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li>
                                        <a href="manage?tableName=Order&tableOperation=add">添加订单</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Order&tableOperation=modOne">修改订单</a>
                                    </li>
                                    <li>
                                        <a href="manage?tableName=Order&tableOperation=del">删除订单</a>
                                    </li>
                                </ul>
                            </li>
                            
                        </ul>

                    </div>
                    <!-- End Sidebar -->

                    <div class="clearfix"></div>

                </div>
                <!-- Sidebar -left -->

            </div>
            <!-- Left Sidebar End -->

            <!-- ============================================================== -->
            <!-- Start Page Content here -->
            <!-- ============================================================== -->

            <div class="content-page">
                <div class="content">

                    <!-- Topbar Start -->
                    <div class="navbar-custom">
                        <ul class="list-unstyled topbar-right-menu float-right mb-0">
                            
                            <li class="dropdown notification-list">
                                <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                    <i class="dripicons-bell noti-icon"></i>
<!--                                     <span class="badge badge-danger rounded-circle noti-icon-badge">2</span> -->
                                </a>
                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-animated dropdown-lg">

                                    <!-- item-->
                                    <div class="dropdown-item noti-title">
                                        <h5 class="m-0">
                                            <span class="float-right">
                                                <a href="#" class="text-dark">
                                                    <small>清除全部</small>
                                                </a>
                                            </span>通知</h5>
                                    </div>

                                    <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 507.8px;"><div class="slimscroll noti-scroll" style="overflow: hidden; width: auto; height: 507.8px;">

                                        <!-- item-->
                                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                                            <div class="notify-icon bg-light">
                                                <i class="mdi mdi-comment-account-outline"></i>
                                            </div>
                                            <p class="notify-details">系统通知
                                                <small class="text-muted">1 min ago</small>
                                            </p>
                                        </a>

                                        <!-- item-->
                                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                                            <div class="notify-icon bg-light">
                                                <i class="mdi mdi-comment-account-outline"></i>
                                            </div>
                                            <p class="notify-details">系统通知
                                                <small class="text-muted">2 min ago</small>
                                            </p>
                                        </a>

                                       <!-- item-->
                                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                                            <div class="notify-icon bg-light">
                                                <i class="mdi mdi-comment-account-outline"></i>
                                            </div>
                                            <p class="notify-details">系统通知
                                                <small class="text-muted">3 min ago</small>
                                            </p>
                                        </a>
                                    </div><div class="slimScrollBar" style="background: rgb(158, 165, 171); width: 8px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px; height: 121.053px;"></div><div class="slimScrollRail" style="width: 8px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div></div>

                                    <!-- All-->
                                    <a href="javascript:void(0);" class="dropdown-item text-center text-primary notify-item notify-all">
                                        暂无消息
                                        <i class="fi-arrow-right"></i>
                                    </a>

                                </div>
                            </li>

                            <li class="dropdown notification-list">
                                <a class="nav-link dropdown-toggle nav-user mr-0" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                    <img src="images/avatar-0.jpg" alt="user-image" class="rounded-circle">
                                    <small class="pro-user-name ml-1">
                                        Admin
                                    </small>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-animated profile-dropdown ">
                                    <!-- item-->
                                    <div class="dropdown-header noti-title">
                                        <h6 class="text-overflow m-0">欢迎 !</h6>
                                    </div>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <i class="fe-user"></i>
                                        <span>我的账户</span>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <i class="fe-settings"></i>
                                        <span>设置</span>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <i class="fe-lock"></i>
                                        <span>屏幕锁定</span>
                                    </a>

                                    <div class="dropdown-divider"></div>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <i class="fe-log-out"></i>
                                        <span>退出登录</span>
                                    </a>

                                </div>
                            </li>

                        </ul>
                        <button class="button-menu-mobile open-left disable-btn">
                            <i class="fe-menu"></i>
                        </button>
                        <div class="app-search">
                            <form>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="搜索...">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="submit">
                                            <i class="fe-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- end Topbar -->

                    <!-- Start Content-->
                    <div class="container-fluid">
                        
                        <!-- start page title -->
                        <div class="row">
                            <div class="col-12">
                                <div class="page-title-box">
                                    <div class="page-title-right">
                                        <ol class="breadcrumb m-0">
                                            <li class="breadcrumb-item"><a href="#">后台管理</a></li>
                                            <li class="breadcrumb-item"><a href="#">团费管理</a></li>
                                            <li class="breadcrumb-item active">删除团费</li>
                                        </ol>
                                    </div>
                                    <h4 class="page-title">删除团费</h4>
                                </div>
                            </div>
                        </div>     
                        <!-- end page title --> 

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="table-responsive"> 
            
                                            <table class="table mb-0 text-center" style="width:1174px;">
                                                <thead class="thead-light">
                                                    <tr>
                                                        <th>#</th>
                                                        <th>团费类型</th>
                                                        <th>价格</th>
                                                        <th>景点</th>
                                                        <th>操作</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="membership" items="${membershipsList}">
                                                        <tr>
                                                            <th scope="row"><c:out value="${membership.getmId()}"/></th>
                                                            <td><c:out value="${membership.getmName()}"/></td>
                                                            <td><c:out value="${membership.getmPrice()}"/></td>
                                                            <td><c:out value="${attractionsMap.get(membership.getmAttractionsId()).getaName()}"/></td>
                                                            <td><a href="manage?tableName=Membership&tableOperation=del&id=<c:out value="${membership.getmId()}"/>">删除</a></td>
                                                        </tr>
                                                    </c:forEach>
<!--                                                     <tr>
                                                        <th scope="row">1</th>
                                                        <td>YongKJ</td>
                                                        <td>1314520</td>
                                                        <td>勇往直前kj</td>
                                                        <td>dxj1718874198@gmail.com</td>
                                                        <td>小军君</td>
                                                        <td>男</td>
                                                        <td>1998-06-10</td>
                                                        <td>15218480260</td>
                                                        <td><a href="#">删除</a></td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">2</th>
                                                        <td>YongKJ</td>
                                                        <td>1314520</td>
                                                        <td>勇往直前kj</td>
                                                        <td>dxj1718874198@gmail.com</td>
                                                        <td>小军君</td>
                                                        <td>男</td>
                                                        <td>1998-06-10</td>
                                                        <td>15218480260</td>
                                                        <td><a href="#">删除</a></td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">3</th>
                                                        <td>YongKJ</td>
                                                        <td>1314520</td>
                                                        <td>勇往直前kj</td>
                                                        <td>dxj1718874198@gmail.com</td>
                                                        <td>小军君</td>
                                                        <td>男</td>
                                                        <td>1998-06-10</td>
                                                        <td>15218480260</td>
                                                        <td><a href="#">删除</a></td>
                                                    </tr> -->
                                                </tbody>
                                            </table>
                                        </div> <!-- end table-responsive -->
                                    </div> <!-- end card-body -->
                                </div>
                            </div>
                        </div>
                        <!-- end row -->

                        <div class="row">
                        </div>
                        <!-- end row -->

                        <div class="row">
                        </div>
                        <!-- end row -->
                    </div> <!-- container -->

                </div> <!-- content -->

            </div>

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->


        <!-- App js -->
        <script src="images/vendor.min.js"></script>
        <script src="images/app.min.js"></script>

        <!-- Plugins js -->
        <script src="images/chart.bundle.js"></script>
        <script src="images/jquery.sparkline.min.js"></script>
        <script src="images/jquery.knob.min.js"></script>

<!--         <script src="images/dashboard.init.js"></script> -->

    </body>

<!-- source http://www.scnoob.com More templates http://www.scnoob.com/moban -->
</html>