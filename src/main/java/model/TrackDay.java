package model;
import domain.CommissaireDTO;
import domain.EquipementDTO;

import java.util.List;

import static model.Commissaire.checkDirecteurAvailability;
import static model.Commissaire.getNbCommisaires;
import static model.Equipement.getNbEquipementValide;

public class TrackDay {
    public static void checkTrackDay(List<EquipementDTO> equipementDTOS, List<CommissaireDTO> commissaireDTOS) throws Exception {
        if(getNbEquipementValide(equipementDTOS)< 80){
            throw new Exception("Not enough equipements");
        }
        if(getNbCommisaires(commissaireDTOS) < 4){
            throw new Exception("Not enough commissaires");
        }

        if(!checkDirecteurAvailability(commissaireDTOS)){
            throw new Exception("No director available");
        }
    }
}
