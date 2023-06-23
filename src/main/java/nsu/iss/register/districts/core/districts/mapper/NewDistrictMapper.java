package nsu.iss.register.districts.core.districts.mapper;

import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.districts.dto.DistrictCreationDto;
import nsu.iss.register.districts.domain.District;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class NewDistrictMapper {

    private final ModelMapper modelMapper;

    public DistrictCreationDto toDto(District district){
        return Objects.isNull(district) ? null : modelMapper.map(district, DistrictCreationDto.class);
    }

    public District toEntity(DistrictCreationDto districtDto){
        return Objects.isNull(districtDto) ? null : modelMapper.map(districtDto, District.class);
    }
}
