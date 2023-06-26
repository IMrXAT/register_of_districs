package nsu.iss.register.districts.core.farmers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmerCreationDto {
    private String organizationName;
    private String organizationForm;
    private String INN;
    private String KPP;
    private String OGRN;
    private String registerDistrict;
    private List<String> fieldsDistricts;
}
