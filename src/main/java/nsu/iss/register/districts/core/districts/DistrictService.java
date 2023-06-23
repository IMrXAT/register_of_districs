package nsu.iss.register.districts.core.districts;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.districts.dto.DistrictDto;
import nsu.iss.register.districts.core.districts.repository.DistrictFilter;
import nsu.iss.register.districts.core.districts.exception.DistrictNotFoundException;
import nsu.iss.register.districts.core.districts.repository.DistrictRepository;
import nsu.iss.register.districts.core.districts.repository.DistrictSpecification;
import nsu.iss.register.districts.domain.District;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;


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
