package nsu.iss.register.districts.app;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import nsu.iss.register.districts.core.districts.DistrictService;
import nsu.iss.register.districts.core.districts.dto.DistrictDto;
import nsu.iss.register.districts.core.districts.mapper.NewDistrictMapper;
import nsu.iss.register.districts.core.districts.repository.DistrictFilter;
import nsu.iss.register.districts.core.districts.dto.DistrictCreationDto;
import nsu.iss.register.districts.core.districts.mapper.DistrictMapper;
import nsu.iss.register.districts.domain.District;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/districts")
@AllArgsConstructor
@Tag(name = "Районы", description = "запросы для взаимодействия с реестром районов")
public class DistrictController {


    private final DistrictService districtService;

    private final DistrictMapper districtMapper;
    private final NewDistrictMapper newDistrictMapper;


    @GetMapping("/all")
    @Operation(summary = "Возвращает список всех районов, включая архивные")
    @ResponseStatus(HttpStatus.OK)
    public List<DistrictDto> findAllDistricts(){
        return districtService.findAllDistricts()
                .stream()
                .map(districtMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/registry")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Возвращает реестр районов, подходящих под фильтр")
    public List<DistrictDto> getRegistry(@ModelAttribute DistrictFilter districtFilter){
        if (districtFilter == null){
            districtFilter = new DistrictFilter();
        }
        return districtService.findDistrictsRegistryWithFilters(districtFilter)
                .stream()
                .map(districtMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "добавление района")
    public void addNewDistrict(@RequestBody DistrictCreationDto newDistrictDto){
        District newDistrict = newDistrictMapper.toEntity(newDistrictDto);
        districtService.save(newDistrict);
    }

    @PutMapping("/archive/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "отправляет район в архив по заданному id")
    public void ArchiveDistrict(@PathVariable Long id){
        districtService.archiveDistrictById(id);
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "изменяет данные района")
    @ResponseStatus(HttpStatus.OK)
    public void updateDistrict(@PathVariable Long id, @RequestBody DistrictDto districtDto){
        districtService.updateDistrict(id, districtDto);
    }
}
