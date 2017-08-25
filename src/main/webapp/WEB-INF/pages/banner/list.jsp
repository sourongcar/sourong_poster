<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>轮播图列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
</style>
</head>
<body style="width:98%">
	<div class="row">
		<div class="col-xs-12">
			<div>
				
				<a  href="${path }/banner/edit.action" class="btn btn-primary" id="add">新增</a>
				<a href="${path }/create/html.action.action" class="btn btn-primary">生成新的页面</a>
			</div>
			<div class="table-responsive">
				<table id="mydatatables"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>						 
							<th>轮播图</th>
							<th>图片介绍</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	<!-- 图片模态框（Modal） -->
<div class="modal fade" id="lookpic" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            	<form class="form-horizontal" role="form" action="" method="post" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">轮播图</h4>
            </div>
            <div class="modal-body">
			<div class="form-group">
				<img id="modelpic" src=""  style="max-height: 500px;max-width: 500px;display:block;margin: 0 auto" alt="这里是图片"  />
			</div>	
			</div>			
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
			 </form>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal-dialog -->
		</div>
<!-- /.modal -->
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>

	<script type="text/javascript">
	
		jQuery(function($) {
		
			mydatatables = $('#mydatatables').DataTable(
							{
								"lengthMenu" : [[10,20,50,1000],
										[10,20,50,"All"]],
								"pageLength" :10,
								"searching" : true,
								"ordering" : true,
								"processing" : true,
								"serverSide" : true,
								"autoWidth" : false,
								"dom": 'tiprl',//自定义显示项
								//跟数组下标一样，第一列从0开始，这里表格初始化时，
								//第四列默认降序
								"order" : [ [ 2, "desc" ] ],
								"ajax" : {
									"url" : "${path }/banner/rest/doSearch.action",
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
									"data" : "picname"
								},
								{
									"data" : "picintro"
								},
								
								
								{
									"data" : "bannerid",
									"orderable":false
								}],
								"columnDefs" : [
									
										{
											"render" : function(data, type, row) {
												return '<p:permission privilege="com.sourongindex.banner.controller.BannerController:doEdit"><a href="${path }/banner/edit.action?bannerid='+row.bannerid+'" class="tooltip-success" data-rel="tooltip" title="修改"><span class="green"><i class="icon-edit bigger-120"></i></a></p:permission>&nbsp;&nbsp;'
												+'<p:permission privilege="com.sourongindex.banner.controller.BannerController:doDelete"><a href="javascript:void(0)" onclick="del(\''+row.bannerid+'\')" class="tooltip-error" data-rel="tooltip" title="删除"><span class="red"><i class="icon-trash bigger-120"></i></a></p:permission>';
											},
											"targets" : 2
										},
										{
											"render" : function(data, type, row) {
												return '<div data-toggle="modal" data-target="#lookpic" onclick="look(\''+row.picname+'\')"><img id="banner" src="/img/'+row.picname+'"  width="50px" height="50px" alt="图片加载不了。。。"/></div>';
											
											},
											"targets" : 0
										} 
										],

								"language" : {
									"url" : "${path }/resources/assets/language/zh_CN.txt"
								}

							});

			$("#search").click(function() {
				
				mydatatables.ajax.reload();
			});
			
			

		});
		
		function del(bannerid){
			if(window.confirm("你确定要删除？")){
				$.getJSON("${path }/banner/rest/doDelete.action?bannerid="+bannerid,
							function(data){
						alert(data.msg);
						if(data.status==1){
							mydatatables.ajax.reload();
						}
					});
			}
		}
		function look(picname){
			var asd="/img/"+picname;
			$("#modelpic").attr("src",asd);									
		}
	</script>
</body>
</html>
