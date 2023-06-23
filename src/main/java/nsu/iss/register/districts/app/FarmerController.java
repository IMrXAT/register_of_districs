package nsu.iss.register.districts.app;

import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.farmers.dto.FarmerDto;
import nsu.iss.register.districts.core.farmers.mapper.FarmerMapper;
import org.springframework.web.bind.annotation.*;

import nsu.iss.register.districts.core.farmers.FarmerService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/farmers")
public class FarmerController {

    private final FarmerService farmerService;
    private final FarmerMapper farmerMapper;

    @GetMapping("/all")
    public List<FarmerDto> findAllFarmers(){
        return farmerService.findAllFarmers()
                .stream()
                .map(farmerMapper::toDto)
                .collect(Collectors.toList());
    }


}
