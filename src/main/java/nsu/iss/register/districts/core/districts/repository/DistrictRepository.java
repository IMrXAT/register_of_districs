package nsu.iss.register.districts.core.districts.repository;

import nsu.iss.register.districts.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>, JpaSpecificationExecutor<District> {
    District findByDistrictName(String registerDistrict);

    District findAllByDistrictName(String districtName);
}
