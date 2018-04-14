<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="jumbotron">
                <h1 class="display-4">Welcome to Bank App</h1>
                <p class="lead">
                    Happiness = A Good Bank Account, A Good Cook and a Good Digestion - Jean
                </p>
                <security:authorize access="isAnonymous()">
                    <a class="btn btn-lg btn-success" href="<spring:url value="/user/new"/>">Register Here</a>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <c:url value="/logout" var="logoutUrl"/>
                    <%-- Logout form --%>
                    <form action="${logoutUrl}" method="post" id="logoutForm">
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>
                    </form>
                    <script>
                        function formSubmit() {
                            document.getElementById("logoutForm").submit();
                        }
                    </script>
                    <p><br><a href="javascript:formSubmit()" class="btn btn-primary btn-sm">Logout</a>
                    </p>
                </security:authorize>
                <security:authorize access="isAnonymous()">
                    <p><br>Existing Users : <a href="<spring:url value="/user/login"/>">
                        Login Here
                    </a>
                    </p>
                </security:authorize>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="card" style="height: 200px">
                <div class="card-header">Online</div>
                <img src="<spring:url value='/resources/images/stay-online.png' />"
                     class="card-img-top" alt="Online">
                <div class="card-body">
                    <p class="card-text">200+ Transactions via NetBanking</p>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="card" style="height: 200px">
                <div class="card-header">Phone</div>
                <img src="<spring:url value='/resources/images/stay-phone.png' />"
                     class="card-img-top" alt="phone"/>
                <div class="card-body">
                    <p class="card-text">75+ Transactions on your smartphone</p>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="card" style="height: 200px">
                <div class="card-header">Social Media</div>
                <img src="<spring:url value='/resources/images/stay-social.png' />"
                     class="card-img-top" alt="Social"/>
                <div class="card-body">
                    <p class="card-text">Social Media- Chatting, Sharing + Banking</p>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="card" style="height: 200px">
                <div class="card-header">Watch</div>
                <img src="<spring:url value='/resources/images/stay-watch.png' />"
                     class="card-img-top" alt="watch"/>
                <div class="card-body">
                    <p class="card-text">Banking at the flick of a wrist now</p>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>