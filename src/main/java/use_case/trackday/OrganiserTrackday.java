package use_case.trackday;

import dto.Comissaire;
import dto.Equipement;
import dto.RolePiste;
import dto.Trackday;

import java.util.Date;
import java.util.List;

import static model.Commissaire.getNbCommisaires;
import static model.Directeur.checkDirecteurAvailability;
import static model.Equipement.getNbEquipementValide;

public class OrganiserTrackday {
    //piste préparé, équipement révisé, coaching, véhicule, comissaire, date

    public Trackday createTrackday(Date date, int pisteId, List<Equipement> equipements, List<Integer> vehiculeIds, List<Comissaire> comissaires){
        //créer un trackday
        if(getNbEquipementValide(equipements)< 80){
            return null;
        }
        if(getNbCommisaires(comissaires) < 4){
            return null;
        }

        if(!checkDirecteurAvailability(comissaires)){
            return null;
        }

        return new Trackday(date, pisteId, equipements, vehiculeIds, comissaires);
    }

}
