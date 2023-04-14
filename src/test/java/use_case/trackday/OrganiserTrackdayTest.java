package use_case.trackday;

import domain.Comissaire;
import domain.Equipement;
import domain.RolePiste;
import domain.Trackday;
import model.Commissaire;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static model.Equipement.getNbEquipementValide;

class OrganiserTrackdayTest {

    @org.junit.jupiter.api.Test
    void createTrackday() {
        List<Equipement> equipements = new ArrayList<>(){
            {
                add(new Equipement(1, true));
                add(new Equipement(2, true));
            }
        };

        List<Comissaire> comissaires = new ArrayList<>(){
            {
                add(new Comissaire(1, RolePiste.DIRECTEUR_PISTE));
                add(new Comissaire(2, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(3, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(4, RolePiste.DIRECTEUR_PISTE));
            }
        };

        List<Integer> vehiculeIds = new ArrayList<>(){
            {
                add(1);
                add(2);
            }
        };
        Date date = new Date();
        try {
            Trackday trackday = new OrganiserTrackday().createTrackday(date,1, equipements, vehiculeIds, comissaires);
            boolean trackdayCreated = trackday != null;
            assertTrue(trackdayCreated, "Le trackday n'a pas été créé.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @org.junit.jupiter.api.Test
    void getNbEquipementsValide() {
        List<Equipement> equipements = new ArrayList<>(){
            {
                add(new Equipement(1, true));
                add(new Equipement(2, true));
            }
        };

        double nbEquipementValide = getNbEquipementValide(equipements);
        assertTrue(nbEquipementValide >= 80, "Il y a moins de 80% d'équipements valides.");
    }

    @org.junit.jupiter.api.Test
    void getNbCommisaires() {
        List<Comissaire> comissaires = new ArrayList<>(){
            {
                add(new Comissaire(1, RolePiste.DIRECTEUR_PISTE));
                add(new Comissaire(2, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(3, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(4, RolePiste.DIRECTEUR_PISTE));
            }
        };

        int nbComissaire = Commissaire.getNbCommisaires(comissaires);
        assertTrue(nbComissaire >= 4, "Il y a moins de 4 comissaires disponibles.");
    }

    @org.junit.jupiter.api.Test
    void checkDirecteurAvailability() {
        List<Comissaire> comissaires = new ArrayList<>(){
            {
                add(new Comissaire(1, RolePiste.DIRECTEUR_PISTE));
                add(new Comissaire(2, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(3, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(4, RolePiste.DIRECTEUR_PISTE));
            }
        };

        boolean directeurAvailability = Commissaire.checkDirecteurAvailability(comissaires);

        assertTrue(directeurAvailability, "Il n'y a pas de directeur de piste disponible.");
    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayOK() {
        try {
            Trackday result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(true), getVehiculeIdList(), getComissaireList(5, true));
            assertNotNull(result);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayNotEnoughComissaire() {
        try {
            Trackday result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(true), getVehiculeIdList(), getComissaireList(3, true));
            assertNull(result);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayNoChefComissaire() {
        try {
            Trackday result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(true), getVehiculeIdList(), getComissaireList(5, false));
            assertNull(result);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayNotEnoughEquipment() {
        try {
            Trackday result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(false), getVehiculeIdList(), getComissaireList(5, true));
            assertNull(result);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private List<Comissaire> getComissaireList(int nbComissaires, boolean hasChef) {
        List<Comissaire> resultList = new ArrayList<>();
        int id = 0;
        if(hasChef) {
            id++;
            resultList.add(new Comissaire(id,RolePiste.DIRECTEUR_PISTE));
        }
        int until = nbComissaires-id;
        for (int i = 0; i < until; i++) {
            id++;
            resultList.add(new Comissaire(id,RolePiste.COMISSAIRE_PISTE));

        }

        return resultList;
    }

    private List<Equipement> getEquipmentList(boolean isOK) {
        List<Equipement> resultList = new ArrayList<>();
        int id = 0;
        for (int i = 0; i < 10; i++) {
            id++;
            resultList.add(new Equipement(id, isOK));
        }

        return resultList;
    }

    private List<Integer> getVehiculeIdList(){
        var vehiculeId = new ArrayList<Integer>();
        vehiculeId.add(1);
        vehiculeId.add(2);
        vehiculeId.add(3);
        vehiculeId.add(4);
        vehiculeId.add(5);
        return vehiculeId;
    }
}