package use_case.trackday;

import model.Comissaire;
import model.Equipement;
import model.RolePiste;
import model.Trackday;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganiserTrackdayTest {

    @org.junit.jupiter.api.Test
    void createTrackday() {
    }

    @org.junit.jupiter.api.Test
    void getNbEquipementValide() {
        List<Equipement> equipements = new ArrayList<>(){
            {
                add(new Equipement(1, true));
                add(new Equipement(2, true));
            }
        };

        double nbEquipementValide = new OrganiserTrackday().getNbEquipementValide(equipements);
        assertTrue(nbEquipementValide >= 80, "Il y a moins de 80% d'équipements valides.");
    }

    @org.junit.jupiter.api.Test
    void getNbCommisaires() {
        List<Comissaire> comissaires = new ArrayList<>(){
            {
                add(new Comissaire(1, RolePiste.CHEF_PISTE));
                add(new Comissaire(2, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(3, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(4, RolePiste.CHEF_PISTE));
            }
        };

        assertTrue(comissaires.size() >= 4, "Il y a moins de 4 comissaires disponibles.");
    }

    @org.junit.jupiter.api.Test
    void checkDirecteurAvailability() {
        List<Comissaire> comissaires = new ArrayList<>(){
            {
                add(new Comissaire(1, RolePiste.CHEF_PISTE));
                add(new Comissaire(2, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(3, RolePiste.COMISSAIRE_PISTE));
                add(new Comissaire(4, RolePiste.CHEF_PISTE));
            }
        };

        boolean directeurAvailability = false;

        for(Comissaire comissaire : comissaires){
            if(comissaire.getRole() == RolePiste.CHEF_PISTE){
                directeurAvailability = true;
                break;
            }
        }

        assertTrue(directeurAvailability, "Il n'y a pas de directeur de piste disponible.");
    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayOK() {

        Trackday result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(true), getVehiculeIdList(), getComissaireList(5, true));
        assertNotNull(result);

    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayNotEnoughComissaire() {

        Trackday result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(true), getVehiculeIdList(), getComissaireList(3, true));
        assertNull(result);

    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayNoChefComissaire() {

        Trackday result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(true), getVehiculeIdList(), getComissaireList(5, false));
        assertNull(result);

    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayNotEnoughEquipment() {

        Trackday result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(false), getVehiculeIdList(), getComissaireList(5, true));
        assertNull(result);

    }

    private List<Comissaire> getComissaireList(int nbComissaires, boolean hasChef) {
        List<Comissaire> resultList = new ArrayList<>();
        int id = 0;
        if(hasChef) {
            id++;
            resultList.add(new Comissaire(id,RolePiste.CHEF_PISTE));
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
        return List.of(1,2,3,4,5);
    }
}