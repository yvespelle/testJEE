<%-- 
    Document   : tableauEmployes
    Created on : 3 nov. 2016, 11:13:04
    Author     : Jacques Augustin
--%>

<%@page import="java.util.ArrayList"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    </head>
    <body>

        <div class="container" >
            <div class="row col-md-6 col-md-offset-0 text-center">
                <form method="post" action="Controleur" name="suppression">
                    <table class="table table-dark ">
                        <thead>
                        <h1>Liste des employés</h1>
                        <tr class="text-center">
                            <th>Sél</th>
                            <th>NOM</th>
                            <th>PRENOM</th>
                            <th>TEL DOMICILE</th>
                            <th>TEL PORTABLE</th>
                            <th>TEL PRO</th>
                            <th>ADRESSE</th>
                            <th>CODE POSTAL</th>
                            <th>VILLE</th>
                            <th>EMAIL</th>
                        </tr>
                        </thead>
                        </tr>

                        <c:forEach items="${cleListeEmployes}" var="employe">
                            <tr>
                                <td><input type="radio" name="idEmploye" value=${employe.id}></td>
                                <td>${employe.nom}</td>
                                <td>${employe.prenom}</td>
                                <td>${employe.teldom}</td>
                                <td>${employe.telport}</td>
                                <td>${employe.telpro}</td>
                                <td>${employe.adresse}</td>
                                <td>${employe.codepostal}</td>
                                <td>${employe.ville}</td>
                                <td>${employe.email}</td>

                            </tr>
                        </c:forEach>

                    </table>




                    <c:if test="${!empty cleListeEmployes}">

                        <input type="submit" name="action" value="Supprimer" class="btn btn-primary"/>
                        <input type="submit" name="action" value="Details" class="btn btn-primary"/>
                    </c:if>

                    <c:if test="${empty cleListeEmployes}">
                        <font color="blue">L'entreprise doit recruter !</font>
                        <br>
                        <br>
                                    <button id="a" type="submit" name="action" value="Créer 5 Employés" class="btn btn-primary" onclick="function disableBtn()">Ajouter 5 employés</button>

                        </c:if>

                    <input type="submit" name="action" value="Ajouter" class="btn btn-primary"/>

                    <br/><font color="${couleur}"> ${message_ajouter}</font>
                    <br/><font color="${couleur}"> ${message_details}</font>
                    <br/><font color="${couleur_supp}"> ${message_supprimer}</font>

                </form>
            </div>
        </div>         
    </body>
    <script type="text/javascript">
        var btn = document.getElementById('a');

        btn.addEventListener('click', disableBtn);

        function disableBtn() {
            window.setTimeout(function () { btn.disabled = true;}, 0);
        }</script>
</html>
