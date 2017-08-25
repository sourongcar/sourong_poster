<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>顾问编辑页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form" method="post"
					id="editform" enctype="multipart/form-data">
					<input type="hidden" name="consultantid"
						value="${entity.consultantid}">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								value="${entity.name}" placeholder="请输入顾问姓名">
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label">手机号码</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="phone" name="phone"
								value="${entity.phone}" placeholder="请输入电话号码">
						</div>
					</div>
					<div class="form-group">
						<label for="company" class="col-sm-2 control-label">所属公司</label>
						<div class="col-sm-10">
							<select class="form-control" id="company" name="company">
								<c:forEach items="${companys }" var="c">
									<%-- <option value="${c.companyname }">${c.companyname }</option> --%>
									<<c:choose>
									<c:when test="${c.companyname == entity.company }">
										<option value="${c.companyname }" selected="selected">${c.companyname }</option>
    								</c:when>
									<c:otherwise>
										<option value="${c.companyname }">${c.companyname }</option>
    								</c:otherwise>
    								</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="brandpic" class="col-sm-2 control-label">顾问照片</label>
						<div class="col-sm-10">
							<span style="display: inline; padding-left: 10px; color: #999">只允许上传图片</span>
							<input style="display: inline;" type="file" name="pic" id="pic"
								onchange="previewFile()" />
						</div>
						<div class="col-sm-10" style="margin-top: 30px">
							<img src="/img/${entity.consultantpic}" class="img-thumbnail"
								style="max-width: 500px; max-height: 500px" alt="图片预览" />

						</div>

					</div>
					<div class="form-group">
						<label for="remarks" class="col-sm-2 control-label">备注</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="remarks"
								value="${entity.remarks}" name="remarks"
								placeholder="请输入备注,不超过125个字">
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-2 control-label">状态</label>
						<div class="col-sm-10">
							<select class="form-control" id="state" value="${entity.state }" name="state">
								<c:choose>
									<c:when test="${entity.state == 0 }">
										<option value="0" selected="selected">正常</option>
										<option value="1">锁定</option>
	    							</c:when>
	    							<c:when test="${entity.state == 1 }">
										<option value="0">正常</option>
										<option value="1" selected="selected">锁定</option>
	    							</c:when>
									<c:otherwise>
										<option value="0">正常</option>
										<option value="1">锁定</option>
	    							</c:otherwise>
    							</c:choose>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="jobtitle" class="col-sm-2 control-label">职称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="jobtitle"
								value="${entity.jobtitle}" name="jobtitle"
								placeholder="请输入职称，不超过10个字">
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" onclick="doEdit()" class="btn btn-primary">提交</button>
							<a href="${path }/consultant/list.action" class="btn btn-default">返回</a>
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
			$
					.ajax({
						url : "${path }/consultant/doEdit.action",
						type : "POST",
						data : form,
						processData : false,
						contentType : false,
						dataType : "json",
						success : function(data) {
							console.log(data.status);
							console.log(data.msg);
							if (data.status == 1) {
								alert(data.msg);
								window.location.href = "${path }/consultant/list.action";
							} else {
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