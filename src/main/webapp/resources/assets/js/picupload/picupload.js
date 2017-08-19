var fileamount =0; 

$(function() {
     //遍历图片输出域
     $(".input-image").each(function(){
         var height = $(this).height();
         var width = $(this).width();
         var sizes = new Array();
         $(this).nextAll("img").each(function() {
              var sizeObj = {w:$(this).width(), h:$(this).height(), img:$(this)};
              sizes.push(sizeObj);
         });
          
         //初始化图片预览区域
         $.initFilePreview($(this), sizes, width, height);
    });
 })
// form upload image
jQuery.extend({
     initFilePreview:function(inputImgObj, sizes, width, height) {
        var fieldName = inputImgObj.attr("name");
        var appendToObj = inputImgObj.parent("td");
        var html ="<div class='file-preview' style='height: "+height+"px;width: "+width+"px;'>"
            html+= "<div class='file-drop-zone'>";
            html+=     "<div class='file-preview-thumbnails file-preview-hbs' style='height:100%;width:"+(width - 20)+"px;'>";
            html+=     "</div>";
            html+= "</div>";
            html+= "<div class='fileinput-upload-button' style='width:100%;text-align:center;display:table;margin-top:3px;'>";
            html+=     "<button class='btn btn-success btn-squared fileinput-button' style='background-color: #337ab7;border-color: #2e6da4;' type='button' onclick=\"$.uploadImages(this, '"+fieldName+"')\">上传</button>";
            html+=     "<span class='btn btn-success btn-squared fileinput-button' style='background-color: #337ab7;border-color: #2e6da4;'>";
            html+=         "<span >选择图片</span>";
            html+=         "<input type='file' name='file_"+fieldName+"' onchange='$.selectedUploadImage(this, event)'>";
            html+=     "</span>";
            html+= "</div>";
            html+="</div>";
            appendToObj.append(html);
            $.initImagePreviewFrame(fieldName, sizes);
     },
     initImagePreviewFrame:function(inputName, sizes) {
        var inputObj = $("input[type=hidden][name="+inputName+"]");
        var imagePaths = inputObj.val();
        if(imagePaths != "") {
           var previewFrameDiv = inputObj.parent("td").find("div.file-preview-thumbnails");
           var frameHeight = previewFrameDiv.height();
            
           var height = Math.max(50, frameHeight-65);
           if(!previewFrameDiv) {
              return;
           }
           var imageArray = imagePaths.split(",");
           var timeId = new Date().getTime(); 
           for(var i = 0; i < imageArray.length; i++) {
              var sizeObj = sizes[i];
              var sizeH = sizeObj.h;
              var sizeW = sizeObj.w;
              var width = (height/sizeH) * sizeW;
              previewFrameDiv.append($.createFilePreviewFrame(inputName, timeId + i, height, width));
              imageObj = sizeObj.img;
              var cloneImg = imageObj.clone()
              cloneImg.width(width);
              cloneImg.height(height);
              cloneImg.show();
              imageObj.remove();
              $("#imagePreview-" + (timeId + i)).append(cloneImg);
              $("#preview-" + (timeId + i)).attr("filePath", imageArray[i]);
           }
        }
     },
 
     createFilePreviewFrame:function(fieldName, id, height, width) {
         var html = "<div class='file-preview-frame' id='preview-" + id + "'>";
             html+= "<div id='imagePreview-"+ id +"' style='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod = scale); width:"+width+"px; height: "+height+"px;'>";
             html+= "</div>";
             html+= "<div class='file-thumbnail-footer'>";
             html+=    "<div class='file-actions'>";
             html+=      "<div class='file-footer-buttons'>";
             html+=        "<button type='button' class='kv-file-remove btn btn-xs btn-default' title='删除文件' onclick=\"$.deleteFilePreviewFrame("+id+", '"+fieldName+"')\">";
             html+=          "<i class='fa fa-trash-o red icon-size-14'></i>";
             html+=        "</button>";
             html+=      "</div>";
             html+=    "</div>";
             html+=  "</div>";
             html+= "</div>";
         return html;
     },
     createFileinputButton:function(fieldName) {
         var html = "<span class='btn btn-success btn-squared fileinput-button' style='background-color: #337ab7;border-color: #2e6da4;'>";
             html+=    "<span>选择图片</span>";
             html+=    "<input type='file' name='file_"+fieldName+"' onchange='$.selectedUploadImage(this, event)'>";
             html+= "</span>";
         return html;
     },
     deleteFilePreviewFrame:function(id, fieldName) {
          
         var preview = $("#preview-" + id);
         var filePath = preview.attr("filePath");
 
           
          var previewFrameDiv = preview.parent(".file-preview-thumbnails");
           
          //delete preview image
          preview.remove();
          //delete file upload button
          $("#file-" + id).parent("span").remove();
          $.deleteImage(previewFrameDiv, fieldName);
     },
     selectedUploadImage:function(obj, e) {
         var timeId = new Date().getTime();
 
         var fileObj = $(obj);       
         fileObj.attr("id", "file-" + timeId);
          
         var fileName = fileObj.attr("name");
         var fieldName = fileName.substring("file_".length, fileName.length);
 
           var btnDiv = fileObj.closest(".fileinput-upload-button");
           btnDiv.append($.createFileinputButton(fieldName));
 
         var previewFrameDiv = fileObj.closest(".fileinput-upload-button").prev().find(".file-preview-thumbnails");
         var frameHeight = previewFrameDiv.height() - 35;
         var frameWidth = previewFrameDiv.width() - 20;
          
         var height = Math.max(50, frameHeight);
         var width = Math.max(50, frameWidth)/2;
         previewFrameDiv.append($.createFilePreviewFrame(fieldName, timeId, height, width));
 
         $.displayPreviewImage(timeId, e, height, width);
         //hide current file button
         fileObj.parent("span").hide();
     },
     displayPreviewImage:function(id, e, height, width) {
         if(!$.support.leadingWhitespace){
               var obj = document.getElementById("file-" + id);
               obj.select();
               var path = document.selection.createRange().text;
 
               var sizes = $.getIePreviewImageSize(id, path);
               var hPercent = height/sizes[1];
               var width = hPercent * sizes[0];
 
               var picpreview=document.getElementById("imagePreview-" + id);
               try{
                    picpreview.style.width = width;
                    picpreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = path;
               } catch (ex){
                    alert("file path error!");
                    return false;
               }
           } else {
              var file = e.target.files[0];
              loadImage(
                file,
                function(img) {
                    $("#imagePreview-" + id).prepend(img);
                },
                {maxWidth: width, maxHeight:height}
            );
          }
     },
     getIePreviewImageSize:function(id, path) {
           var picpreview=document.getElementById("imagePreview-" + id);
           var tempDiv=document.createElement("div");  
           picpreview.appendChild(tempDiv);  
           tempDiv.style.width="10px";  
           tempDiv.style.height="10px";  
           tempDiv.style.diplay="none";  
           tempDiv.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);";  
           tempDiv.id="previewTemp";  
           tempDiv.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src=path;  
           var width=tempDiv.offsetWidth;  
           var height=tempDiv.offsetHeight;  
           picpreview.removeChild(tempDiv);
 
           var sizes = new Array();
           sizes.push(width);
           sizes.push(height);
 
           return sizes;
     },
     uploadImages:function(obj, fileName) {
          var flag = false;
          $("input[type='file'][name='file_"+fileName+"']").each(function(){
              var fileName = $(this).val();
              if(fileName != "" && (fileName.endWith(".png") || fileName.endWith(".PNG") ||
              fileName.endWith(".jpg") || fileName.endWith(".JPG") || fileName.endWith(".jpeg") || fileName.endWith(".JPEG")
              || fileName.endWith(".bmp") || fileName.endWith(".BMP") || fileName.endWith(".gif") || fileName.endWith(".GIF"))) {
                 flag = true;
              }
          });
           
          if(!flag) {
              layer.alert('请选择图片上传!', {icon: 0});
              return false;
          }
           
          var fileObj = $(obj).closest(".fileinput-upload-button").prev();
          var previewFrameDiv = fileObj.find(".file-preview-thumbnails");
          var hiddenInput = $("input[type=hidden][name="+fileName+"]");
           
          var loadIdx = layer.load();
           /**
            * 图片上传地址
            */
          $.ajaxFileUpload({
              url:form.uploadUrl,
              secureuri:false,
              fileElementName:"file_" + fileName,
              dataType: 'json',
              success: function(data, status){
                 layer.close(loadIdx);
                 if(data.code == 411) {
                     layer.alert('图片最大不能超过' + data.error, {icon: 0});
                     return false;
                 }
                  
                 var imageData = data.value;
                 layer.msg('图片上传成功', {time: 1000, shadeClose:true});
                 var filePaths = "";
                 var index = 0;
                 previewFrameDiv.find(".file-preview-frame").each(function(){
                     if(!$(this).attr("filePath") && index < imageData.length) {
                        $(this).attr("filePath", imageData[index]);
                        index ++;
                     }
                      
                     filePaths += $(this).attr("filePath");
                     filePaths += ",";
                 });
                  
                 if(filePaths.length > 1) {
                    filePaths = filePaths.substring(0, filePaths.length - 1);
                 }
                  
                 hiddenInput.val(filePaths);
              }, error: function (data, status, e) {
                 layer.close(loadIdx);
                 layer.alert('上传失败!', {icon: 0});
              }
          });
           
          return false;
     },
     deleteImage:function(previewFrameDiv, fileName) {
           var hiddenInput = $("input[type=hidden][name="+fileName+"]");
           var filePaths = "";
           previewFrameDiv.find(".file-preview-frame").each(function(){
                 if($(this).attr("filePath")) {
                     filePaths += $(this).attr("filePath");
                     filePaths += ",";
                 }
           });

           if(filePaths.length > 1) {
                filePaths = filePaths.substring(0, filePaths.length - 1);
           }
           hiddenInput.val(filePaths);
     }
});