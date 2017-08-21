<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>用户编辑页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<body>
<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
	<form class="form-horizontal" role="form" action="${path }/wxuser/doEdit.action" method="post">
	<input type="hidden" name="id" value="${entity.userid }">
	<%-- <div class="form-group">
		<label for="userid" class="col-sm-2 control-label">用户ID</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userid" name="userid" value="${entity.userid}"
				   placeholder="请输入用户ID">
		</div>
	</div> --%>
	<div class="form-group">
		<label for="openid" class="col-sm-2 control-label">微信openid</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="openid" name="openid" value="${entity.openid}"
				   placeholder="请输入微信openid">
		</div>
	</div>
	<div class="form-group">
		<label for="nickname" class="col-sm-2 control-label">用户昵称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nickname" name="nickname" value="${entity.nickname}"
				   placeholder="请输入用户昵称">
		</div>
	</div>
	<div class="form-group">
		<label for="userphoto" class="col-sm-2 control-label">用户头像</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userphoto" name="userphoto" value="${entity.userphoto}"
				   placeholder="请输入用户头像">
		</div>
	</div>
	<div class="form-group">
		<label for="userphone" class="col-sm-2 control-label">联系方式</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userphone" name="userphone" value="${entity.userphone}"
				   placeholder="请输入联系方式">
		</div>
	</div>
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">用户姓名</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="username" name="username" value="${entity.username}"
				   placeholder="请输入用户姓名">
		</div>
	</div>
	<div class="form-group">
		<label for="referrerid" class="col-sm-2 control-label">推荐人ID</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="referrerid" name="referrerid" value="${entity.referrerid}"
				   placeholder="请输入推荐人ID">
		</div>
	</div>
	<%-- <div class="form-group">
		<label for="role" class="col-sm-2 control-label">用户角色</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="role" name="role" value="${entity.role}"
				   placeholder="请输入用户角色">
		</div>
	</div>
	<div class="form-group">
		<label for="createtime" class="col-sm-2 control-label">创建时间</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="createtime" name="createtime" value="${entity.createtime}"
				   placeholder="请输入createtime">
		</div>
	</div>
	<div class="form-group">
		<label for="changetime" class="col-sm-2 control-label">最后修改时间</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="changetime" name="changetime" value="${entity.changetime}"
				   placeholder="请输入最后修改时间">
		</div>
	</div> --%>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">提交</button>
			<a href="${path }/wxuser/list.action" class="btn btn-default">返回</a>
		</div>
	</div>
	</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>
	<script type="text/javascript">
		jQuery(function($) {
			
		});
	</script>
</body>
</html>