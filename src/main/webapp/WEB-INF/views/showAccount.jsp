<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><spring:message code="lbl.title" /></title>
</head>
<body>
<h2>PS: Bank Account Details</h2>

<p><spring:message code="lbl.accountNo" />: ${account.accountNo} </p>
<p><spring:message code="lbl.accountHolderName" />: ${account.accountHolderName} </p>
<p><spring:message code="lbl.balance" />: ${account.balance} </p>
<p><spring:message code="lbl.accountType" />: ${account.accountType} </p>
<p><spring:message code="lbl.dob" />: ${account.dateOfBirth} </p>
<p><spring:message code="lbl.pscode" />: ${account.psCode} </p>
<br><br>
<a href="<spring:url value="/"/>">Back to Index Page</a>
</body>
</html>