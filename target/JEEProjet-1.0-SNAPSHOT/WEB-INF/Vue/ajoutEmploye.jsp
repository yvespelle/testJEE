<%-- 
    Document   : ajoutEmploye
    Created on : 19 juin 2018, 15:17:37
    Author     : rive droite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

                        <legend>Ajouter un employé</legend>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Nom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmNom" value=""   class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Prénom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmPrenom"  value=""  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Tél dom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmTelDomicile" value=""  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Tél mob</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmTelPortable" value=""  class="form-control">
                            </div>
                        </div>                      

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Tél pro</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmTelPro" value=""  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" >Adresse</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmAdresse" value=""   class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Code postal</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmCodePostal" value="" class="form-control">
                            </div>
                        </div>

                        <label class="col-sm-2 control-label" for="textinput">Ville</label>
                        <div class="col-sm-4">
                            <input type="text" name="frmVille" value=""class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Adresse e-mail</label>
                            <div class="col-sm-4">
                                <input type="text" name="frmEmail" value=""  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="pull-right">
                                    <button id="a" type="submit" name="action" value="Ajouter Employe" class="btn btn-primary" onclick="function disableBtn()">Ajouter l'employé</button>
                                </div>
                            </div>
                        </div>
                        <br/><font color="${couleur}"> ${message_ajouter};</font>
                    </fieldset>
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
