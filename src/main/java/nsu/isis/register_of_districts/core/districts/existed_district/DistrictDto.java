package nsu.isis.register_of_districts.core.districts.existed_district;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDto {
    private Long id;
    private String districtName;
    private Long districtCode;
}
