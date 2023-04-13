package use_case.trackday;

import java.util.List;

public class OrganiserTrackday {
    //piste préparé, équipement révisé, coaching, véhicule, comissaire, date

    public Trackday createTrackday(date date, int pisteId, List<equipement> equipements, List<Integer> vehicules, List<comissaire> comissaires){
        //créer un trackday
        if(!piste.checkPiste()){
            return null;
        }
        if(getNbEquipementValide(equipements)< 80){
            return null;
        }
        if(getNbCommisaires(comissaires) < 4){
            return null;
        }

        return new Trackday(date, pisteId, equipements, vehicules, comissaires);
    }

    public double getNbEquipementValide(list<equipement> equipements){
        int nbEquipementValide = 0;
        if (equipements.size() == 0){
            return 0;
        }
        for (int i = 0; i < equipements.size(); i++) {
            if(equipements.get(i).checkEquipement()){
                nbEquipementValide++;
            }
        }
        return nbEquipementValide/equipements.size() * 100;
    }
     public int getNbCommisaires(list<comissaire> comissaires) {
         return comissaires.size();
     }
}
