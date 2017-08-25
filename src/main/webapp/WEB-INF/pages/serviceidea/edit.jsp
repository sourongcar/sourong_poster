<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>服务理念编辑页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form" method="post" id="editform" enctype="multipart/form-data">
					<input type="hidden" name="serviceideaid" value="${entity.serviceideaid }">
					<div class="form-group">
						<label for="ideadescribe" class="col-sm-2 control-label">理念描述</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="3" id="ideadescribe"
								name="ideadescribe" placeholder="请输入服务理念描述，不超过128个字">${entity.ideadescribe }</textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="brandpic" class="col-sm-2 control-label">理念图片</label>
						<div class="col-sm-10">
							<span style="display: inline; padding-left: 10px; color: #999">只允许上传图片</span>
							<input style="display: inline;" type="file" name="pic" id="pic"
								onchange="previewFile()" />
						</div>
						<div class="col-sm-10" style="margin-top: 30px">
							<img src="/img/${entity.picname}" class="img-thumbnail"
								style="max-width: 500px; max-height: 500px" alt="图片预览" />

						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-primary" onclick="doEdit()">提交</button>
							<a href="${path }/serviceidea/list.action"
								class="btn btn-default">返回</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>
	<script type="text/javascript">
		//预览图片
		function previewFile() {
			var preview = document.querySelector('img');
			var file = document.querySelector('input[type=file]').files[0];
			var reader = new FileReader();
			reader.onloadend = function() {
				preview.src = reader.result;
			}
			if (file) {
				reader.readAsDataURL(file);
			} else {
				preview.src = "";
			}
		}
		//提交编辑表单
		function doEdit() {
			 var form = new FormData($('#editform')[0]);
			$.ajax({
				url : "${path }/serviceidea/doEdit.action",
				type : "POST",
				data : form,
				processData:false,
                contentType:false,
				dataType : "json",
				success : function(data) {
					console.log(data.status);
					console.log(data.msg);
					if(data.status==1){
						alert(data.msg);
						window.location.href = "${path }/serviceidea/list.action";
					}else{
						alert(data.msg);
					}
				},
				error : function() {
					alert("编辑请求失败,请重试");
				}
					
			});
		}
	</script>
</body>
</html>