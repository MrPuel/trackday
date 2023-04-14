package use_case.trackday;

import domain.CommissaireDTO;
import domain.EquipementDTO;
import domain.TrackdayDTO;
import model.TrackDay;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class OrganiserTrackday {

    public TrackdayDTO createTrackday(Date date, int pisteId, List<EquipementDTO> equipementDTOS, List<Integer> vehiculeIds, List<CommissaireDTO> commissaireDTOS) throws Exception {
        UUID uuid = UUID.randomUUID();

        TrackDay.checkTrackDay(equipementDTOS, commissaireDTOS);

        return new TrackdayDTO(uuid, date, pisteId, equipementDTOS, vehiculeIds, commissaireDTOS);
    }

}
