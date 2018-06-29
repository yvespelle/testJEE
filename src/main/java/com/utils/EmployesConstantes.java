package com.utils;

public final class EmployesConstantes {

    // requete JPQL
    public static final String REQUETE_SUPPRIMER = "delete from Employe e where e.id = :emplId";
    public static final String REQUETE_DETAILS = "SELECT e FROM Employe e WHERE e.id = :idEmp";

    public static final String ACTION = "action";
    public static final String ACTION_SUPPRIMER = "Supprimer";
    public static final String ACTION_DETAILS = "Details";
    public static final String ACTION_MODIFIER = "Modifier";
    public static final String ACTION_VOIR_LISTE = "Voir Liste";
    public static final String ACTION_LOGIN = "Login";
    public static final String ACTION_AJOUTER = "Ajouter";
    public static final String ACTION_ADD_EMPLOYE = "Ajouter Employe";
    public static final String ACTION_CREER_EMPLOYES = "Créer 5 Employés";

    //Constantes représentant les input de type text ou radio
    public static final String FRM_LOGIN = "login";
    public static final String FRM_MDP = "mdp";
    public static final String FRM_ID_EMPL_SELECT = "idEmploye";

    // Champs du formulaire de détails d'un employé
    public static final String CHAMP_ADRESSE = "frmAdresse";
    public static final String CHAMP_CODEPOSTAL = "frmCodePostal";
    public static final String CHAMP_EMAIL = "frmEmail";
    public static final String CHAMP_NOM = "frmNom";
    public static final String CHAMP_PRENOM = "frmPrenom";
    public static final String CHAMP_TELDOMICILE = "frmTelDomicile";
    public static final String CHAMP_TELPORTABLE = "frmTelPortable";
    public static final String CHAMP_TELPRO = "frmTelPro";
    public static final String CHAMP_VILLE = "frmVille";

    //Messages d'erreur
    public static final String ERREUR_SAISIE_VIDE = "Vous devez renseigner les deux champs";
    public static final String ERREUR_INFOS_CONN_KO = "Echec de la connexion! Verifiez votre login et/ou mot de passe et essayez à nouveau.";
    public static final String ERREUR_SUPPR = "Echec lors de la suppression! Vous avez bien sélectionné un membre?";
    public static final String SUCCES_SUPPR = "Suppression réussie!";
    public static final String ERREUR_DETAILS = "Veuillez selectionner un membre pour afficher les details.";
    public static final String ERREUR_AUCUNE_LIGNE_SELECT = "Vous n'avez sélectionné aucun employé!";
    public static final String ERREUR_AUCUN_EMPLOYE = "L'entreprise doit recruter !";
    public static final String SUCCES_AJOUTER = "Un employé a été ajouté avec succès";
    public static final String ERREUR_AJOUTER = "L'ajout n'a pas fonctionné. Merci de verifier les informations saisies.";
    public static final String SUCCES_MODIFIER = "Un employé a été modifié avec succès";
    public static final String ERREUR_MODIFIER = "La modification n'est pas possible. Merci de verifier les informations saisies.";

    //URL des pages jsp
    public static final String PAGE_INDEX = "/WEB-INF/Vue/index.jsp";
    public static final String PAGE_TOUS_LES_EMPLOYES = "/WEB-INF/Vue/tableauEmployes.jsp";
    public static final String PAGE_DETAIL_EMPLOYE = "/WEB-INF/Vue/detailsEmploye.jsp";
    public static final String PAGE_AJOUT_EMPLOYE = "/WEB-INF/Vue/ajoutEmploye.jsp";
    public static final String PAGE_BIENVENUE = "/WEB-INF/Vue/bienvenue.jsp";

}
