package nsu.iss.register.districts.core.farmers.mapper;

import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.farmers.dto.FarmerDto;
import nsu.iss.register.districts.domain.District;
import nsu.iss.register.districts.domain.Farmer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FarmerMapper {


    public FarmerDto toDto(Farmer farmer) {
        return new FarmerDto(
                farmer.getId(),
                farmer.getOrganizationName(),
                farmer.getOrganizationForm(),
                farmer.getINN(),
                farmer.getKPP(),
                farmer.getOGRN(),
                farmer.getRegisterDistrict().getDistrictName(),
                farmer.getRegistrationDate(),
                farmer.getFieldsDistricts()
                        .stream()
                        .map(District::getDistrictName)
                        .collect(Collectors.toList()),
                farmer.isArchived()
                );
    }


    public void updateFarmerByNotNullFieldsOfFarmerDto(Farmer farmer, FarmerDto farmerDto) {
        if (farmerDto.getOrganizationName() != null) {
            farmer.setOrganizationName(farmerDto.getOrganizationName());
        }
        if (farmerDto.getOrganizationForm() != null) {
                farmer.setOrganizationForm(farmerDto.getOrganizationForm());
        }
        if (farmerDto.getINN() != null) {
            farmer.setINN(farmerDto.getINN());
        }
        if (farmerDto.getKPP() != null) {
            farmer.setINN(farmerDto.getKPP());
        }
        if (farmerDto.getOGRN() != null) {
            farmer.setOGRN(farmerDto.getOGRN());
        }
    }

}
