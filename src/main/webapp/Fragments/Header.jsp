  <%-- taglibs s de spring security --%>
 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/Header.css">



<div class="containerTop">
        <img id="imageTopBrand" src="${pageContext.request.contextPath}/assets/images/LogoCerveau.jpg">
        <h1 id="TitreApp">SuperSchool</h1>

        <a href="?lang=fr"><img id="drapeauFrance" src="${pageContext.request.contextPath}/assets/images/FlagFrance.png" ></a>
        <a href="?lang=en"><img id="drapeauUK" src="${pageContext.request.contextPath}/assets/images/FlagUK.png" ></a>
        
    </div>

    <div id="separation">
        <img id="userLogo" src="${pageContext.request.contextPath}/assets/images/User.png" >
        <p id="userInfos">{sessionScope.(attribut a definir).nom} - Admin</p>
        <a href="${pageContext.request.contextPath}/aide/liste"><img id="AideImage" src="${pageContext.request.contextPath}/assets/images/Aide.png" ></a>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">


        <div class="container d-flex flex-column flex-md-row justify-content-between">
            <a class="py-2" href="${pageContext.request.contextPath}/index.jsp" aria-label="Product">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor"
                    stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img"
                    viewBox="0 0 24 24" focusable="false">
                    <circle cx="12" cy="12" r="10" />
                    <path
                        d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" />
                </svg>
            </a>
                <a class="nav-link " href="${pageContext.request.contextPath}/etudiant/liste" id="navbarDropdown">
                    Etudiant
                </a>
                



                <a class="nav-link " href="${pageContext.request.contextPath}/enseignants/liste" id="navbarDropdown">
                    Enseignant
                </a>

                <a class="nav-link " href="${pageContext.request.contextPath}/promotion/liste" id="navbarDropdown">
                    Promotion
                </a>

                <a class="nav-link " href="${pageContext.request.contextPath}/matiere/liste" id="navbarDropdown">

                    Matières
                </a>
                
                <a class="nav-link " href="${pageContext.request.contextPath}/cours/liste" id="navbarDropdown">
                    Cours
                </a>
                
                <nav class="navbar navbar-expand-lg navbar-light bg-light">

        <sec:authorize
            access="hasAnyRole('ROLE_Etudiant', 'ROLE_Enseignant', 'ROLE_Admin')">
            <%-- déja connecté => bouton se déconnecter --%>
            <a href="${pageContext.request.contextPath}/logout"
                class="btn btn-secondary nav-link" style="width: auto;">Se
                Déconnecter</a>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
            <%-- n'est connecté => bouton se connecter --%>
            <a href="${pageContext.request.contextPath}/login.jsp"
                class="btn btn-secondary nav-link" style="width: auto;">Se
                Connecter</a>
        </sec:authorize>
<!--  =================================  -->
        <c:if test="${not empty param.logout_message}">
            <font style="color: green; font-style: italic;"> Vous êtes
                déconnecté !!! </font>
        </c:if>

    </nav>


            
        </div>
    </nav>