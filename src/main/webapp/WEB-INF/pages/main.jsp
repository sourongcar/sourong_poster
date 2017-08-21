<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>搜融好车后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
</head>
<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-desktop"></i> 搜融好车官网后台管理
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="${path }/resources/assets/avatars/user.jpg"
							alt="J${s_user.name }的头像" /> <span class="user-info"> <small>欢迎,</small>
								${s_user.name }
						</span> <i class="icon-caret-down"></i>
					</a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<%-- <li><a href="${path}/user/updatePassword.action"> <i class="icon-user"></i> 修改密码
							</a></li>
							<li class="divider"></li> --%>

							<li><a href="${path }/loginout.action"> <i
									class="icon-off"></i> 注销
							</a></li>
							<li><a href="${path}/user/updatePassword.action" target="contentframe"><i
									class="icon-lock"></i> 修改密码</a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
		//防止iframe页面内嵌
		
		if (window != top) 
		top.location.href = location.href; 
           try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="icon-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="icon-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="icon-group"></i>
						</button>

						<button class="btn btn-danger">
							<i class="icon-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->
				<ul class="nav nav-list">
					<!-- 此处添加菜单 -->
					<li>
						<a href="#" class="dropdown-toggle"> <i class="icon-wrench"></i> <span class="menu-text">系统管理</span><b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li>
								<a href="${path }/user/list.action"target="contentframe"><i class="icon-double-angle-right"></i>管理员列表</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#" class="dropdown-toggle"> <i class="icon-user"></i> <span class="menu-text">用户管理</span><b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li>
								<a href="${path }/wxuser/list.action"target="contentframe"><i class="icon-double-angle-right"></i>用户列表</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#" class="dropdown-toggle"> <i class="icon-qrcode"></i> <span class="menu-text">海报模板管理</span><b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li>
								<a href="${path }/poster/list.action?isRead=0"target="contentframe"><i class="icon-double-angle-right"></i>海报模板列表</a>
							</li>
						</ul>
					</li>
				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs"></div>

				<div style="height:calc(100vh - 89px)">
					<iframe width="100%" height="100%" id="contentframe" name="contentframe"
								onload="ifmresize();this.contentWindow.document.body.style.padding='15px';" frameborder="0" scrolling="yes"
								src="${path}/user/list.action"> </iframe>
				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->


			<!-- /#ace-settings-container -->
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>
	<script type="text/javascript">
		var ifm = document.getElementById("contentframe");
		function ifmresize() {
			//var win=ifm.contentWindow;
			//console.log(win.document.body.clientHeight);
			//setTimeout(function(){ifm.height = win.document.body.clientHeight;},0);
			//win.onresize=innerResize;
		}
		function innerResize(){
			//console.log(this.document.body.clientHeight);
			//var h=this.document.body.clientHeight;
			//setTimeout(function(){ifm.height = h;},0);
		}
		window.onresize = function() {
			//console.log('window resize');
			//ifm.contentWindow.onresize();
			//ifmresize();
			//$("#contentframe").parent()[0].style.height=(document.documentElement.clientHeight-89)+'px';
		}
			//$("#contentframe").parent()[0].style.height=(document.documentElement.clientHeight-89)+'px';
		$(function() {
			$(".nav-list li:first").addClass("active").addClass('open');
			$(".submenu li:first").addClass("active");
			$(".nav-list>li").unbind('click').click(function() {
				//$(".nav-list>li[class='active']").removeAttr("class");
			});
			$(".submenu li").unbind('click').click(function() {
				var parent=$(this).parent();
				$(".submenu li.active").removeClass("active");
				$(".nav-list>li.active").removeClass("active");
				$(this).addClass("active").parents('li').addClass("active").addClass('open');
				$(".nav-list>li.open>.submenu").each(function(){if(parent[0]!=this)$(this).slideUp(200).parent().removeClass('open');})
			});
		});
	</script>
</body>
</html>