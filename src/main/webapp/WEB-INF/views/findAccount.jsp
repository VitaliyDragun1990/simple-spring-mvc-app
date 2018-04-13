<%@include file="header.jsp" %>

<div class="container">
    <%-- HEADER SECTION --%>
    <div class="row">
        <div class="col-12">
            <p class="h1">Search Form</p>
            <p><a href="<spring:url value="/"/>" class="btn btn-sm btn-default">Back to Index Page</a></p>
        </div>
    </div>

    <%-- SERACH FORM SECTION --%>
    <div class="row">
        <div class="col-8">
            <form:form cssClass="form-horizontal" role="form" id="accForm">
                <div class="form-group row">
                    <Label for="accountNum" class="col-2 col-form-label">Account
                        No:</Label>
                    <div class="col-8">
                        <input type="text" class="form-control"
                               placeholder="Enter Account No" name="accountNo" id="accountNum"/>
                    </div>
                    <div class="col-2">
                        <button type="submit" id="bth-search" class="btn btn-primary">
                            Search
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

    <%-- SEARCH RESULTS SECTION --%>
    <div class="row" id="divResults">
        <div class="col-8">
            <div class="card">
                <div class="card-header bg-success text-white">
                    <h3>Search Results</h3>
                </div>
                <div class="card-body">
                    <div id="accountNo"></div>
                    <div id="accountHolderName"></div>
                    <div id="accountType"></div>
                    <div id="balance"></div>
                    <div id="psCode"></div>

                </div>
            </div>
        </div>
    </div>

        <%-- ERROR SECTION --%>
    <div class="row" id="divError">
        <div class="col-8">
            <p class="alert alert-danger">Requested Account Holder Details
                Not Found</p>
        </div>
    </div>
</div>

<%-- CUSTOM SCRIPT SECTION --%>
<script>
    var ctx = "${pageContext.request.contextPath}";
    // document 'ready' event handler
    $(document).ready(function ($) {
        // Initially hide result and error sections
        $('#divResults').hide();
        $('#divError').hide();

        // Form 'submit' event handler
        $('#accForm').submit(function (event) {
            enableSearchButton(false);
            event.preventDefault();
            searchViaAjax();
        });
    });

    /*** Event handler functions ***/
    // toggle 'search' button
    function enableSearchButton(flag) {
        $('#bth-search').prop('disabled', flag);
    }

    // Perform Ajax call
    function searchViaAjax() {
        var account = {};
        account['accountNo'] = $("#accountNum").val();
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: ctx + "account",
            data: JSON.stringify(account),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                display(data);
            },
            error: function (e) {
                $('#divResults').hide();
                $('#divError').show();
            },
            done: function (e) {
                enableSearchButton(true);
            }
        });
    }

    // show result data
    function display(data) {
        $('#accountNo').html("Account Number: " + data['accountNo']);
        $("#accountHolderName").html('Holder name:' + data['accountHolderName']);
        $('#balance').html('Balance: ' + data['balance']);
        $('#accountType').html('Account Type: ' + data['accountType']);
        $('#psCode').html('Security Code: ' + data['psCode']);
        $('#divError').hide();
        $('#divResults').show();
    }
</script>

<%@include file="footer.jsp" %>