<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>公司编辑页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<body>
<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
	<form class="form-horizontal" role="form" action="${path }/companyinfom/doEdit.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="companyid" value="${entity.companyid}">

	<div class="form-group">
		<label for="companyname" class="col-sm-2 control-label">公司名称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="companyname" name="companyname" value="${entity.companyname}"
				   placeholder="请输入公司名称" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="servicephone" class="col-sm-2 control-label">服务电话</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="servicephone" name="servicephone" value="${entity.servicephone}"
				   placeholder="请输入服务电话" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="servicetime" class="col-sm-2 control-label">服务时间</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="servicetime" name="servicetime" value="${entity.servicetime}"
				   placeholder="请输入服务时间" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="companyaddress" class="col-sm-2 control-label">公司地址</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="companyaddress" name="companyaddress" value="${entity.companyaddress}"
				   placeholder="请输入公司地址" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="detailaddress" class="col-sm-2 control-label">详细地址</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="detailaddress" name="detailaddress" value="${entity.detailaddress}"
				   placeholder="请输入详细地址">
		</div>
	</div>
	
	<div class="form-group">
		<label for="companylogo" class="col-sm-2 control-label">公司logo</label>
		<div class="col-sm-10">
			<span style="display:inline;padding-left: 10px;color: #999">允许上传JPG,JPEG,PNG,BMP,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;png最适规格：799*180</span>
			<input style="display: inline;" type="file" name="logopic" id="logopic" onchange="previewFile()" />
			
		<div class="col-sm-10" style="margin-top: 30px">
					<img id="logoimg" src="/img/${entity.companylogo}"  class="img-thumbnail" style="max-width: 300px;max-height: 300px"  alt="Image preview..."/>   
							
				</div> 
	</div>
	</div>
	<div class="form-group">
		<label for="companyqr" class="col-sm-2 control-label">公众号二维码</label>
		<div class="col-sm-10">
			<span style="display:inline;padding-left: 10px;color: #999">允许上传JPG,JPEG,PNG,BMP,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;jpeg最适规格：240*240</span>
			<input style="display: inline;" type="file" name="qrpic"  id="qrpic" onchange="previewFileqr()" />		
		</div>
		<div class="col-sm-10" style="margin-top: 30px">
					<img id="qrimg" src="/img/${entity.companyqr}"  style="max-width: 500px;max-height: 500px"  alt="Image preview..."/>   
							
				</div> 
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">提交</button>
			<a href="${path }/companyinfom/list.action" class="btn btn-default">返回</a>
		</div>
	</div>
	</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>
	<script type="text/javascript">
	function previewFile() {
		 var preview = document.querySelector('#logoimg');
		 var file  = document.querySelector('input[type=file]').files[0];	
		 var reader = new FileReader();
		 reader.onloadend = function () {
		  preview.src = reader.result; 
		 }
		 if (file) {
		  reader.readAsDataURL(file);
		 } else {
		  preview.src = "";
		 }
		}
	function previewFileqr(){
		 var preview = document.querySelector('#qrimg');
		 var file =  document.querySelector('#qrpic').files[0];
		 var reader = new FileReader();
		 reader.onloadend = function () {
		  preview.src = reader.result;
		 }
		 if (file) {
		  reader.readAsDataURL(file);
		 } else {
		  preview.src = "";
		 }
		} 
	
	</script>
</body>
</html>