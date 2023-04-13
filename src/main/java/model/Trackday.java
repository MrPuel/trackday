package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trackday {
    private Date date;
    private int pisteId;
    private List<Equipement> equipements;
    private List<Integer> vehiculeIds;
    private List<Comissaire> comissaires;

}
