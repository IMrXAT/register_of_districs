package nsu.iss.register.districts.core.farmers.mapper;

import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.districts.repository.DistrictRepository;
import nsu.iss.register.districts.core.farmers.dto.FarmerCreationDto;
import nsu.iss.register.districts.core.farmers.repository.FarmerRepository;
import nsu.iss.register.districts.domain.District;
import nsu.iss.register.districts.domain.Farmer;
import nsu.iss.register.districts.domain.OrganizationForm;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class FarmerCreationMapper {


    private final DistrictRepository districtRepository;
    public Farmer toEntity(FarmerCreationDto farmerCreationDto){
        return new Farmer(
                null,
                farmerCreationDto.getOrganizationName(),
                OrganizationForm.valueOf(farmerCreationDto.getOrganizationForm()),
                farmerCreationDto.getINN(),
                farmerCreationDto.getKPP(),
                farmerCreationDto.getOGRN(),
                districtRepository.findByDistrictName(farmerCreationDto.getRegisterDistrict()),
                farmerCreationDto.getFieldsDistricts()
                        .stream()
                        .map(districtRepository::findByDistrictName)
                        .toList(),
                LocalDate.now(),
                false
                );
    }
}
