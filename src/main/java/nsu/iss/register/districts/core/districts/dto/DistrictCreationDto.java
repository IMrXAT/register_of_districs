package nsu.iss.register.districts.core.districts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictCreationDto {
    @NonNull
    private String districtName;
    private Long districtCode;
}
