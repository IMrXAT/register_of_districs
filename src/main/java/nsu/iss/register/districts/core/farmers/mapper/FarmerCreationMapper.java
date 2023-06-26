package nsu.iss.register.districts.core.farmers.mapper;

import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.districts.exception.DistrictNotFoundException;
import nsu.iss.register.districts.core.districts.repository.DistrictRepository;
import nsu.iss.register.districts.core.farmers.dto.FarmerCreationDto;
import nsu.iss.register.districts.domain.District;
import nsu.iss.register.districts.domain.Farmer;
import nsu.iss.register.districts.domain.OrganizationForm;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class FarmerCreationMapper {


    private final DistrictRepository districtRepository;
    public Farmer toEntity(FarmerCreationDto farmerCreationDto){
        District registrationDistrict = districtRepository.findByDistrictName(farmerCreationDto.getRegisterDistrict());
        if (registrationDistrict == null){
            throw new DistrictNotFoundException("district to register farmer with district name" + farmerCreationDto.getRegisterDistrict() + "not found");
        }
        return new Farmer(
                null,
                farmerCreationDto.getOrganizationName(),
                OrganizationForm.valueOf(farmerCreationDto.getOrganizationForm()),
                farmerCreationDto.getINN(),
                farmerCreationDto.getKPP(),
                farmerCreationDto.getOGRN(),
                registrationDistrict,
                farmerCreationDto.getFieldsDistricts()
                        .stream()
                        .map(districtRepository::findByDistrictName)
                        .toList(),
                LocalDate.now(),
                false
                );
    }
}
