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
	<form class="form-horizontal" role="form" action="${path }/reservation/doEdit.action" method="post">
	<input type="hidden" name="reservationid" value="${entity.reservationid}">
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">username</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="username" name="username" value="${entity.username}"
				   placeholder="请输入username" >
		</div>
	</div>
	<div class="form-group">
		<label for="userphone" class="col-sm-2 control-label">userphone</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userphone" name="userphone" value="${entity.userphone}"
				   placeholder="请输入userphone">
		</div>
	</div>
	<div class="form-group">
		<label for="reservationresult" class="col-sm-2 control-label">reservationresult</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="reservationresult" name="reservationresult" value="${entity.reservationresult}"
				   placeholder="请输入reservationresult">
		</div>
	</div>	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">提交</button>
			<a href="${path }/reservation/list.action" class="btn btn-default">返回</a>
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