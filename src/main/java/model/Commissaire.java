package model;

import domain.Comissaire;
import domain.RolePiste;

import java.util.List;

public class Commissaire {
    public static int getNbCommisaires(List<Comissaire> comissaires) {
        return comissaires.size();
    }

    public static boolean checkDirecteurAvailability(List<Comissaire> comissaires) {

        for (Comissaire comissaire : comissaires) {
            if (comissaire.getRole() == RolePiste.DIRECTEUR_PISTE) {
                return true;
            }
        }
        return false;
    }
}
