package nsu.iss.register.districts.core.farmers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nsu.iss.register.districts.domain.OrganizationForm;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmerDto {
    private String organizationName;
    private OrganizationForm organizationForm;
    private String INN;
    private String KPP;
    private String OGRN;
    private String registerDistrict;
    private LocalDate registrationDate;
    private List<String> fieldsDistricts;
}
