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
        <div style="width: 50%; margin:50px auto;">
            <div style="margin: 10px;">
                <h5>게시판 번호 : ${board.bno}</h5>
            </div>

            <div class="input-group" style="margin: 10px;">
                <h1>${board.title}</h1>
            </div>

            <div class="input-group" style="margin: 10px; width: 30%;">
                <span class="input-group-text">작성자</span>
                <input class="form-control" type="text" name="writer" id="boarWriter" value="${board.writer}" readonly />
            </div>

            <div class="input-group" style="margin: 10px; width: 40%; float: left;">
                <span class="input-group-text">생성일</span>
                <input class="form-control" type="text" name="regdate" id="boardRegdate" value="${board.regdate}" readonly />
            </div>

            <div class="input-group" style="margin: 10px; width: 40%; float: right;">
                <span class="input-group-text">최초 수정일</span>
                <input class="form-control" type="text" name="moddate" id="boardModdate" value="${board.moddate}" readonly />
            </div>

            <div style="margin: 10px; margin-top: 70px;">
                <label for="boardContent">내용</label>
                <textarea class="form-control" name="content" id="boardContent" style="height: 200px;" readonly>${board.content}</textarea>
            </div>

            <div style="margin: 10px;" class="mb-3">
                <form style="display: inline" action="../file/download.do" method="post" id="formFilePost">
                    <label class="form-label" style=" display: block">파일 업로드</label>
                    <input type="hidden"  name="bno" value="${board.bno}"/>
                    <input class="form-control" type="text" name="fileName" id="formFileMultiple" style="width: 89%; display: inline" value="${file.originalFileName}" readonly/>
                    <button class="btn btn-primary" style="width: 10%; display: inline" type="button" onclick="fn_filedown();">다운로드</button>
                </form>
            </div>

            <div style="margin: 10px; float: right;">
                <!-- search, type, pageNum, amount form을 이용해 /board/list.do url로 파리미터로 넘기기 => 파라미터를 유지해 주기 위함 -->
                <form style="display: inline" action="../board/list.do" method="post">
                    <input type="hidden"  name="pageNum" value="${cri.pageNum}"/>
                    <input type="hidden"  name="amount" value="${cri.amount}"/>
                    <input type="hidden"  name="search" value="${search.getSearch()}"/>
                    <input type="hidden"  name="type" value="${search.getType()}"/>
                    <button type="submit" class="btn btn-success">목록</button>
                </form>
                <button type="button" class="btn btn-secondary" onclick="location.href='../board/modify.do?bno=${board.bno}'">수정</button>
                <form style="display: inline" action="../board/remove.do" method="post">
                    <input type="hidden"  name="bno" value="${board.bno}"/>
                    <button type="button" class="btn btn-danger" onclick="fn_boardremove();">삭제</button>
                </form>
            </div>
        </div>

    <script type="text/javascript">
        if ("${msg}" == "success"){
            alert("수정되었습니다.");
        }

        function fn_boardremove() {
            if(confirm("정말로 삭제하시겠습니까?")) {
                $("form").submit();
            } else {
                return;
            }
        }

        function fn_filedown(e) {
            var file = $("#formFileMultiple").val();

            if(file != '') {
                $("#formFilePost").submit();
            } else {
                return;
            }
        }
    </script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</body>
</html>
