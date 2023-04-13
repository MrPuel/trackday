package model;

import java.util.List;

public class Equipement {
    public static double getNbEquipementValide(List<dto.Equipement> equipements){
        int nbEquipementValide = 0;
        if (equipements.size() == 0){
            return 0;
        }
        for (dto.Equipement equipement : equipements) {
            if (equipement.checkEquipement()) {
                nbEquipementValide++;
            }
        }

        return (double)nbEquipementValide/equipements.size() * 100;
    }
}
