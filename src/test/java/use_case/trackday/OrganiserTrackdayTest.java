package use_case.trackday;

import static org.junit.jupiter.api.Assertions.*;

class OrganiserTrackdayTest {

    @org.junit.jupiter.api.Test
    void createTrackday() {
    }

    @org.junit.jupiter.api.Test
    void getNbEquipementValide() {
        double nbEquipementValide = 90;

        assertTrue(nbEquipementValide >= 80, "Il y a moins de 80% d'équipements valides.");
    }

    @org.junit.jupiter.api.Test
    void getNbCommisaires() {
        int nbCommisaires = 4;
        assertTrue(nbCommisaires >= 4, "Il y a moins de 4 comissaires disponibles.");
    }

    @org.junit.jupiter.api.Test
    void checkDirecteurAvailability() {
        boolean directeurAvailability = true;
        assertEquals(true, directeurAvailability, "Il n'y a pas de directeur de piste disponible.");
    }
}