<%@ include file = "/jspf/header.jspf" %>

<c:set var='view' value='/authorBooks' scope='session' />

<h2><fmt:message key='booksby' /> ${selectedAuthor.firstname} ${selectedAuthor.surname} </h2>

    <c:forEach var="book" items="${authorBooks}" varStatus="iter">
        <img src="${initParam.bookImagePath}${book.coverimage}.png"
             alt="No cover image found" width="250" height="300">
        <br><br>
        <h1><fmt:message key="${book.title}"/></h1>
        <h2><fmt:message key='pubyear' /> ${book.year}</h2>
    </c:forEach>

<%@ include file = "/jspf/footer.jspf" %>