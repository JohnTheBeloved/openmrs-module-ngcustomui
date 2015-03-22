<%@ include file="/WEB-INF/template/include.jsp" %>
 
<%@ include file="/WEB-INF/template/header.jsp" %>

<form method="post" action="addFavoritePatient.form">
    Add a patient by primary key: <input type="text" name="patient_id"/>
    <input type="submit" value="Add"/>
</form>
<br>/
or
</br>
<form method="post" action="addFavoritePatient.form">
    Add a patient <openmrs:fieldGen formFieldName="patient_id" type="org.openmrs.Patient"/>
    <input type="submit" value="Add"/>
</form>

 
<h1>My ${fn:length(favorites)} favorite patient(s) (for ${me.username})</h1>
 
<ul>
    <c:forEach var="p" items="${favorites}">
        <li>
            ${p.personName}
            <c:choose>
                <c:when test="${p.gender == 'F'}">
                    Female
                </c:when>
                <c:otherwise>
                    Male
                </c:otherwise>
            </c:choose>
        </li>
    </c:forEach>
</ul>
 
<%@ include file="/WEB-INF/template/footer.jsp" %>