package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trip implements IBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private LocalDate dateDeparture;
    private LocalDate dateReturn;
    private int days;

    @Enumerated(EnumType.STRING)
    private TypeOfMeal typeOfMeal;

    private int priceForAdult;
    private int priceForChild;

    private boolean promotion;

    private int seatsForAdult;
    private int seatsForChild;

    @ManyToOne
    private City fromCity;

    @ManyToOne
    private City toCity;

}
