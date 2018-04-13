<%@include file="header.jsp" %>

<div class="container">

    <div class="row">
        <div class="col-12">
            <h2 class="page-header">Please Fill Up The Form Details</h2>
        </div>
    </div>

    <div class="row">
        <div class="col-6">
            <spring:url value="/saveAccount" var="formUrl"/>
            <form:form action="${formUrl}" modelAttribute="account" cssClass="form-horizontal" role="form">
                <div class="form-group row">
                    <label for="accountNo" class="col-6 col-form-label">Account No:</label>
                    <div class="col-6">
                        <form:input path="accountNo" cssClass="form-control" type="number"/>
                        <form:errors path="accountNo" cssClass="alert-danger" />
                        <text class="alert-danger">${message}</text>
                    </div>
                </div>
                <div class="form-group row">
                    <Label for="accountHolderName" class="col-6 col-form-label">Account
                        Holder Name:</Label>
                    <div class="col-6">
                        <form:input path="accountHolderName" cssClass="form-control" />
                        <form:errors path="accountHolderName" cssClass="alert-danger" />
                    </div>
                </div>

                <div class="form-group row">
                    <Label for="balance" class="col-6 col-form-label">Amount
                        Balance:</Label>
                    <div class="col-6">
                        <form:input path="balance" cssClass="form-control" />
                        <form:errors path="balance" cssClass="alert-danger" />
                    </div>
                </div>

                <div class="form-group row">
                    <Label for="accountType" class="col-6 col-form-label">Account
                        Type:</Label>
                    <div class="col-6">
                        <form:select path="accountType" cssClass="form-control">
                            <form:option value="">Select Account Type</form:option>
                            <form:option value="SAVINGS">Savings </form:option>
                            <form:option value="CURRENT">Current</form:option>
                        </form:select>
                        <form:errors path="accountType" cssClass="alert-danger" />
                    </div>
                </div>

                <div class="form-group row">
                    <Label for="dateOfBirth" class="col-6 col-form-label">Date of
                        Birth:</Label>
                    <div class="col-6">
                        <form:input path="dateOfBirth" cssClass="form-control" />
                        <form:errors path="dateOfBirth" cssClass="alert-danger" />
                    </div>
                </div>

                <div class="form-group row">
                    <Label for="psCode" class="col-6 col-form-label">PS
                        Security Code:</Label>
                    <div class="col-6">
                        <form:input path="psCode" cssClass="form-control" />
                        <form:errors path="psCode" cssClass="alert-danger" />
                    </div>
                </div>

                <div class="form-group row">
                    <div class="offset-6 col-6">
                        <input type="submit" value="Save Account" name="btnSubmit"
                               class="btn btn-primary" />
                    </div>
                </div>
            </form:form>
        </div>
    </div>

</div>

<%@include file="footer.jsp" %>