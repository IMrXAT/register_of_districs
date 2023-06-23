package nsu.iss.register.districts.core.districts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictCreationDto {
    private String districtName;
    private Long districtCode;
}
