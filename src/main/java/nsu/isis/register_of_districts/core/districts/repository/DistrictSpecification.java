package nsu.isis.register_of_districts.core.districts.repository;

import jakarta.persistence.criteria.Predicate;
import nsu.isis.register_of_districts.core.districts.repository.DistrictFilter;
import nsu.isis.register_of_districts.domain.District;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DistrictSpecification {

    public static Specification<District> getSpecification(DistrictFilter districtFilter){
        return ((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (districtFilter.getDistrictName() != null && !districtFilter.getDistrictName().isEmpty()){
                predicates.add(builder.like(builder.lower(root.get("districtName")), "%" + districtFilter.getDistrictName().toLowerCase() + "%"));
            }
            if (districtFilter.getDistrictCode() != null){
                predicates.add(builder.equal((root.get("districtCode")), districtFilter.getDistrictCode()));
            }
            predicates.add(builder.isFalse(root.get("isArchived")));
            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }

}
