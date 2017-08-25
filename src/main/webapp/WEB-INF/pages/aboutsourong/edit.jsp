<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>区域编辑页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<body>
<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
	<form class="form-horizontal" role="form" action="${path }/aboutsourong/doEdit.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="sourongid" value="${entity.sourongid}">

	
	<div class="form-group">
		<label for="title" class="col-sm-2 control-label">大标题</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="title" name="title" value="${entity.title}"
				   placeholder="请输入大标题">
		</div>
	</div>
	<div class="form-group">
		<label for="specificdescribe" class="col-sm-2 control-label">具体描述</label>
		<div class="col-sm-10">
		<textarea class="form-control" id="specificdescribe" name="specificdescribe"  rows="5">${entity.specificdescribe}</textarea>
			
		</div>
	</div>
	<div class="form-group">
		<label for="picname" class="col-sm-2 control-label">图片</label>
		<div class="col-sm-10">
		<span style="display:inline;padding-left: 10px;color: #999">允许上传JPG,JPEG,PNG,BMP,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;jpg最适规格：900*515</span>
			<input style="display: inline;" type="file" name="pic" id="pic" onchange="previewFile()" /> 
		</div>
		<div class="col-sm-10" style="margin-top: 30px">
					<img src="/img/${entity.picname}"  class="img-thumbnail" style="max-width: 500px;max-height: 500px"  alt="Image preview..."/>   
							
				</div> 
				
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">提交</button>
			<a href="${path }/aboutsourong/list.action" class="btn btn-default">返回</a>
		</div>
	</div>
	</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>
	<script type="text/javascript">
	 function previewFile() {
		 var preview = document.querySelector('img');
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
	</script>
</body>
</html>