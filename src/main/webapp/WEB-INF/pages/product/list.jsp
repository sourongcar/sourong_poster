<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>产品概况列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
</style>
</head>
<body style="width:98%">
	<div class="row">
		<div class="col-xs-12">
			<div>
				<input type="text" class="form-control-static" id="productname"
					placeholder="请输入产品名称">
					
				<button type="button" class="btn btn-default" id="search">查询</button>
				
				<a  href="${path }/product/edit.action" class="btn btn-primary" id="add">新增</a>
				<a href="${path }/create/html.action" class="btn btn-primary">生成新的页面</a>
			</div>
			<div class="table-responsive">
				<table id="mydatatables"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
						
							
							<th>产品名称</th>
							<th>产品介绍</th>
							<th>对应图标</th>
							
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>

			</div>
		</div>
	</div>
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
								"order" : [ [ 3, "desc" ] ],
								"ajax" : {
									"url" : "${path }/product/rest/doSearch.action",
									"type" : "POST",
									"data" : function(pdata) {
										
										pdata.searchColumns={
												"ProductnameLike":$("#productname").val()
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
									"data" : "productname"
								},
								{
									"data" : "productintro"
								},
								{
									"data" : "icon"
								},	
								{
									"data" : "productid",
									"orderable":false
								}],
								"columnDefs" : [
									
										{
											"render" : function(data, type, row) {
												return '<p:permission privilege="com.sourongindex.product.controller.ProductController:doEdit"><a href="${path }/product/edit.action?productid='+row.productid+'" class="tooltip-success" data-rel="tooltip" title="修改"><span class="green"><i class="icon-edit bigger-120"></i></a></p:permission>&nbsp;&nbsp;'
												+'<p:permission privilege="com.sourongindex.product.controller.ProductController:doDelete"><a href="javascript:void(0)" onclick="del(\''+row.productid+'\')" class="tooltip-error" data-rel="tooltip" title="删除"><span class="red"><i class="icon-trash bigger-120"></i></a></p:permission>';
											},
											"targets" : 3
										},
										{
											"render" : function(data, type, row) {
												return '<div><img id="banner" src="/img/'+row.icon+'"  width="50px" height="50px" alt="图片加载不了。。。"/></div>';
											},
											"targets" : 2
										},
										],

								"language" : {
									"url" : "${path }/resources/assets/language/zh_CN.txt"
								}

							});

			$("#search").click(function() {
				
				mydatatables.ajax.reload();
			});
			
		

		});
		
		function del(productid){
			if(window.confirm("你确定要删除？")){
				$.getJSON("${path }/product/rest/doDelete.action?productid="+productid,
							function(data){
						alert(data.msg);
						if(data.status==1){
							mydatatables.ajax.reload();
						}
					});
			}
		}
	</script>
</body>
</html>
