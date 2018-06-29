<%-- 
    Document   : detailsEmploye
    Created on : 3 nov. 2016, 11:13:04
    Author     : rive droite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    </head>
    <body>

        <div class="row">
            <div class="col-md-6 col-md-offset-2">
                <form class="form-horizontal" action="Controleur" method="POST">
                    <fieldset>
                        <legend>Détails du membre ${employe.prenom}  ${employe.nom} </legend>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Nom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmNom" value="${employe.nom}"   class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Prénom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmPrenom"  value="${employe.prenom}"  class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Tél dom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmTelDomicile" value="${employe.teldom}"  class="form-control" maxlength="10">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Tél mob</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmTelPortable" value="${employe.telport}"  class="form-control" maxlength="10">
                            </div>
                        </div>                      

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Tél pro</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmTelPro" value="${employe.telpro}"  class="form-control" maxlength="10">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" >Adresse</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmAdresse" value="${employe.adresse}"   class="form-control" maxlength="150">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Code postal</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmCodePostal" value="${employe.codepostal}" class="form-control" maxlength="15">
                            </div>
                        </div>

                        <label class="col-sm-2 control-label" for="textinput">Ville</label>
                        <div class="col-sm-4">
                            <input type="text" name="frmVille" value="${employe.ville}"class="form-control" maxlength="25">
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Adresse e-mail</label>
                            <div class="col-sm-4">
                                <input type="text" name="frmEmail" value="${employe.email}"  class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="pull-right">
                                    <button type="submit" name="action" value="Modifier" class="btn btn-primary">Modifier</button>
                                    <button type="submit" name="action" value="Voir Liste" class="btn btn-default" >Voir liste</button>
                                    <br><font color="${couleur_modifier}"> ${message_modifier}</font>
                                </div>
                            </div>
                        </div>

                    </fieldset>

                </form>
            </div>
        </div>
    </div>
</body>
</html>
