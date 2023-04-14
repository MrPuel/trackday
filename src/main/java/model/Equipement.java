package model;

import domain.EquipementDTO;

import java.util.List;

public class Equipement {
    public static double getNbEquipementValide(List<EquipementDTO> equipementDTOS){
        int nbEquipementValide = 0;
        if (equipementDTOS.size() == 0){
            return 0;
        }
        for (EquipementDTO equipementDTO : equipementDTOS) {
            if (equipementDTO.checkEquipement()) {
                nbEquipementValide++;
            }
        }

        return (double)nbEquipementValide/ equipementDTOS.size() * 100;
    }
}
