<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>海报模板列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
.imgwrap img{
	border: 1px black solid;
    box-shadow: 0 0 25px black;
}
.imgwrap .close{
	display: none;
	position: absolute;
	border-radius: 50%;
	background-color: black;
	top:-15px;
	right:-15px;
    width: 30px;
    height: 30px;
}
.imgwrap .close:before,.imgwrap .close:after{
	content:'';
	position:absolute;
	background:white;
	transform:rotate(45deg);
}
.imgwrap .close:before{
	left:20%;
	top:47%;
	width:60%;
	height:6%;
}
.imgwrap .close:after{
	left:47%;
	top:20%;
	width:6%;
	height:60%;
}
.imgwrap:hover .close{
	display: block;
}
</style>
</head>
<body style="width:98%">
	<div class="row">
		<div class="col-xs-12">
			<div>
				<!-- <input type="text" class="form-control-static" id="xxx"
					placeholder="请输入xxx">
					
				<button type="button" class="btn btn-default" id="search">查询</button> -->
				
				<a  href="${path }/poster/edit.action" class="btn btn-primary" id="add">新增</a>
				
			</div>
			<div class="table-responsive">
				<table id="mydatatables"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
						    <th></th>
							<th>标题</th>
							<th>图片</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	
	<div class="modal fade" id="imgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
		<div class="imgwrap">
			<div type="button" class="close" data-dismiss="modal" aria-hidden="true"></div>
	    	<img style="width:100%;">
	    </div>
		</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>

	<script type="text/javascript">
	
		jQuery(function($) {
		
			mydatatables = $('#mydatatables').DataTable(
							{
								"lengthMenu" : [[5,10,20,50],
										[5,10,20,50]],
								"pageLength" :10,
								"searching" : true,
								"ordering" : true,
								"processing" : true,
								"serverSide" : true,
								"autoWidth" : false,
								"dom": 'tiprl',//自定义显示项
								//跟数组下标一样，第一列从0开始，这里表格初始化时，
								//第四列默认降序
								"order" : [ [ 0, "desc" ] ],
								"ajax" : {
									"url" : "${path }/poster/rest/doSearch.action",
									"type" : "POST",
									"data" : function(pdata) {
										
										pdata.searchColumns={
												"xxxLike":$("#xxx").val()
										}
										var data = JSON.stringify(pdata);
										//JSON.parse();
										return data;
									},
									dataType : "json",
									processData : false,
									contentType : 'application/json;charset=UTF-8',
									error:function(data,e){
										alert(data.responseText);
									}
								},
								"columns" : [ 
							     {
									"data" : "createtime",
									"visible" : false
								},
								{
									"data" : "postertitle"
								},
								{
									"data" : "posterurl"
								},
								{
									"data" : "posterid",
									"orderable":false
								}],
								"columnDefs" : [
										{
											"render" : function(data, type, row) {
												return '<img onclick="showImg(this.src)" src="/images/'+data+'" data-rel="tooltip" title="查看图片" style="max-width:200px;">';
											},
											"targets" : 2
										},
										{
											"render" : function(data, type, row) {
												return '<p:permission privilege="com.sourong.poster.controller.PosterController:doEdit"><a href="${path }/poster/edit.action?id='+data+'" class="tooltip-success" data-rel="tooltip" title="修改"><span class="green"><i class="icon-edit bigger-120"></i></a></span></p:permission>&nbsp;&nbsp;'
												+'<p:permission privilege="com.sourong.poster.controller.PosterController:doDelete"><a href="javascript:void(0)" onclick="del(\''+data+'\')" class="tooltip-error" data-rel="tooltip" title="删除"><span class="red"><i class="icon-trash bigger-120"></i></span></a></p:permission>';
											},
											"targets" : 3
										} ],

								"language" : {
									"url" : "${path }/resources/assets/language/zh_CN.txt"
								}

							});

			$("#search").click(function() {
				
				mydatatables.ajax.reload();
			});
			
			$("#xxx").keydown(function(e) {
				if(e.keyCode==13){
					mydatatables.ajax.reload();
				}
			});

		});
		
		function del(id){
			if(window.confirm("你确定要删除？")){
				$.getJSON("${path }/poster/rest/doDelete.action?id="+id,
							function(data){
						alert(data.msg);
						if(data.status==1){
							mydatatables.ajax.reload();
						}
					});
			}
		}
		function showImg(src){
			$("#imgModal img").attr("src",src);
			$("#imgModal").modal("show");
		}
	</script>
</body>
</html>
