package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Country implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    @Enumerated(EnumType.STRING)
    private Continent continent;

    @ToString.Exclude
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<City> cities;


}
