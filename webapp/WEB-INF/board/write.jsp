<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="<c:url value='/resources/js/jquery-1.7.2.js'/>"></script>
</head>
<body>
    <form id="actionForm" action="../board/writepost.do" method="post" enctype="multipart/form-data">
        <div style="width: 50%; margin: 50px auto;">
            <div class="input-group" style="margin: 10px;">
                <span class="input-group-text">제목</span>
                <input class="form-control" type="text" name="title" value=""/>
            </div>

            <div class="input-group" style="margin: 10px; width: 30%;">
                <span class="input-group-text">작성자</span>
                <input class="form-control" type="text" name="writer" id="boarWriter" value=""/>
            </div>

            <div style="margin: 10px; margin-top: 20px;">
                <label for="boardContent">내용</label>
                <textarea class="form-control" name="content" id="boardContent" style="height: 200px;"></textarea>
            </div>

            <div style="margin: 10px;" class="mb-3">
                <label for="formFileMultiple" class="form-label">파일 업로드</label>
                <input class="form-control" type="file" name="mpfile" id="formFileMultiple" multiple/>
            </div>

            <div style="margin: 10px; float: right;">
                <button type="button" class="btn btn-secondary" onclick="fn_boardcreate();">등록</button>
            </div>
        </div>
    </form>

    <script type="text/javascript">
        function fn_boardcreate() {
            if(confirm("게시글을 등록하시겠습니까?")) {
                $("form").submit();
            } else {
                return;
            }
        }
    </script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</body>
</html>
