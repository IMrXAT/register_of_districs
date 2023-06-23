package nsu.iss.register.districts.core.farmers.mapper;

import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.farmers.dto.FarmerDto;
import nsu.iss.register.districts.domain.Farmer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class FarmerMapper {

    private final ModelMapper modelMapper;

    public FarmerDto toDto(Farmer farmer) {
        return Objects.isNull(farmer) ? null : modelMapper.map(farmer, FarmerDto.class);
    }
}
