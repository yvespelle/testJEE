/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modele;

import com.utils.EmployesConstantes;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jacques
 */
@Stateless
public class EmployeSB {

    @PersistenceContext(unitName = "EmployesServleTryStuffPU")
    private EntityManager em;

    public Collection<Employe> getEmployes() {

        Query findAllQuery = em.createNamedQuery("recupererTousLesEmployes");
        return findAllQuery.getResultList();
    }

    public void supprimerEmploye(String id) {

        int idEmp = Integer.parseInt(id);
        Query q = em.createQuery(EmployesConstantes.REQUETE_SUPPRIMER);
        q.setParameter("emplId", idEmp);
        q.executeUpdate();

    }

    public boolean ajouterEmploye(Employe empl) {
        // le boolean envoie un message conditionnel
        boolean test = false;
        Employe employe = new Employe();

        employe.setPrenom(empl.getPrenom());
        employe.setNom(empl.getNom());
        employe.setAdresse(empl.getAdresse());
        employe.setCodepostal(empl.getCodepostal());
        employe.setEmail(empl.getEmail());
        employe.setTeldom(empl.getTeldom());
        employe.setTelport(empl.getTelport());
        employe.setTelpro(empl.getTelpro());
        employe.setVille(empl.getVille());

        // filtres pour renseigner les champs sur la taille et empeche d'enregistrer sans nom, prénom ou adresse
        if (empl.getNom().length() < 25 && empl.getPrenom().length() < 25 && empl.getAdresse().length() < 100 && empl.getCodepostal().length() < 15 && empl.getEmail().length() < 35 && empl.getTeldom().length() < 15 && empl.getTelport().length() < 15 && empl.getTelpro().length() < 15 && empl.getVille().length() < 25
                && (!empl.getNom().equals("") || !empl.getPrenom().equals("") || !empl.getEmail().equals(("")))) {
            test = true;
            this.persist(employe);

        }
        return test;

    }

    public void recruterEmployes(Employe emp) {

        Employe employe1 = new Employe();

        employe1.setPrenom("Homer");
        employe1.setNom("Simpson");
        employe1.setAdresse("2 avenue Duff");
        employe1.setCodepostal("92700");
        employe1.setEmail("hsimpson@gmail.com");
        employe1.setTeldom("0123456789");
        employe1.setTelport("0612345678");
        employe1.setTelpro("0698765432");
        employe1.setVille("Colombes");

        Employe employe2 = new Employe();

        employe2.setPrenom("Mafalda");
        employe2.setNom("Querida");
        employe2.setAdresse("6 rue de Buenos Aires");
        employe2.setCodepostal("92700");
        employe2.setEmail("qmafalda@hotmail.ar");
        employe2.setTeldom("0123456789");
        employe2.setTelport("0612345678");
        employe2.setTelpro("0698765432");
        employe2.setVille("Paris");

        Employe employe3 = new Employe();

        employe3.setPrenom("Gaston");
        employe3.setNom("Lagaffe");
        employe3.setAdresse("10 rue des Rebelles");
        employe3.setCodepostal("92700");
        employe3.setEmail("glagaffe@yahoo.fr");
        employe3.setTeldom("0123456789");
        employe3.setTelport("0612345678");
        employe3.setTelpro("0698765432");
        employe3.setVille("Colombes");

        Employe employe4 = new Employe();

        employe4.setPrenom("Woody");
        employe4.setNom("Woodpecker");
        employe4.setAdresse("5 bvd des Picoreurs");
        employe4.setCodepostal("92700");
        employe4.setEmail("woody@mail.co.uk");
        employe4.setTeldom("0123456789");
        employe4.setTelport("0612345678");
        employe4.setTelpro("0698765432");
        employe4.setVille("Dijon");

        Employe employe5 = new Employe();

        employe5.setPrenom("Charlie");
        employe5.setNom("Brown");
        employe5.setAdresse("140 avenue Foche");
        employe5.setCodepostal("92700");
        employe5.setEmail("cbrown@live.com");
        employe5.setTeldom("0123456789");
        employe5.setTelport("0612345678");
        employe5.setTelpro("0698765432");
        employe5.setVille("Nanterre");

        this.persist(employe1);
        this.persist(employe2);
        this.persist(employe3);
        this.persist(employe4);
        this.persist(employe5);

    }

    public void modifierEmploye(Employe empl) {

        Employe employe = (Employe) em.find(Employe.class, empl.getId());

        employe.setPrenom(empl.getPrenom());
        employe.setNom(empl.getNom());
        employe.setAdresse(empl.getAdresse());
        employe.setCodepostal(empl.getCodepostal());
        employe.setEmail(empl.getEmail());
        employe.setTeldom(empl.getTeldom());
        employe.setTelport(empl.getTelport());
        employe.setTelpro(empl.getTelpro());
        employe.setVille(empl.getVille());

        this.persist(employe);
    }

    public Employe getEmployeParId(int id) {

        Query findById = em.createQuery(EmployesConstantes.REQUETE_DETAILS);
        findById.setParameter("idEmp", id);
        Employe empl = (Employe) findById.getSingleResult();
        return empl;

    }

    public Collection<Identifiants> getIdentifiants() {
        Query findAllQuery = em.createNamedQuery("recupererLesIdentifiants");
        return findAllQuery.getResultList();

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
