package use_case.trackday;

import domain.Comissaire;
import domain.Equipement;
import domain.Trackday;

import java.util.Date;
import java.util.List;

import static model.Commissaire.checkDirecteurAvailability;
import static model.Commissaire.getNbCommisaires;
import static model.Equipement.getNbEquipementValide;

public class OrganiserTrackday {

    public Trackday createTrackday(Date date, int pisteId, List<Equipement> equipements, List<Integer> vehiculeIds, List<Comissaire> comissaires) throws Exception {
        //créer un trackday
        if(getNbEquipementValide(equipements)< 80){
            throw new Exception("bad equipements");
        }
        if(getNbCommisaires(comissaires) < 4){
            throw new Exception("Not enougth commissaires");
        }

        if(!checkDirecteurAvailability(comissaires)){
            throw new Exception("No director available");
        }

        return new Trackday(date, pisteId, equipements, vehiculeIds, comissaires);
    }

}
