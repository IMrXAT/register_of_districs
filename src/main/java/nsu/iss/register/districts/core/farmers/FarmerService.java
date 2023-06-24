package nsu.iss.register.districts.core.farmers;

import nsu.iss.register.districts.core.farmers.dto.FarmerDto;
import nsu.iss.register.districts.core.farmers.repository.FarmerRepository;
import nsu.iss.register.districts.domain.Farmer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public List<Farmer> findAllFarmers() {
        return farmerRepository.findAll();
    }


    public void addFarmer(Farmer farmer) {
        farmerRepository.save(farmer);
    }

    public Farmer findFarmerById(Long id) {
        return farmerRepository.findById(id).orElseThrow();
    }
}
