package use_case.trackday;

import domain.CommissaireDTO;
import domain.EquipementDTO;
import domain.TrackdayDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static model.Commissaire.checkDirecteurAvailability;
import static model.Commissaire.getNbCommisaires;
import static model.Equipement.getNbEquipementValide;

public class OrganiserTrackday {

    public TrackdayDTO createTrackday(Date date, int pisteId, List<EquipementDTO> equipementDTOS, List<Integer> vehiculeIds, List<CommissaireDTO> commissaireDTOS) throws Exception {
        //créer un trackday
        if(getNbEquipementValide(equipementDTOS)< 80){
            throw new Exception("Not enough equipements");
        }
        if(getNbCommisaires(commissaireDTOS) < 4){
            throw new Exception("Not enough commissaires");
        }

        if(!checkDirecteurAvailability(commissaireDTOS)){
            throw new Exception("No director available");
        }

        UUID uuid = UUID.randomUUID();

        return new TrackdayDTO(uuid, date, pisteId, equipementDTOS, vehiculeIds, commissaireDTOS);
    }

}
