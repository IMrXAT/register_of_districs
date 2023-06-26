package nsu.iss.register.districts.core.farmers.repository;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import nsu.iss.register.districts.domain.Farmer;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FarmerSpecification {

    public static Specification<Farmer> getSpecification(FarmerFilter farmerFilter){
        return ((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (farmerFilter.getFarmerName().isBlank()){
                predicates.add(builder.like(builder.lower(root.get("farmerName")), "%" + farmerFilter.getFarmerName().toLowerCase() + "%"));
            }
            if (farmerFilter.getFarmerRegistrationDistrictName().isBlank()){
                predicates.add(builder.equal((root.get("registrationDistrict").get("districtName")), farmerFilter.getFarmerRegistrationDistrictName()));
            }
            if(farmerFilter.getINN().isBlank()){
                predicates.add(builder.equal(builder.lower(root.get("INN")), "%" + farmerFilter.getINN() + "%"));
            }
            if(farmerFilter.getStartRegistrationDate() != null){
                Path<LocalDate> registrationDate = root.get("registrationDate");
                predicates.add(builder.greaterThan(registrationDate, farmerFilter.getStartRegistrationDate()));
            }
            if(farmerFilter.getEndRegistrationDate() != null){
                Path<LocalDate> registrationDate = root.get("registrationDate");
                predicates.add(builder.lessThan(registrationDate, farmerFilter.getEndRegistrationDate()));
            }
            predicates.add(builder.isFalse(root.get("isArchived")));
            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }
}

