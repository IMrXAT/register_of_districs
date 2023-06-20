package nsu.isis.register_of_districts.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
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
public class FarmerRegister {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String organizationName;

    @Enumerated
    private OrganizationForm organizationForm;
    private String INN;
    private String KPP;
    private String OGRN;
    @ManyToOne
    private District registerDistrict;
    @ManyToMany
    @JoinTable(
            name = "district_field",
            joinColumns = @JoinColumn(name = "field"),
            inverseJoinColumns = @JoinColumn(name = "reg")
    )
    private List<District> fieldsDistricts;
    private LocalDate registrationDate;
    private boolean isArchived;
}
