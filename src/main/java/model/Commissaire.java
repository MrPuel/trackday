package model;

import domain.CommissaireDTO;
import domain.RolePisteDTO;

import java.util.List;

public class Commissaire {
    public static int getNbCommisaires(List<CommissaireDTO> commissaireDTOS) {
        return commissaireDTOS.size();
    }

    public static boolean checkDirecteurAvailability(List<CommissaireDTO> commissaireDTOS) {

        for (CommissaireDTO commissaireDTO : commissaireDTOS) {
            if (commissaireDTO.getRole() == RolePisteDTO.DIRECTEUR_PISTE) {
                return true;
            }
        }
        return false;
    }
}
