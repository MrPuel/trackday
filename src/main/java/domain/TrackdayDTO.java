package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackdayDTO {
    private UUID id;
    private Date date;
    private int pisteId;
    private List<EquipementDTO> equipementDTOS;
    private List<Integer> vehiculeIds;
    private List<CommissaireDTO> commissaireDTOS;

}
