package nsu.iss.register.districts.core.farmers.repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FarmerFilter {
    private String farmerName;
    private String INN;
    private String farmerRegistrationDistrictName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startRegistrationDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endRegistrationDate;
}
