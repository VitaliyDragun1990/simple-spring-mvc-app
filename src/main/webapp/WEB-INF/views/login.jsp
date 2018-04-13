<%@include file="header.jsp"%>

<div class="container">
    <div class="col-6 offset-3 align-self-center">
        <div class="card">
            <div class="card-header bg-info text-white">
                Existing Users:: Login Here
            </div>

            <div class="card-body">
                <form  method="post" role="form" action="<c:url value='/login' />">
                    <div class="form-group">
                        <label for="username">User name :</label>
                        <input type="text"  class="form-control" id="username"
                               placeholder="Enter Username" name="username" />
                    </div>

                    <div class="form-group">
                        <label for="password">Password :</label>
                        <input type="password" class="form-control" id="password"
                               placeholder="Password" name="password" />
                    </div>

                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />

                    <input type="submit" value="Login" name="submit"
                           class="btn btn-primary" />
                </form>

                <div class="row">
                    <div class="col-12">
                        <c:if test="${not empty error}">
                            <p class="alert-danger">${error}</p>
                        </c:if>
                        <c:if test="${not empty msg}">
                            <p class="alert-warning">${msg}</p>
                        </c:if>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>