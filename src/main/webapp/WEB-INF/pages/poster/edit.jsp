<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>海报模板编辑页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
.poster_preview>div{
	position: relative;
	display:inline-block;
	width: 480px;
	height: 800px;
	overflow: hidden;
	border: 3px solid #222;
	box-shadow: 5px 5px 15px grey;
	box-sizing:content-box
}
.poster_preview>div>div img{
	opacity:0;
	transition:opacity .3s ease-in;
}
.poster_preview>div> div:hover img{
	opacity: 1;
}
</style>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-xs-12 column">
				<form class="form-horizontal" role="form"
					action="${path }/poster/doEdit.action" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="posterid" value="${entity.posterid }">
					<div class="form-group">
						<label for="postertitle" class="col-sm-2 control-label">标题</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="postertitle"
								name="postertitle" value="${entity.postertitle}">
							<span class="red"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="posterurl" class="col-sm-2 control-label">图片</label>
						<div class="col-sm-10">
							<input type="hidden" class="form-control" id="posterurl"
								name="posterurl" value="${entity.posterurl}">
							<label class="btn btn-success"><i class="icon-upload bigger-120"></i>点击上传 
								<input id="pic" name="pic" type="file" style="display: none" accept="image/png,image/gif,image/jpeg">
							</label>
							<span class="red"></span>
						</div>
					</div>
					<%-- <div class="form-group">
							<label for="qrcode" class="col-sm-2 control-label">qrcode</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="qrcode" name="qrcode" value="${entity.qrcode}"
									   placeholder="请输入qrcode">
							</div>
						</div> --%>

					<div class="form-group">
						<div style="text-align:center;">
							<button type="submit" class="btn btn-primary">提交</button>
							<a href="${path }/poster/list.action" class="btn btn-default">返回</a>
						</div>
					</div>
				</form>
				<h4 style="text-align: center;">二维码将展示在下图虚线框中</h4>
				<h4 style="text-align: center;">请选好海报的尺寸(480&times;800)</h4>
				<div class="poster_preview" style="text-align: center;">
					<div>
						<img<c:if test="${entity.posterurl ne null }"> src="/images/${entity.posterurl}"</c:if>>
						<div style="position: absolute; left: 115px; top: 475px; width:240px;height:240px;border: 5px dashed #ddd">
							<img style="width:100%;height:100%" src="${path }/resources/assets/images/ewm.jpeg">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>
	<script type="text/javascript">
		jQuery(function($) {
			var picchange;
			
			$("#pic").change(function(){
				if($("#posterurl").val().length>0){
					picchange=true;
				}
				var file=this.files;
				var self=this;
				if(file.length==1&&file[0].type in {"image/jpeg":true,"image/png":true,"image/gif":true}&&file[0].size<524288){
					var reader=new FileReader();
					reader.onload=function(){
						$(".poster_preview>div>img").attr("src",reader.result);
						reader=null;
						$(self).parent().next().text("");
					}
					reader.onerror=function(){
						self.value='';
						$(self).parent().next().text("图片读取失败，请重新上传");
					}
					reader.readAsDataURL(file[0]);
				}
				else{
					var p=$(this).parent();
					p.children("img").removeAttr('src');
					p.next().text("文件格式应为jpg，png或gif，大小不超过512k");
					this.value='';
				}
				file=null;
			});
			$('form').submit(function(e){
				if(!validate.check()){
					e.preventDefault();
					return false;
				}
				else{
					var files=$("#pic")[0].files;
					if((!files||files.length==0)&&($("#posterurl").val().length==0||picchange)){
						$("#pic").parent().next().text("必须上传图片");
						e.preventDefault();
						return false;
					}
				}
			});
			function validate(data){
				arguments.callee.list||(arguments.callee.list=[]);
				arguments.callee.list.push(data);
				var f=function(){
					var self=$(this);
					if(self.val().match("^"+data.pattern+"$")&&(data.length?self.val().length<=data.length:true))
						self.next().text(data.success||"").addClass("green");
					else
						self.next().text(data.error||"输入错误").removeClass("green");
				}
				$(data.el).focus(f).blur(f);
				return arguments.callee;
			}
			validate.check=function(){
				if(this.list)
				for(var i=0;i<this.list.length||0;i++){
					var data=this.list[i];
					if([].join.call($(data.el).map(function(){
						if($(this).val().match("^"+data.pattern+"$")&&(data.length?$(this).val().length<=data.length:true))
							return null;
						else{
							this.focus();
							return false;
						}
					}),'').length>0)
					return false;
				}
				return true;
			};
			validate({el:"#postertitle",pattern:".{1,25}",error:"必填，最多25个字符"})
		});
	</script>
</body>
</html>