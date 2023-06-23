package nsu.iss.register.districts.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


enum OrganizationForm{
    LEGAL_ENTITY,
    SOLE_TRADER,
    INDIVIDUAL
}


@Setter
@Getter
@Entity
@Table(name = "farmer_register")
public class Farmer {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String organizationName;
    @Enumerated
    private OrganizationForm organizationForm;
    @Column(nullable = false)
    private String INN;
    private String KPP;
    private String OGRN;
    @ManyToOne
    private District registerDistrict;
    @ManyToMany
    @JoinTable(
            name = "district_field",
            joinColumns = @JoinColumn(name = "field"),
            inverseJoinColumns = @JoinColumn(name = "reg"))
    private List<District> fieldsDistricts;

    private LocalDate registrationDate;
    private boolean isArchived;
}
