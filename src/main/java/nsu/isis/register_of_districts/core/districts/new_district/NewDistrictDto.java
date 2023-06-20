package nsu.isis.register_of_districts.core.districts.new_district;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewDistrictDto {
    private String districtName;
    private Long districtCode;
}
