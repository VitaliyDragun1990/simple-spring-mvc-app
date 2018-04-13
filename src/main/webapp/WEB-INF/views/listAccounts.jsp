<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-12">
            <c:url value="/logout" var="logoutUrl" />

            <%-- Logout form --%>
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>

            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <p class="display-5">
                Welcome : <security:authentication property="principal.username"/> ,
                <a href="javascript:formSubmit()" class="btn btn-primary btn-sm">Logout</a>
                <a href="<spring:url value="/find"/>" class="btn btn-success btn-sm">Find account</a>
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <a class="btn btn-lg btn-primary" href="<spring:url value="/new"/>">Add New Account</a>
        </div>
    </div>
<table class="table table-bordered table-hover">
    <thead class="bg-success">
    <tr>
        <th><spring:message code="lbl.accountNo" /></th>
        <th><spring:message code="lbl.accountHolderName" /></th>
        <th><spring:message code="lbl.balance" /></th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="account" items="${accounts}">
        <c:url var="updateLink" value="/edit">
            <c:param name="accountNo" value="${account.accountNo}" />
        </c:url>
        <c:url var="deleteLink" value="/delete">
            <c:param name="accountNo" value="${account.accountNo}" />
        </c:url>
        <tr>
            <td>${account.accountNo}</td>
            <td>${account.accountHolderName}</td>
            <td>${account.balance}</td>
            <td><a class="btn btn-primary btn-block" href="${updateLink}">Edit</a></td>
            <td>
                <a class="btn btn-danger btn-block" href="${deleteLink}" onclick="if (!(confirm('Are you sure to delete ?'))) return false;">
                    Delete
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<hr>
<a class="btn btn-default" href="<spring:url value="/"/>">Back to Index Page</a>
<%@include file="footer.jsp" %>