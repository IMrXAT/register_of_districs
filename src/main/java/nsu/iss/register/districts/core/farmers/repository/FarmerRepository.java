package nsu.iss.register.districts.core.farmers.repository;

import nsu.iss.register.districts.domain.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}
