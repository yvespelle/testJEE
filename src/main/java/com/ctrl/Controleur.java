/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ctrl;

import com.modele.Identifiants;
import com.modele.Employe;
import com.modele.EmployeSB;
import com.utils.EmployesConstantes;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class Controleur extends HttpServlet {

    ArrayList<Employe> listeEmployes;
    ArrayList<Identifiants> listeCredentials;
    Employe employe;
    Employe employe1;
    Employe employe2;
    Employe employe3;
    Employe employe4;
    Employe employe5;
    Identifiants user;
    String idEmploye = EmployesConstantes.FRM_ID_EMPL_SELECT;

    @EJB
    private EmployeSB emEmploye;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String loginForm = request.getParameter(EmployesConstantes.FRM_LOGIN);
        String mdpForm = request.getParameter(EmployesConstantes.FRM_MDP);
        String action = request.getParameter(EmployesConstantes.ACTION);
        listeEmployes = new ArrayList<>();
        listeCredentials = new ArrayList<>();
        boolean test;

        if (action == null) {
            request.getRequestDispatcher(EmployesConstantes.PAGE_INDEX).forward(request, response);
        } else {
            switch (action) {
                case EmployesConstantes.ACTION_LOGIN:
                    //Si le nom d'utilisateur et le mot de passe sont vide, renvoyer vers l'index
                    //avec un message d'erreur.
                    if (loginForm != null && mdpForm != null) {

                        if (loginForm.isEmpty() || mdpForm.isEmpty()) {
                            request.setAttribute("cleMessageErreur", EmployesConstantes.ERREUR_SAISIE_VIDE);
                            request.getRequestDispatcher(EmployesConstantes.PAGE_INDEX).forward(request, response);
                        } else {
                            listeCredentials.clear();
                            listeCredentials.addAll(emEmploye.getIdentifiants());

                            for (int i = 0; i < listeCredentials.size(); i++) {
                                ArrayList<Identifiants> userBase = listeCredentials;

                                if (userBase.get(i).getLogin().equals(loginForm) && userBase.get(i).getMdp().equals(mdpForm)) {
                                    request.setAttribute("cleLoginForm", loginForm);
                                    request.getRequestDispatcher(EmployesConstantes.PAGE_BIENVENUE).forward(request, response);

                                } //Sinon envoyer vers la page d'accueil avec un message d'erreur.
                            }
                            request.setAttribute("cleMessageErreur", EmployesConstantes.ERREUR_INFOS_CONN_KO);
                            request.getRequestDispatcher(EmployesConstantes.PAGE_INDEX).forward(request, response);

                        }
                    }
                    break;

                case EmployesConstantes.ACTION_SUPPRIMER:
                    if (request.getParameter(idEmploye) != null) {
                        emEmploye.supprimerEmploye(request.getParameter(idEmploye));
                        listeEmployes.clear();
                        listeEmployes.addAll(emEmploye.getEmployes());

                        //envoie un message de succès supprimer de couleur verte
                        request.setAttribute("cleListeEmployes", listeEmployes);
                        request.setAttribute("couleur_supp", "green");
                        request.setAttribute("message_supprimer", EmployesConstantes.SUCCES_SUPPR);
                        request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    } else {

                        //envoie un message de echec supprimer de couleur rouge
                        listeEmployes.clear();
                        listeEmployes.addAll(emEmploye.getEmployes());
                        request.setAttribute("cleListeEmployes", listeEmployes);
                        request.setAttribute("couleur_supp", "red");
                        request.setAttribute("message_supprimer", EmployesConstantes.ERREUR_SUPPR);
                        request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    }
                    break;

                case EmployesConstantes.ACTION_MODIFIER:

                    int idEmp = (Integer) session.getAttribute("idEmp");

                    employe = new Employe(idEmp,
                            request.getParameter(EmployesConstantes.CHAMP_NOM),
                            request.getParameter(EmployesConstantes.CHAMP_PRENOM),
                            request.getParameter(EmployesConstantes.CHAMP_TELDOMICILE),
                            request.getParameter(EmployesConstantes.CHAMP_TELPORTABLE),
                            request.getParameter(EmployesConstantes.CHAMP_TELPRO),
                            request.getParameter(EmployesConstantes.CHAMP_ADRESSE),
                            request.getParameter(EmployesConstantes.CHAMP_CODEPOSTAL),
                            request.getParameter(EmployesConstantes.CHAMP_VILLE),
                            request.getParameter(EmployesConstantes.CHAMP_EMAIL));

                    emEmploye.modifierEmploye(employe);

                    listeEmployes.clear();
                    listeEmployes.addAll(emEmploye.getEmployes());
                    request.setAttribute("cleListeEmployes", listeEmployes);
                    request.setAttribute("message_modifier", EmployesConstantes.SUCCES_MODIFIER);
                    request.setAttribute("couleur_modifier", "green");
                    session.setAttribute("employe", employe);

                    request.getRequestDispatcher(EmployesConstantes.PAGE_DETAIL_EMPLOYE).forward(request, response);

                    break;

                case EmployesConstantes.ACTION_DETAILS:
                    // afficher les details si un radio bouton est selectionné
                    if (request.getParameter(idEmploye) != null) {
                        int idEmployeSelect = Integer.parseInt(request.getParameter(idEmploye));
                        session.setAttribute("idEmp", idEmployeSelect);
                        employe = emEmploye.getEmployeParId(idEmployeSelect);
                        session.setAttribute("employe", employe);
                        request.getRequestDispatcher(EmployesConstantes.PAGE_DETAIL_EMPLOYE).forward(request, response);

                    } else {
                        // si aucun radio bouton n'est selectionné message d'erreur en rouge
                        listeEmployes.clear();
                        listeEmployes.addAll(emEmploye.getEmployes());
                        request.setAttribute("cleListeEmployes", listeEmployes);
                        request.setAttribute("couleur", "red");
                        request.setAttribute("message_details", EmployesConstantes.ERREUR_DETAILS);
                        request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    }
                    break;

                case EmployesConstantes.ACTION_VOIR_LISTE:
                    listeEmployes.clear();
                    listeEmployes.addAll(emEmploye.getEmployes());
                    request.setAttribute("cleListeEmployes", listeEmployes);
                    request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;

                case EmployesConstantes.ACTION_AJOUTER:
                    // renvoie vers une page "blanche" pour ajouter un employé
                    request.getRequestDispatcher(EmployesConstantes.PAGE_AJOUT_EMPLOYE).forward(request, response);
                    break;

                case EmployesConstantes.ACTION_ADD_EMPLOYE:
                    // récupère les champs pour ajouter un employé en base
                    employe = new Employe(
                            request.getParameter(EmployesConstantes.CHAMP_NOM),
                            request.getParameter(EmployesConstantes.CHAMP_PRENOM),
                            request.getParameter(EmployesConstantes.CHAMP_TELDOMICILE),
                            request.getParameter(EmployesConstantes.CHAMP_TELPORTABLE),
                            request.getParameter(EmployesConstantes.CHAMP_TELPRO),
                            request.getParameter(EmployesConstantes.CHAMP_ADRESSE),
                            request.getParameter(EmployesConstantes.CHAMP_CODEPOSTAL),
                            request.getParameter(EmployesConstantes.CHAMP_VILLE),
                            request.getParameter(EmployesConstantes.CHAMP_EMAIL));

                    test = emEmploye.ajouterEmploye(employe);

                    if (test) {
                        listeEmployes.clear();
                        listeEmployes.addAll(emEmploye.getEmployes());
                        request.setAttribute("cleListeEmployes", listeEmployes);
                        request.setAttribute("message_ajouter", EmployesConstantes.SUCCES_AJOUTER);
                        request.setAttribute("couleur", "green");
                        request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    } else {
                        // si aucune info n'est entrée envoie un message d'erreur
                        request.setAttribute("message_ajouter", EmployesConstantes.ERREUR_AJOUTER);
                    }
                    request.setAttribute("couleur", "red");
                    request.getRequestDispatcher(EmployesConstantes.PAGE_AJOUT_EMPLOYE).forward(request, response);
                    break;

                case EmployesConstantes.ACTION_CREER_EMPLOYES:

                    emEmploye.recruterEmployes(employe1);

                    listeEmployes.clear();
                    listeEmployes.addAll(emEmploye.getEmployes());
                    request.setAttribute("cleListeEmployes", listeEmployes);
                    request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void init() {

    }

}
