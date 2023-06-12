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
    <form action="../board/modifypost.do" method="post" enctype="multipart/form-data">
        <input type="hidden"  name="bno" value="${board.bno}"/>

        <div style="width: 50%; margin:50px auto;">
            <div style="margin: 10px;">
                <h5>게시판 번호 : ${board.bno}</h5>
            </div>

            <div class="input-group" style="margin: 10px;">
                <input class="form-control" type="text" name="title" value="${board.title}" />
            </div>

            <div class="input-group" style="margin: 10px; width: 30%;">
                <span class="input-group-text">작성자</span>
                <input class="form-control" type="text" name="writer" id="boarWriter" value="${board.writer}" readonly/>
            </div>

            <div class="input-group" style="margin: 10px; width: 40%; float: left;">
                <span class="input-group-text">생성일</span>
                <input class="form-control" type="text" name="regdate" id="boardRegdate" value="${board.regdate}" readonly/>
            </div>

            <div class="input-group" style="margin: 10px; width: 40%; float: right;">
                <span class="input-group-text">최초 수정일</span>
                <input class="form-control" type="text" name="moddate" id="boardModdate" value="${board.moddate}" readonly/>
            </div>

            <div style="margin: 10px; margin-top: 70px;">
                <label for="boardContent">내용</label>
                <textarea class="form-control" name="content" id="boardContent" style="height: 200px;">${board.content}</textarea>
            </div>

            <div style="margin: 10px;" class="mb-3">
                <label for="formFileMultiple" class="form-label">파일 업로드</label>
                <input class="form-control" type="file" name="mpfile" id="formFileMultiple" multiple>
            </div>

            <div style="margin: 10px; float: right;">
                <button type="button" class="btn btn-secondary" onclick="fn_boardmodify()">수정</button>
                <button type="button" class="btn btn-danger" onclick="location.href='../board/one.do?bno=${board.bno}'">취소</button>
            </div>
        </div>
    </form>

    <script type="text/javascript">
        function fn_boardmodify() {
            if(confirm("수정하시겠습니까?")) {
                $("form").submit();
            }
        }
    </script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</body>
</html>
