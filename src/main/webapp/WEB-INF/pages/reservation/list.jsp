<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>待咨询用户列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
</style>
</head>
<body style="width:98%">
	<div class="row">
		<div class="col-xs-12">
			<div>
				<input type="text" class="form-control-static" id="username"
					placeholder="请输入用户姓名">
				<input type="text" class="form-control-static" id="userphone"
					placeholder="请输入用户电话">	
				<button type="button" class="btn btn-default" id="search">查询</button>
			</div>
			<div class="table-responsive">
				<table id="mydatatables"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
						    <th></th>
							<th>编号</th>
							<th>咨询用户姓名</th>
							<th>用户电话</th>
							<th>咨询结果</th>
							<th>登记时间</th>
							<th>上下家</th>
							<th >操作</th>
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
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					查看上家
				</h4>
			</div>
			<div class="modal-body">
				<span></span>
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
	 function getUrlParam(name) {
         var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
         var r = window.location.search.substr(1).match(reg);  //匹配目标参数
         if (r != null) return unescape(r[2]); return null; //返回参数值
     }
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
								"order" : [ [ 0, "desc" ] ],
								"ajax" : {
									"url" : "${path }/reservation/rest/doSearch.action",
									"type" : "POST",
									"data" : function(pdata) {
										var isRead =getUrlParam("isRead");
										pdata.searchColumns={
												"UsernameLike":$('#username').val(),
												"UserphoneLike":$("#userphone").val(),
												"DisposalEqualTo":parseInt(isRead)
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
									"data" : "registertime",
									"visible" : false
								},
								{
									"data" : "reservationid"
								},
								{
									"data" : "username"
								},
								{
									"data" : "userphone"
								},
								{
									"data" : "reservationresult",
									
								},
								{
									"data" : "registertime"
								},
								{
									"data" : "reservationid",
									"orderable":false
								}],
								"columnDefs" : [{
									"render" : function(data, type, row,meta) {
										if(row.disposal == 1){
											return "<button onClick=checkContent(this) data-toggle='modal' data-target='#myModal' class='btn btn-info' style='line-height: 0.5;font-size: 11px;padding: 7px 10px;'>查看咨询结果</button>";
										}else if(row.disposal == 0){
											return "<button onClick=recordContent(this) data-toggle='modal' data-target='#myModal' class='btn btn-info' style='line-height: 0.5;font-size: 11px;padding: 7px 10px;'>记录咨询结果</button>"+
											"<button onClick=mark("+row.reservationid+") class='btn btn-success' style=' line-height: 0.5;font-size: 11px;padding: 7px 10px;'>标记为已查看</button>" ; 
										}
									},
									"targets" :7,
									"width": "40%"
								},{
									"render" : function(data, type, row,meta) {		
								
								      return 	"<button onClick=checkPartner("+row.userid+") data-toggle='modal' data-target='#myModal' class='btn btn-warning' style='width:102px;line-height: 0.5;font-size: 11px;padding: 7px 10px;'>查看上家</button>"
									},
									"targets" :6,
									"width": "10%"
								},{
									"render" : function(data, type, row,meta) {		
										
									      return data||"无"
										},
										"targets" :4
								}
								],

								"language" : {
									"url" : "${path }/resources/assets/language/zh_CN.txt"
								}

							});

			$("#search").click(function() {
				mydatatables.ajax.reload();
			});
			
			$("#username,#userphone").keydown(function(e) {
				if(e.keyCode==13){
					mydatatables.ajax.reload();
				}
			});
		  var isRead =getUrlParam("isRead");
			if(isRead==0){
				$('#mydatatables').dataTable().fnSetColumnVis(4, false,false);
			}

		});
		  function mark(id){
				if(window.confirm("你确定要标记为已咨询")){
					$.getJSON("${path }/reservation/rest/doDisposal.action?reservationid="+id,
								function(data){
							    alert(data.msg);
							if(data.status==1){
								mydatatables.ajax.reload();
							}
						});
				}	  
		  }
		function del(id){
			if(window.confirm("你确定要删除？")){
				$.getJSON("${path }/reservation/rest/doDelete.action?reservationid="+id,
							function(data){
						alert(data.msg);
						if(data.status==1){
							mydatatables.ajax.reload();
						}
					});
			}
		}
		function recordContent(obj){
			data = $('#mydatatables').DataTable().row($(obj).parent().parent()).data();
			$('.modal-title').text('填写客户咨询记录');
			$('.modal-body').html('<textarea rows="6" cols="50" class="textarea_adapt" placeholder="在此填写记录" id="textArea"> ' + (data.reservationresult||'') + '</textarea>')
			$('#submit').remove();
			$('.modal-footer').append('<button id="submit" onclick="saveRecord(data)" type="button" class="btn btn-primary" data-dismiss="modal">提交</button>')
		}
		function checkContent(obj){
			data = $('#mydatatables').DataTable().row($(obj).parent().parent()).data();
			$('.modal-title').text('客户咨询记录');
			$('.modal-body').html('<textarea rows="6" cols="50" class="textarea_adapt" placeholder="暂无咨询记录" id="textArea"> ' + (data.reservationresult||'') + '</textarea>')
			$('#submit').remove();			
		}
		function saveRecord(obj){
			 $.ajax({
				"url":"doEdit.action",
				"type":"POST",
				"data":{"reservationid":obj.reservationid,"reservationresult":$('#textArea').val()},
				"dataType":"json",
				"success":function(data){
					alert("操作成功");
				
				}
			}); 
			mydatatables.ajax.reload();
		}
		function checkPartner(id){
			$('.modal-title').text('查看上家');
			$(".modal-body>span").text("无上级信息").show();
			$(".modal-body>div").hide();
			$("#u_up").html('<div style="margin: 1vw 0">(空)</div>');
			$("#up").html('<div style="margin: 1vw 0">(空)</div>');
			 $.ajax({
				"url":"${path}/wxuser/rest/getSuperAndSuper.action",
				"type":"POST",
				"data":{"id":id},
				"dataType":"json",
				"success":function(data){
					var data0 = data[0];
					var data1 = data[1];
					if(data0!=null){
						var html = '<div class="col-sm-4 col-md-4 col-xs-4" style="margin:1vw 0;text-align:center">'+(ata0.username||"(空)")+'</div>'+'<div class="col-sm-8 col-md-8 col-xs-8" style="margin:1vw 0;text-align:center">'+(data0.userphone||"(空)")+'</div>';
						$("#u_up").html(html);
					}
					if(data1!=null){
						var html = '<div class="col-sm-4 col-md-4 col-xs-4" style="margin:1vw 0;text-align:center">'+(data1.username||"(空)")+'</div>'+'<div class="col-sm-8 col-md-8 col-xs-8" style="margin:1vw 0;text-align:center">'+(data1.userphone||"(空)")+'</div>';
						$("#up").html(html);
					}
					if(data0!=null||data1!=null){
						$(".modal-body>span").hide();
						$(".modal-body>div").show();
					}
				},
				 "error":function(data){
				 }
			}); 
		}
	</script>
</body>
</html>
