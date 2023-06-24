package nsu.iss.register.districts.core.farmers.dto;

import lombok.Getter;
import lombok.Setter;
import nsu.iss.register.districts.domain.District;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class FarmerCreationDto {

    private String organizationName;
    private String organizationForm;
    private String INN;
    private String KPP;
    private String OGRN;
    private String registerDistrict;
    private List<String> fieldsDistricts;
}
