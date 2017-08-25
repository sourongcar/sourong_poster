<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>xxx列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
.title_1 {
    background: -webkit-linear-gradient(top, rgba(66,139,202,0.6), rgba(66,139,202,0.8)); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(top, rgba(66,139,202,0.6), rgba(66,139,202,0.8)); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(top, rgba(66,139,202,0.6), rgba(66,139,202,0.8)); /* Firefox 3.6 - 15 */
    background: linear-gradient(to top, rgba(66,139,202,0.6), rgba(66,139,202,0.8)); /* 标准的语法（必须放在最后） */
}
</style>
</head>
<body style="width:98%">
	<div class="row">
		<div class="col-xs-12">
			<div>
				<input type="text" class="form-control-static" id="searchUsername"
					placeholder="请输入用户名字">
				<input type="text" class="form-control-static" id="searchUserphone"
					placeholder="请输入用户联系方式">
					
				<button type="button" class="btn btn-default" id="search">查询</button>
				
				<%-- <a  href="${path }/wxuser/edit.action" class="btn btn-primary" id="add">新增</a> --%>
				
			</div>
			<div class="table-responsive">
				<table id="mydatatables"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
						    <th></th>
							<th>用户ID</th>
							<th>微信openid</th>
							<th>昵称</th>
							<th>头像</th>
							<th>联系方式</th>
							<th>姓名</th>
							<th>推荐人ID</th>
							<th>上下家</th>
							<!-- <th>角色</th>
							<th>createtime</th>
							<th>changetime</th> -->
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width:60%">
		<div class="modal-content" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<b>上下家</b>
				</h4>
			</div>
			<div class="modal-body" style="height:400px">
				<div  style="height:400px; overflow:auto">
					<div>
						<h5>上上家</h5>
						<div id="u_up" class="col-xs-12" style="border-top: 1px solid #696969;border-bottom:1px solid black;margin-top: 0.5vw;margin-bottom: 2vw;">
						</div>
					</div>
					<div>
						<h5>上家</h5>
						<div id="up" class="col-xs-12" style="border-top: 1px solid #696969;border-bottom:1px solid black;margin-top: 0.5vw;margin-bottom: 2vw;">
						</div>
					</div>
					<div>
						<h5>下家</h5>
						<div id="down" class="col-xs-12" style="border-top: 1px solid #696969;border-bottom:1px solid black;margin-top: 0.5vw;margin-bottom: 2vw;">
						</div>
					</div>
					<div>
						<h5>下下家</h5>
						<div id="d_down" class="col-xs-12" style="border-top: 1px solid #696969;border-bottom:1px solid black;margin-top: 0.5vw;margin-bottom: 2vw;">
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
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
								"order" : [ [ 0, "asc" ] ],
								"ajax" : {
									"url" : "${path }/wxuser/rest/doSearch.action",
									"type" : "POST",
									"data" : function(pdata) {
										
										pdata.searchColumns={
												"UsernameLike":$("#searchUsername").val(),
												"UserphoneLike":$("#searchUserphone").val()
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
									"data" : "userid"
								},
								{
									"data" : "openid"
								},
								{
									"data" : "nickname"
								},
								{
									"data" : "userphoto"
								},
								{
									"data" : "userphone"
								},
								{
									"data" : "username"
								},
								{
									"data" : "referrerid"
								},
								{
									"data" : "id",
									"orderable":false
								}],
								"columnDefs" : [
										{
											"render" : function(data, type, row) {
												return data&&("<img style='width:100px' src='"+data+"'>")||"未知";
											},
											"targets" : 4
										},
										{
											"render" : function(data, type, row) {
												return data||"未知";
											},
											"targets" : [5,6]
										},
										{
											"render" : function(data, type, row) {
												return data||"无";
											},
											"targets" : 7
										},
										{
											"render" : function(data, type, row) {
												return '<p:permission privilege="com.sourong.wxuser.controller.WxuserController:doEdit"><a href="${path }/wxuser/edit.action?id='+row.userid+'" class="tooltip-success" data-rel="tooltip" title="修改"><span class="green"><i class="icon-search bigger-120"></i></a></p:permission>&nbsp;&nbsp;';
											},
											"targets" : 9
										},{
											"render" : function(data, type, row) {
												return "<button class='btn btn-danger' data-toggle='modal' data-target='#myModal'"+ 
												"onclick=getUpAndDown("+row.userid+") style=' line-height: 0.5;font-size: 11px;padding: 7px 10px;'>查看</button>"
											},
											"targets" : 8,
											"width": "7%"
										}, ],

								"language" : {
									"url" : "${path }/resources/assets/language/zh_CN.txt"
								}

							});

			$("#search").click(function() {
				
				mydatatables.ajax.reload();
			});
			
			$("#searchUsername,#searchUserphone").keydown(function(e) {
				if(e.keyCode==13){
					mydatatables.ajax.reload();
				}
			});

		});
		
		function del(id){
			if(window.confirm("你确定要删除？")){
				$.getJSON("${path }/wxuser/rest/doDelete.action?id="+id,
							function(data){
						alert(data.msg);
						if(data.status==1){
							mydatatables.ajax.reload();
						}
					});
			}
		}
		
		function getUpAndDown(id){
			$("#u_up").html('<div style="margin: 1vw 0">null</div>');
			$("#up").html('<div style="margin: 1vw 0">null</div>');
			$("#down").html('<div style="margin: 1vw 0">null</div>');
			$("#d_down").html('<div style="margin: 1vw 0">null</div>');
			$.ajax({
				  "url":"${path}/wxuser/rest/getUpAndDown.action",
					"type":"POST",
					"data":{"id":id},
					"dataType":"json",
					"success":function(data){
						console.log(data);
						var data0 = data[0];
						var data1 = data[1];
						var data2 = data[2];
						var data3 = data[3];
						console.log(data0)
						if(data0!=null){
							var html = '<div class="col-sm-4 col-md-4 col-xs-4" style="margin:1vw 0;text-align:center">'+data0.username+'</div>'+'<div class="col-sm-8 col-md-8 col-xs-8" style="margin:1vw 0;text-align:center">'+data0.userphone+'</div>';
							$("#u_up").html(html);
						}
						if(data1!=null){
							var html = '<div class="col-sm-4 col-md-4 col-xs-4" style="margin:1vw 0;text-align:center">'+data1.username+'</div>'+'<div class="col-sm-8 col-md-8 col-xs-8" style="margin:1vw 0;text-align:center">'+data1.userphone+'</div>';
							$("#up").html(html);
						}
						if(data2!=null){
							console.log(data2)
							$("#down").html("");
							for(var i=0;i<data2.length;i++){
								var html = '<div class="col-sm-4 col-md-4 col-xs-4" style="margin:1vw 0;text-align:center">'+data2[i].username+'</div>'+'<div class="col-sm-8 col-md-8 col-xs-8" style="margin:1vw 0;text-align:center">'+data2[i].userphone+'</div>';
								$("#down").append(html);
					        }
						}
					},
					"error":function(data){
					}
			  })
		}
	</script>
</body>
</html>
