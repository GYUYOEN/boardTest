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

            <!-- 검색 조건 -->
            <div style="width: 70%; margin:0 auto;">
                <nav class="navbar bg-body-tertiary">
                    <div class="container-fluid">
                        <a class="navbar-brand">Navbar</a>
                        <button class="btn btn-outline-success" type="button" onclick="location.href='../board/list.do'">전체조회</button>
                        <!-- 검색 조건 search, type, pageNum, amount form을 이용해 /board/list.do url로 파리미터로 넘기기 -->
                        <form id="actionForm" action="../board/list.do" method="post" class="d-flex" role="search">
                            <select id="searchType" name="type" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                <option value="select" selected="selected">==선택==</option>
                                <option value="searchtitle" ${search.getType() == "searchtitle" ? 'selected="selected"' : ''}>제목만</option>
                                <option value="searchcontent" ${search.getType() == "searchcontent" ? 'selected="selected"' : ''}>게시글 내용</option>
                                <option value="searchwriter" ${search.getType() == "searchwriter" ? 'selected="selected"' : ''}>글작성자</option>
                            </select>
                            <input class="form-control me-2" id="search" type="search" name="search" value="${search.getSearch()}" placeholder="Search" aria-label="Search">
                            <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
                            <input type="hidden" name="amount" value="${pageMaker.cri.amount}">
                            <button class="btn btn-outline-success" type="button" onclick="fn_searchList()">Search</button>
                        </form>
                    </div>
                </nav>

                <!-- 검색 조건 조회 -->
                <table class="table table-hover">
                    <colgroup>
                        <col width="5%" />
                        <col width="5%" />
                        <col width="10%" />
                        <col width="30%" />
                        <col/>
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">제목</th>
                            <th scope="col">작성자</th>
                            <th scope="col">작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${list != null}">
                            <c:forEach var="list" items="${list}">
                                <tr>
                                    <td>${list.bno}</td>
                                    <td>
                                        <a href="../board/one.do?bno=${list.bno}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}&search=${search.getSearch()}&type=${search.getType()}">
                                                ${list.title}
                                        </a>
                                    </td>
                                    <td>${list.writer}</td>
                                    <td>${list.regdate}</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td>지료가 없습니다.</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>

                <div style="float:right;">
                    <button class="btn btn-secondary" type="button" onclick="location.href='../board/write.do'">글쓰기</button>
                </div>

                <!-- 페이징 -->
                <div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <c:if test="${pageMaker.prev}">
                                <li class="page-item">
                                    <a href="${pageMaker.startPage-1}" class="page-link">Previous</a>
                                </li>
                            </c:if>

                            <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                                <li class="page-item ${pageMaker.cri.pageNum == num ? "active":""} ">
                                    <a href="${num}" class="page-link" href="#">${num}</a>
                                </li>
                            </c:forEach>

                            <c:if test="${pageMaker.next}">
                                <li class="page-item">
                                    <a href="${pageMaker.endPage+1}" class="page-link">Next</a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>

            </div>
        </div>

        <script type="text/javascript">
            if ("${msg}" == "success")
                alert("게시글이 등록되었습니다.");

            $(document).ready(function () {
                var actionForm = $("#actionForm");

                $(".page-item a").on("click", function (e) {
                    e.preventDefault();

                    console.log("click");

                    actionForm.find("input[name='pageNum']").val($(this).attr("href"));
                    actionForm.submit();
                })
            })

            function fn_searchList() {
                var searchType = $("#searchType").val();
                var search = $("#search").val();

                if(searchType == "select") {
                    alert("검색어 타입을 설정해 주세요.")
                    return;
                } else if (search == "") {
                    alert("검색어를 입력해 주세요.")
                    return;
                }

                $("#actionForm").find("input[name='pageNum']").val(1);
                $("#actionForm").submit();
            }
        </script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</body>
</html>
