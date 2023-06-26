package nsu.iss.register.districts.core.districts.repository;

import jakarta.persistence.criteria.Predicate;
import nsu.iss.register.districts.domain.District;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DistrictSpecification {

    public static Specification<District> getSpecification(DistrictFilter districtFilter){
        return ((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!districtFilter.getDistrictName().isBlank()){
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
