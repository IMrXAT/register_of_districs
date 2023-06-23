package nsu.iss.register.districts.core.districts.mapper;

import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.districts.dto.DistrictDto;
import nsu.iss.register.districts.domain.District;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class DistrictMapper {

    private final ModelMapper modelMapper;

    public DistrictDto toDto(District district){
        return Objects.isNull(district) ? null : modelMapper.map(district, DistrictDto.class);
    }

    public District toEntity(DistrictDto districtDto){
        return Objects.isNull(districtDto) ? null : modelMapper.map(districtDto, District.class);
    }

}
