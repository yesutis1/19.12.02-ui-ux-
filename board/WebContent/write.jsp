<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link rel="stylesheet" href="./bootstrap/4.1.3/css/bootstrap.css">
</head>
<body>
<form action="insert.do" method="post" onsubmit="return formCheck();">
	카테고리 : <select name="category">
				   <option value="일반" selected="selected">일반</option>
				   <option value="공지사항">공지사항</option>
			   </select>
	<br />
    제목 : <input type="text" name="title"/><br />
	<input type="hidden" name="writer" value="3">
    <!-- 작성자: <input type="text" name="writer"/><br /> -->
    내용 : <textarea name="content" cols="30" rows="10"></textarea><br />
    <input type="submit" class="btn btn-outline-success"/>
</form>
<a class="btn btn-outline-primary" href="list.do">돌아가기</a>

<script>
    function formCheck() {
        var title, writer, regdate, content, myForm;
        myForm = document.forms[0];
        title = myForm.title.value;
        writer = myForm.writer.value;
        regdate = myForm.regdate.value;
        content = myForm.content.value;
        
        if(title == null || title == ""){
            alert("제목을 입력하세요");
            myForm.title.focus();
            return false;
        }
        if(writer == null || writer == ""){
            alert("제목을 입력하세요");
            myForm.writer.focus();
            return false;
        }
        if(regdate == null || regdate == ""){
            alert("제목을 입력하세요");
            myForm.regdate.focus();
            return false;
        }
        if(content == null || content == ""){
            alert("제목을 입력하세요");
            myForm.content.focus();
            return false;
        }
    }
</script>
</body>
</html>