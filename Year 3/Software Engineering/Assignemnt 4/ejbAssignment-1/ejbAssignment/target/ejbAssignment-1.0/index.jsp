<%@ include file = "/jspf/header.jspf" %>

<c:set var='view' value='/index' scope='session' />

<%-- HTML markup starts below --%>


    <div id="welcomeText">
        <p style="font-size: larger"><fmt:message key='greeting'/></p>
        <p><fmt:message key='listofauthors' /></p>
    </div>


    <c:forEach var="author" items="${authors}">
        <div >
            <a href="<c:url value='author?${author.authorid}'/>">${author.firstname} ${author.surname} </a>
            <br>
            <b><fmt:message key='nationality' />: </b> ${author.nationality} <br>
            <b><fmt:message key='yob' />: </b>${author.yob}<br>
            ${author.biography}<br><br>
        </div>
    </c:forEach>

<%@ include file = "/jspf/footer.jspf" %>