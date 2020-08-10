<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/Header.css">

<div class="containerTop">
        <img id="imageTopBrand" src="${pageContext.request.contextPath}/assets/images/LogoCerveau.jpg">
        <h1 id="TitreApp">SuperSchool</h1>

        <a href=""><img id="drapeauFrance" src="${pageContext.request.contextPath}/assets/images/FlagFrance.png" ></a>
        <a href=""><img id="drapeauUK" src="${pageContext.request.contextPath}/assets/images/FlagUK.png" ></a>
        
    </div>

    <div id="separation">
        <img id="userLogo" src="${pageContext.request.contextPath}/assets/images/User.png" >
        <p id="userInfos">{sessionScope.(attribut a definir).nom} - Admin</p>
        <a href="#"><img id="AideImage" src="${pageContext.request.contextPath}/assets/images/Aide.png" ></a>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">


        <div class="container d-flex flex-column flex-md-row justify-content-between">
            <a class="py-2" href="${pageContext.request.contextPath}/index.jsp" aria-label="Product">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor"
                    stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img"
                    viewBox="0 0 24 24" focusable="false">
                    <title>Product</title>
                    <circle cx="12" cy="12" r="10" />
                    <path
                        d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" />
                </svg>
            </a>
                <a class="nav-link " href="${pageContext.request.contextPath}/etudiant/liste" id="navbarDropdown" 
                    >
                    Etudiant
                </a>
                


                <a class="nav-link " href="${pageContext.request.contextPath}/enseignants/liste" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Enseignant
                </a>

                <a class="nav-link " href="${pageContext.request.contextPath}/promotion/liste" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Promotion
                </a>

                <a class="nav-link " href="${pageContext.request.contextPath}/matiere/liste" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Mati�res
                </a>
                
                <a class="nav-link " href="${pageContext.request.contextPath}/cours/liste" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Cours
                </a>

                <a class="nav-link " href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Absences
                </a>
 
             <a class="nav-link " href="${pageContext.request.contextPath}/indexAide.jsp" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Aide
                </a>
            
        </div>
    </nav>