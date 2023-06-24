package nsu.iss.register.districts.core.farmers;

import jakarta.transaction.Transactional;
import nsu.iss.register.districts.core.districts.repository.DistrictRepository;
import nsu.iss.register.districts.core.farmers.dto.FarmerDto;
import nsu.iss.register.districts.core.farmers.mapper.FarmerMapper;
import nsu.iss.register.districts.core.farmers.repository.FarmerFilter;
import nsu.iss.register.districts.core.farmers.repository.FarmerRepository;
import nsu.iss.register.districts.core.farmers.repository.FarmerSpecification;
import nsu.iss.register.districts.domain.District;
import nsu.iss.register.districts.domain.Farmer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    private final FarmerMapper farmerMapper;
    private final FarmerRepository farmerRepository;
    private final DistrictRepository districtRepository;

    public FarmerService(FarmerMapper farmerMapper, FarmerRepository farmerRepository, DistrictRepository districtRepository) {
        this.farmerMapper = farmerMapper;
        this.farmerRepository = farmerRepository;
        this.districtRepository = districtRepository;
    }

    public List<Farmer> findAllFarmers() {
        return farmerRepository.findAll();
    }


    public void addFarmer(Farmer farmer) {
        farmerRepository.save(farmer);
    }

    public Farmer findFarmerById(Long id) {
        //TODO catch exceptions
        return farmerRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void archiveFarmerById(Long id) {
        //TODO catch exceptions
        Farmer farmerToArchive = farmerRepository.findById(id)
                .orElseThrow();
        farmerToArchive.setArchived(true);
        farmerRepository.save(farmerToArchive);
    }

    @Transactional
    public void updateFarmerInfo(Long id, FarmerDto farmerUpdatesDto) {
        //TODO catch exceptions
        Farmer farmerToChange = farmerRepository.findById(id)
                .orElseThrow();
        farmerMapper.updateFarmerByNotNullFieldsOfFarmerDto(farmerToChange, farmerUpdatesDto);
        farmerRepository.save(farmerToChange);
    }

    public void addNewDistrictFieldToFarmerByDistrictName(String additionalDistrictName, Long farmerId) {
        //TODO catch exceptions
        District district = districtRepository.findByDistrictName(additionalDistrictName);
        Farmer farmerToAddFieldDistrict = farmerRepository.findById(farmerId).orElseThrow();
        farmerToAddFieldDistrict.addNewFieldDistrict(district);
    }

    public List<Farmer> findFarmersRegistryWithFilters(FarmerFilter farmerFilter) {
        //TODO catch exceptions
        Specification<Farmer> specification = FarmerSpecification.getSpecification(farmerFilter);
        return farmerRepository.findAll(specification);
    }
}
