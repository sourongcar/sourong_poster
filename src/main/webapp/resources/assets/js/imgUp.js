$(function(){
	var delParent;
	var limit=1;
	var defaults = {
		fileType         : ["jpg","png","bmp","jpeg"],   // 上传文件的类型
		fileSize         : 1024 * 512                 // 上传文件的大小 10M
	};
		/*点击图片的文本框*/
	$(".file").change(function(){
		var self=$(this);
		var file = self[0];
		var imgContainer = self.parents(".z_photo"); //存放图片的父亲元素
		var fileList = file.files; //获取的图片文件

		var input = self.parent();//文本框的父亲元素
		var imgArr = [];
		//遍历得到的图片文件
		var numUp = imgContainer.find(".up-section").length;
		var totalNum = numUp + fileList.length;  //总的数量
		if(fileList.length>1){
			alert("一次只能上传1个图片，只上传第一个");
		}else if(totalNum > limit ){
			alert("上传图片数目不可以超过"+limit+"个，请重新选择");  //一次选择上传超过8个 或者是已经上传和这次上传的到的总数也不可以超过5个
		}
		else if(fileList.length==1){
			fileList = validateUp(fileList);
			if(fileList.length<=0)
				return;
			var imgUrl = window.URL.createObjectURL(fileList[0]);
			    imgArr.push(imgUrl);
			var $section = $("<section class='up-section fl loading'>");
			     imgContainer.prepend($section);
			var $span = $("<span class='up-span'>");
			     $span.appendTo($section);
			
		     var $img0 = $("<button type='button' class='close-upimg'></button>").on("click",function(event){
				    event.preventDefault();
					event.stopPropagation();
					$(".works-mask").show();
					delParent = $(this).parent();
				}).appendTo($section);
		     var $img = $("<img class='up-img up-opcity'>");
		         $img.attr("src",imgArr[0]);
		         $img.appendTo($section);
		     self.removeClass('file').unbind('change').appendTo($section);
		     var newfileinput=$('<input type="file" name="file" class="file" accept="image/jpg,image/jpeg,image/png,image/bmp">').change(arguments.callee).appendTo(input);
			 numUp = imgContainer.find(".up-section").length;
			 if(numUp >= limit){
				 newfileinput.parent().hide();
			 }
		}
		setTimeout(function(){
             $(".up-section").removeClass("loading");
		 	 $(".up-img").removeClass("up-opcity");
		 },450);
		
		
	});
	
	
   
    $(".z_photo").delegate(".close-upimg","click",function(){
     	  $(".works-mask").show();
     	  delParent = $(this).parent();
	});
		
	$(".wsdel-ok").click(function(){
		$(".works-mask").hide();
		var numUp = delParent.siblings('.up-section').length;
		if(numUp < limit){
			delParent.parent().find(".z_file").show();
		}
		 delParent.remove();
		
	});
	
	$(".wsdel-no").click(function(){
		$(".works-mask").hide();
	});
		
		function validateUp(files){
			var arrFiles = [];//替换的文件数组
			for(var i = 0, file; file = files[i]; i++){
				//获取文件上传的后缀名
				var newStr = file.name.split("").reverse().join("");
				if(newStr.split(".")[0] != null){
						var type = newStr.split(".")[0].split("").reverse().join("");
			
						if(jQuery.inArray(type, defaults.fileType) > -1){
							// 类型符合，可以上传
							if (file.size >= defaults.fileSize) {
								alert('您这个"'+ file.name +'"文件大小超过512k');	
							} else {
								// 在这里需要判断当前所有文件中
								arrFiles.push(file);	
							}
						}else{
							alert('您这个"'+ file.name +'"上传类型不符合');	
						}
					}else{
						alert('您这个"'+ file.name +'"没有类型, 无法识别');	
					}
			}
			return arrFiles;
		}
		
	
})
