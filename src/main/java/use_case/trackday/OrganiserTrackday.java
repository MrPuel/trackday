package use_case.trackday;

import model.Comissaire;
import model.Equipement;
import model.RolePiste;
import model.Trackday;

import java.util.Date;
import java.util.List;

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

        return new Trackday(date, pisteId, equipements, vehiculeIds, comissaires);
    }

    public double getNbEquipementValide(List<Equipement> equipements){
        int nbEquipementValide = 0;
        if (equipements.size() == 0){
            return 0;
        }
        for (Equipement equipement : equipements) {
            if (equipement.checkEquipement()) {
                nbEquipementValide++;
            }
        }

        return (double)nbEquipementValide/equipements.size() * 100;
    }
     public int getNbCommisaires(List<Comissaire> comissaires) {
         return comissaires.size();
     }

     public boolean checkDirecteurAvailability(List<Comissaire> comissaires) {

         for (Comissaire comissaire : comissaires) {
             if (comissaire.getRole() == RolePiste.CHEF_PISTE) {
                 return true;
             }
         }
         return false;
     }
}
