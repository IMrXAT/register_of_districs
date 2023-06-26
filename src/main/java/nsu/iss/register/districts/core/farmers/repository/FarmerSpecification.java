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
            if (farmerFilter.getOrganizationName() != null && farmerFilter.getOrganizationName().isEmpty() ){
                predicates.add(builder.like(builder.lower(root.get("farmerName")), "%" + farmerFilter.getOrganizationName().toLowerCase() + "%"));
            }
            if (farmerFilter.getFarmerRegistrationDistrictName() != null && !farmerFilter.getFarmerRegistrationDistrictName().isEmpty()){
                predicates.add(builder.equal((root.get("registerDistrict").get("districtName")), farmerFilter.getFarmerRegistrationDistrictName()));
            }
            if(farmerFilter.getINN() != null && !farmerFilter.getINN().isEmpty()){
                predicates.add(builder.equal(builder.lower(root.get("INN")), "%" + farmerFilter.getINN() + "%"));
            }
            if(farmerFilter.getEndRegistrationDate() != null){
                Path<LocalDate> registrationDate = root.get("registrationDate");
                predicates.add(builder.greaterThan(registrationDate, farmerFilter.getStartRegistrationDate()));
            }
            if(farmerFilter.getStartRegistrationDate() != null){
                Path<LocalDate> registrationDate = root.get("registrationDate");
                predicates.add(builder.lessThan(registrationDate, farmerFilter.getEndRegistrationDate()));
            }

            predicates.add(builder.isFalse(root.get("isArchived")));
            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }
}

