package nsu.isis.register_of_districts.core.districts.new_district;

import nsu.isis.register_of_districts.domain.District;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class NewDistrictMapper {

    private final ModelMapper modelMapper;

    public NewDistrictMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public NewDistrictDto toDto(District district){
        return Objects.isNull(district) ? null : modelMapper.map(district, NewDistrictDto.class);
    }

    public District toEntity(NewDistrictDto districtDto){
        return Objects.isNull(districtDto) ? null : modelMapper.map(districtDto, District.class);
    }
}
