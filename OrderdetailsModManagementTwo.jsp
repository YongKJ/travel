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

                            <li>
                                <a href="javascript: void(0);">
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
                                    <li>
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

                            <li class="active">
                                <a href="javascript: void(0);" class="active">
                                    <i class="dripicons-to-do"></i>
                                    <span> 订单管理 </span>
                                    <span class="menu-arrow"></span>
                                </a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li>
                                        <a href="manage?tableName=Order&tableOperation=add">添加订单</a>
                                    </li>
                                    <li class="active">
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
                                            <li class="breadcrumb-item"><a href="#">订单管理</a></li>
                                            <li class="breadcrumb-item active">修改订单</li>
                                        </ol>
                                    </div>
                                    <h4 class="page-title">修改订单</h4>
                                </div>
                            </div>
                        </div>     
                        <!-- end page title --> 

                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <form class="form-horizontal" method="post" action="manage?tableName=Order&tableOperation=modTwo&id=<c:out value="${ordersMap.get(orderdetails.getdOrderId()).getoId()}"/>">
                                            
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">订单金额</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="oPrice" class="form-control" value="<c:out value="${ordersMap.get(orderdetails.getdOrderId()).getoPrice()}"/>">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">订单状态</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="oState" class="form-control" value="<c:out value="${ordersMap.get(orderdetails.getdOrderId()).getoState()}"/>">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">下单时间</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="oData" class="form-control" data-toggle="input-mask" data-mask-format="0000-00-00 00:00:00.0" maxlength="21" value="<c:out value="${ordersMap.get(orderdetails.getdOrderId()).getoData()}"/>">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">下单数量</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="number" class="form-control" value="<c:out value="${orderdetails.getNumber()}"/>">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">景点</label>
                                                <div class="col-sm-10">
                                                    <select name="aName" class="wide" data-plugin="customselect">
                                                        <option selected=""><c:out value="${attractionsMap.get(orderdetails.getdAttractionsId()).getaName()}"/></option>
                                                        <c:forEach var="attractions" items="${attractionsMap}">
                                                            <option value="<c:out value="${attractions.value.getaName()}"/>"><c:out value="${attractions.value.getaName()}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">用户账号</label>
                                                <div class="col-sm-10">
                                                    <select name="bNumber" class="wide" data-plugin="customselect">
                                                        <option selected=""><c:out value="${busertablesMap.get(ordersMap.get(orderdetails.getdOrderId()).getoBUserTableId()).getbNumber()}"/></option>
                                                        <c:forEach var="busertable" items="${busertablesMap}">
                                                            <option value="<c:out value="${busertable.value.getbNumber()}"/>"><c:out value="${busertable.value.getbNumber()}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row">
                                            	<label class="col-sm-2 col-form-label"></label>
                                                <div class="col-sm-10">
                                                    <button type="submit" class="btn btn-info">提交</button>
                                                </div>
                                            </div>
            
                                        </form>
                                    </div> <!-- end card-body -->
                                </div>
                            </div>
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
<!--         <script src="images/chart.bundle.js"></script>
        <script src="images/jquery.sparkline.min.js"></script>
        <script src="images/jquery.knob.min.js"></script> -->

<!--         <script src="images/dashboard.init.js"></script> -->

    </body>

<!-- source http://www.scnoob.com More templates http://www.scnoob.com/moban -->
</html>