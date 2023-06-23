package nsu.iss.register.districts.core.farmers.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class FarmerDto {
    private String organizationName;
    private String organizationForm;
    private String INN;
    private String KPP;
    private String OGRN;
    private String registerDistrict;
    private LocalDate registrationDate;

}
