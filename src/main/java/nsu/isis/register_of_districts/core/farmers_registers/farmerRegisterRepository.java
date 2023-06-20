package nsu.isis.register_of_districts.core.farmers_registers;

import nsu.isis.register_of_districts.domain.FarmerRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface farmerRegisterRepository extends JpaRepository<FarmerRegister, Long> {
}
