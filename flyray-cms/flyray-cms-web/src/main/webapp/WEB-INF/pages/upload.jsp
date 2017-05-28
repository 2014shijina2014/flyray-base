<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<script src=”http://libs.baidu.com/jquery/1.7.2/jquery.min.js”></script>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>  
    <h1>springMVC包装类上传文件</h1>
    <form name="userForm2" action="uploadToCloud.do" enctype="multipart/form-data" method="post"">  
        <div id="newUpload2">
            <input type="file" name="file">
        </div>
        <input type="submit" value="上传" >
    </form>   
</body>  
</html>  