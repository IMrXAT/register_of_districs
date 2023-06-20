package nsu.isis.register_of_districts.core.districts.existed_district;

import nsu.isis.register_of_districts.core.districts.existed_district.DistrictDto;
import nsu.isis.register_of_districts.domain.District;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DistrictMapper {

    private final ModelMapper modelMapper;

    public DistrictMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DistrictDto toDto(District district){
        return Objects.isNull(district) ? null : modelMapper.map(district, DistrictDto.class);
    }

    public District toEntity(DistrictDto districtDto){
        return Objects.isNull(districtDto) ? null : modelMapper.map(districtDto, District.class);
    }

}
