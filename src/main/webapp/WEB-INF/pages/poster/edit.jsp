<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>xx编辑页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<body>
<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
	<form class="form-horizontal" role="form" action="${path }/poster/doEdit.action" method="post">
	<input type="hidden" name="id" value="${entity.posterid }">
	<div class="form-group">
		<label for="postertitle" class="col-sm-2 control-label">postertitle</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="postertitle" name="postertitle" value="${entity.postertitle}"
				   placeholder="请输入postertitle">
		</div>
	</div>
	<div class="form-group">
		<label for="posterurl" class="col-sm-2 control-label">posterurl</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="posterurl" name="posterurl" value="${entity.posterurl}"
				   placeholder="请输入posterurl">
		</div>
	</div>
	<div class="form-group">
		<label for="qrcode" class="col-sm-2 control-label">qrcode</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="qrcode" name="qrcode" value="${entity.qrcode}"
				   placeholder="请输入qrcode">
		</div>
	</div>
	<div class="form-group">
		<label for="createtime" class="col-sm-2 control-label">createtime</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="createtime" name="createtime" value="${entity.createtime}"
				   placeholder="请输入createtime">
		</div>
	</div>
	<div class="form-group">
		<label for="changetime" class="col-sm-2 control-label">changetime</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="changetime" name="changetime" value="${entity.changetime}"
				   placeholder="请输入changetime">
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">提交</button>
			<a href="${path }/poster/list.action" class="btn btn-default">返回</a>
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