<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>파일</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<div>
    <div style="width: 70%; margin:0 auto;">
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link active" href="../board/list.do">게시판</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../file/upload.do">파일 업로드</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../file/download.do">파일 다운로드</a>
            </li>
        </ul>
    </div>

    <form style="width: 30%; margin:0 auto;" action="../file/download.do" method="post" enctype="multipart/form-data">
        file: ${fileObj.fileName}<br/>

        <input type="hidden" name="fileName" value="${fileObj.fileName}">
        <button class="btn btn-secondary" type="submit">다운로드</button>
    </form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</body>
</html>
