package model;

import dto.Comissaire;
import dto.RolePiste;

import java.util.List;

public class Directeur {
    public static boolean checkDirecteurAvailability(List<Comissaire> comissaires) {

        for (Comissaire comissaire : comissaires) {
            if (comissaire.getRole() == RolePiste.CHEF_PISTE) {
                return true;
            }
        }
        return false;
    }
}
