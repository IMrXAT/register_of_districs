package nsu.iss.register.districts.core.farmers;

import jakarta.transaction.Transactional;
import nsu.iss.register.districts.core.districts.exception.DistrictNotFoundException;
import nsu.iss.register.districts.core.districts.repository.DistrictRepository;
import nsu.iss.register.districts.core.farmers.dto.FarmerDto;
import nsu.iss.register.districts.core.farmers.exception.FarmerNotFoundException;
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
        return farmerRepository.findById(id).orElseThrow(() -> new FarmerNotFoundException("farmer with id " + id + " not found"));
    }

    @Transactional
    public void archiveFarmerById(Long id) {
        Farmer farmerToArchive = farmerRepository.findById(id)
                .orElseThrow(() -> new FarmerNotFoundException("could not archive farmer with id " + id + " because farmer not found"));
        farmerToArchive.setArchived(true);
        farmerRepository.save(farmerToArchive);
    }

    @Transactional
    public void updateFarmerInfo(Long id, FarmerDto farmerUpdatesDto) {
        Farmer farmerToChange = farmerRepository.findById(id)
                .orElseThrow(() -> new FarmerNotFoundException("could not update farmer with id " + id + " because farmer not found"));
        farmerMapper.updateFarmerByNotNullFieldsOfFarmerDto(farmerToChange, farmerUpdatesDto);
        farmerRepository.save(farmerToChange);
    }

    @Transactional
    public void addNewDistrictFieldToFarmerByDistrictName(String additionalDistrictName, Long farmerId) {
        District district = districtRepository.findByDistrictName(additionalDistrictName);
        if (district == null){
            throw new DistrictNotFoundException("not found district with name " + additionalDistrictName + " to add it to farmer with id " + farmerId);
        }

        Farmer farmerToAddFieldDistrict = findFarmerById(farmerId);
        farmerToAddFieldDistrict.addNewFieldDistrict(district);
        farmerRepository.save(farmerToAddFieldDistrict);
    }

    public List<Farmer> findFarmersRegistryWithFilters(FarmerFilter farmerFilter) {
        Specification<Farmer> specification = FarmerSpecification.getSpecification(farmerFilter);
        return farmerRepository.findAll(specification);
    }
}
