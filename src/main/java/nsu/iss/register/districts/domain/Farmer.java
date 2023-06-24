package nsu.iss.register.districts.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;





@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    public void addNewFieldDistrict(District district) {
        fieldsDistricts.add(district);
    }
}
