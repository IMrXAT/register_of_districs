package nsu.isis.register_of_districts.core.districts.repository;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DistrictFilter{
    private String districtName;
    private Long districtCode;
}
