package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipementDTO {
    private int id;
    private boolean estRevise;

    public boolean checkEquipement(){
        return estRevise;
    }

}
