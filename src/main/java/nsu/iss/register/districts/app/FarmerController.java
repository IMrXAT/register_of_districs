package nsu.iss.register.districts.app;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.farmers.dto.FarmerCreationDto;
import nsu.iss.register.districts.core.farmers.dto.FarmerDto;
import nsu.iss.register.districts.core.farmers.mapper.FarmerCreationMapper;
import nsu.iss.register.districts.core.farmers.mapper.FarmerMapper;
import nsu.iss.register.districts.core.farmers.repository.FarmerFilter;
import nsu.iss.register.districts.domain.Farmer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import nsu.iss.register.districts.core.farmers.FarmerService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/farmers")
@Tag(name = "Фермеры", description = "запросы для взаимодействия с реестром фермеров")

public class FarmerController {

    private final FarmerService farmerService;
    private final FarmerMapper farmerMapper;
    private final FarmerCreationMapper farmerCreationMapper;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Возвращает все записи фермеров, включая архивные")
    public List<FarmerDto> findAllFarmers(){
        return farmerService.findAllFarmers()
                .stream()
                .map(farmerMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/registry")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Возвращает реестр фермеров, подходящих под фильтр")
    public List<FarmerDto> findFarmersRegistryWithFilters(@RequestBody FarmerFilter farmerFilter){
        if (farmerFilter == null){
            farmerFilter = new FarmerFilter();
        }
        return farmerService.findFarmersRegistryWithFilters(farmerFilter)
                .stream()
                .map(farmerMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Возвращает запись фермера по id")
    public FarmerDto findFarmerById(@PathVariable Long id){
        Farmer farmer = farmerService.findFarmerById(id);
        return farmerMapper.toDto(farmer);
    }

    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Добавление нового фермера")
    public void addFarmer(@RequestBody FarmerCreationDto farmerCreationDto){
        Farmer farmer = farmerCreationMapper.toEntity(farmerCreationDto);
        farmerService.addFarmer(farmer);
    }

    @PutMapping("/archive/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Добавление записи фермера в архив")
    public void ArchiveFarmerById(@PathVariable Long id){
        farmerService.archiveFarmerById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Изменение данных фермера")
    public void updateFarmerInfo(@PathVariable Long id, @RequestBody FarmerDto farmerDto){
        farmerService.updateFarmerInfo(id, farmerDto);
    }

    @PutMapping("/new/field/farmer/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Добавление района в котором у фермера есть поле")
    public void addNewDistrictWithFieldToFarmer(@RequestParam String additionalDistrictName, @PathVariable Long id){
        farmerService.addNewDistrictFieldToFarmerByDistrictName(additionalDistrictName, id);
    }


}
