package nsu.isis.register_of_districts.core.districts.repository;

import jakarta.persistence.criteria.Predicate;
import nsu.isis.register_of_districts.domain.District;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>, JpaSpecificationExecutor<District> {
//    List<District> findAllByIsArchivedIsFalse(Specification<District> specification);

}
