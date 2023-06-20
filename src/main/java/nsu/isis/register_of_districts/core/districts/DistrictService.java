package nsu.isis.register_of_districts.core.districts;

import jakarta.transaction.Transactional;
import nsu.isis.register_of_districts.core.districts.exception.DistrictException;
import nsu.isis.register_of_districts.core.districts.exception.DistrictNotFoundException;
import nsu.isis.register_of_districts.core.districts.existed_district.DistrictDto;
import nsu.isis.register_of_districts.core.districts.repository.DistrictFilter;
import nsu.isis.register_of_districts.core.districts.repository.DistrictRepository;
import nsu.isis.register_of_districts.core.districts.repository.DistrictSpecification;
import nsu.isis.register_of_districts.domain.District;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DistrictService {

    private final DistrictRepository districtRepository;


    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<District> findAllDistricts() {
        return districtRepository.findAll();
    }

    public List<District> findDistrictsRegistryWithFilters(DistrictFilter districtFilter){
        Specification<District> specification = DistrictSpecification.getSpecification(districtFilter);
        return districtRepository.findAll(specification);
    }


    public void save(District newDistrict) {
        newDistrict.setIsArchived(false);
        districtRepository.save(newDistrict);
    }

    @Transactional
    public void updateDistrict(Long id, DistrictDto districtDto) {
        District districtToChange = districtRepository.findById(id)
                .orElseThrow(() -> new DistrictNotFoundException("District with id " + id + " not found"));

        districtToChange.setDistrictName(districtDto.getDistrictName());
        districtToChange.setDistrictCode(districtDto.getDistrictCode());
        districtRepository.save(districtToChange);
    }

    @Transactional
    public void archiveDistrictById(Long id) {
        District districtToArchive = districtRepository.findById(id)
                .orElseThrow(() -> new DistrictNotFoundException("District with id " + id + " not found"));
        districtToArchive.setIsArchived(true);
        districtRepository.save(districtToArchive);
    }
}
