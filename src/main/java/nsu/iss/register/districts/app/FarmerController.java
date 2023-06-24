package nsu.iss.register.districts.app;

import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.farmers.dto.FarmerCreationDto;
import nsu.iss.register.districts.core.farmers.dto.FarmerDto;
import nsu.iss.register.districts.core.farmers.mapper.FarmerCreationMapper;
import nsu.iss.register.districts.core.farmers.mapper.FarmerMapper;
import nsu.iss.register.districts.domain.Farmer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import nsu.iss.register.districts.core.farmers.FarmerService;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    private final FarmerService farmerService;
    private final FarmerMapper farmerMapper;
    private final FarmerCreationMapper farmerCreationMapper;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<FarmerDto> findAllFarmers(){
        return farmerService.findAllFarmers()
                .stream()
                .map(farmerMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public FarmerDto findFarmerById(@PathVariable Long id){
        Farmer farmer = farmerService.findFarmerById(id);
        return farmerMapper.toDto(farmer);
    }

    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFarmer(@RequestBody FarmerCreationDto farmerCreationDto){
        Farmer farmer = farmerCreationMapper.toEntity(farmerCreationDto);
        farmerService.addFarmer(farmer);
    }

}
