<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>

window.onload=function(){
	MemberPictureThumb($('#pictureView')[0],'${member.picture}','<%=request.getContextPath()%>');
}  	

function changePicture_go(){

var picture = $('input#inputFile')[0];

var fileFormat=picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();

//이미지 확장자 jpg 확인   
if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
   alert("이미지는 jpg/jpeg 형식만 가능합니다.");
   return;
} 

//미리보기
//업로드 확인변수 초기화 (사진변경)

document.getElementById('inputFileName').value=picture.files[0].name;

if (picture.files && picture.files[0]) {
      var reader = new FileReader();
       reader.onload = function (e) {
          //이미지 미리보기
           $('div#pictureView')
              .css({'background-image':'url('+e.target.result+')',
                 'background-position':'center',
                 'background-size':'cover',
                 'background-repeat':'no-repeat'
                 });
        }
      reader.readAsDataURL(picture.files[0]);
      
   }
//이미지 변경 확인
$('input[name="uploadPicture"]').val(picture.files[0].name);

}
function modify_go(){
	var form=$('form[role="form"]');
	form.submit();
	
	}

</script>