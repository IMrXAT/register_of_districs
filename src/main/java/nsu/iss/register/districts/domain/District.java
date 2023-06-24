package nsu.iss.register.districts.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "district")
public class District {

    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String districtName;

    private Long districtCode;

    private Boolean isArchived;

    public District(){}
    public District(String districtName, Long districtCode, Boolean isArchived) {
        this.districtName = districtName;
        this.districtCode = districtCode;
        this.isArchived = isArchived;
    }
}


