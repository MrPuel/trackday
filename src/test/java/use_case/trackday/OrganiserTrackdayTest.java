package use_case.trackday;

import domain.CommissaireDTO;
import domain.EquipementDTO;
import domain.RolePisteDTO;
import domain.TrackdayDTO;
import model.Commissaire;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static model.Equipement.getNbEquipementValide;

class OrganiserTrackdayTest {

    @org.junit.jupiter.api.Test
    void createTrackday() {
        List<EquipementDTO> equipementDTOS = new ArrayList<>(){
            {
                add(new EquipementDTO(1, true));
                add(new EquipementDTO(2, true));
            }
        };

        List<CommissaireDTO> commissaireDTOS = new ArrayList<>(){
            {
                add(new CommissaireDTO(1, RolePisteDTO.DIRECTEUR_PISTE));
                add(new CommissaireDTO(2, RolePisteDTO.COMISSAIRE_PISTE));
                add(new CommissaireDTO(3, RolePisteDTO.COMISSAIRE_PISTE));
                add(new CommissaireDTO(4, RolePisteDTO.DIRECTEUR_PISTE));
            }
        };

        List<Integer> vehiculeIds = new ArrayList<>(){
            {
                add(1);
                add(2);
            }
        };
        Date date = new Date();
        try {
            TrackdayDTO trackday = new OrganiserTrackday().createTrackday(date,1, equipementDTOS, vehiculeIds, commissaireDTOS);
            boolean trackdayCreated = trackday != null;
            assertTrue(trackdayCreated, "Le trackday n'a pas été créé.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @org.junit.jupiter.api.Test
    void getNbEquipementsValide() {
        List<EquipementDTO> equipementDTOS = new ArrayList<>(){
            {
                add(new EquipementDTO(1, true));
                add(new EquipementDTO(2, true));
            }
        };

        double nbEquipementValide = getNbEquipementValide(equipementDTOS);
        assertTrue(nbEquipementValide >= 80, "Il y a moins de 80% d'équipements valides.");
    }

    @org.junit.jupiter.api.Test
    void getNbCommisaires() {
        List<CommissaireDTO> commissaireDTOS = new ArrayList<>(){
            {
                add(new CommissaireDTO(1, RolePisteDTO.DIRECTEUR_PISTE));
                add(new CommissaireDTO(2, RolePisteDTO.COMISSAIRE_PISTE));
                add(new CommissaireDTO(3, RolePisteDTO.COMISSAIRE_PISTE));
                add(new CommissaireDTO(4, RolePisteDTO.DIRECTEUR_PISTE));
            }
        };

        int nbComissaire = Commissaire.getNbCommisaires(commissaireDTOS);
        assertTrue(nbComissaire >= 4, "Il y a moins de 4 comissaires disponibles.");
    }

    @org.junit.jupiter.api.Test
    void checkDirecteurAvailability() {
        List<CommissaireDTO> commissaireDTOS = new ArrayList<>(){
            {
                add(new CommissaireDTO(1, RolePisteDTO.DIRECTEUR_PISTE));
                add(new CommissaireDTO(2, RolePisteDTO.COMISSAIRE_PISTE));
                add(new CommissaireDTO(3, RolePisteDTO.COMISSAIRE_PISTE));
                add(new CommissaireDTO(4, RolePisteDTO.DIRECTEUR_PISTE));
            }
        };

        boolean directeurAvailability = Commissaire.checkDirecteurAvailability(commissaireDTOS);

        assertTrue(directeurAvailability, "Il n'y a pas de directeur de piste disponible.");
    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayOK() {
        try {
            TrackdayDTO result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(true), getVehiculeIdList(), getComissaireList(5, true));
            assertNotNull(result);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayNotEnoughComissaire() {
        try {
            TrackdayDTO result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(true), getVehiculeIdList(), getComissaireList(3, true));
            assertNull(result);
        } catch (Exception e) {
            assertEquals("Not enough commissaires", e.getMessage());
        }

    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayNoDirector() {
        try {
            TrackdayDTO result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(true), getVehiculeIdList(), getComissaireList(5, false));
            assertNull(result);
        } catch (Exception e) {
            assertEquals("No director available", e.getMessage());
        }

    }

    @org.junit.jupiter.api.Test
    void organiseTrackdayNotEnoughEquipment() {
        try {
            TrackdayDTO result = new OrganiserTrackday().createTrackday(new Date(), 100, getEquipmentList(false), getVehiculeIdList(), getComissaireList(5, true));
            assertNull(result);
        } catch (Exception e) {
            assertEquals("Not enough equipements", e.getMessage());
        }

    }

    private List<CommissaireDTO> getComissaireList(int nbComissaires, boolean hasChef) {
        List<CommissaireDTO> resultList = new ArrayList<>();
        int id = 0;
        if(hasChef) {
            id++;
            resultList.add(new CommissaireDTO(id, RolePisteDTO.DIRECTEUR_PISTE));
        }
        int until = nbComissaires-id;
        for (int i = 0; i < until; i++) {
            id++;
            resultList.add(new CommissaireDTO(id, RolePisteDTO.COMISSAIRE_PISTE));

        }

        return resultList;
    }

    private List<EquipementDTO> getEquipmentList(boolean isOK) {
        List<EquipementDTO> resultList = new ArrayList<>();
        int id = 0;
        for (int i = 0; i < 10; i++) {
            id++;
            resultList.add(new EquipementDTO(id, isOK));
        }

        return resultList;
    }

    private List<Integer> getVehiculeIdList(){
        var vehiculeId = new ArrayList<Integer>();
        vehiculeId.add(1);
        vehiculeId.add(2);
        vehiculeId.add(3);
        vehiculeId.add(4);
        vehiculeId.add(5);
        return vehiculeId;
    }
}