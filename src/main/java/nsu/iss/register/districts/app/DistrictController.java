package nsu.iss.register.districts.app;

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
public class DistrictController {


    private final DistrictService districtService;

    private final DistrictMapper districtMapper;
    private final NewDistrictMapper newDistrictMapper;


    @GetMapping("/all")
    public List<DistrictDto> findAllDistricts(){
        return districtService.findAllDistricts()
                .stream()
                .map(districtMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/registry")
    @ResponseStatus(HttpStatus.OK)
    public List<DistrictDto> getRegistry(@ModelAttribute DistrictFilter districtFilter){
        return districtService.findDistrictsRegistryWithFilters(districtFilter)
                .stream()
                .map(districtMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewDistrict(@RequestBody DistrictCreationDto newDistrictDto){
        District newDistrict = newDistrictMapper.toEntity(newDistrictDto);
        districtService.save(newDistrict);
    }

    @PutMapping("/archive/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void ArchiveDistrict(@PathVariable Long id){
        districtService.archiveDistrictById(id);
    }


    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDistrict(@PathVariable Long id, @RequestBody DistrictDto districtDto){
        districtService.updateDistrict(id, districtDto);
    }
}
