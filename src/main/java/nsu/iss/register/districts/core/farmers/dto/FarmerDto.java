package nsu.iss.register.districts.core.farmers.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FarmerDto {
    private String organizationName;
    private String organizationForm;
    private String INN;
    private String KPP;
    private String OGRN;
    private String registerDistrict;
    private LocalDate registrationDate;
}
