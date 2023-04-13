package use_case.trackday;

import model.Comissaire;
import model.Equipement;
import model.RolePiste;

import java.util.ArrayList;
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
}