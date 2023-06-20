package nsu.isis.register_of_districts.app;

import nsu.isis.register_of_districts.core.districts.repository.DistrictFilter;
import nsu.isis.register_of_districts.core.districts.existed_district.DistrictDto;
import nsu.isis.register_of_districts.core.districts.new_district.NewDistrictDto;
import nsu.isis.register_of_districts.core.districts.existed_district.DistrictMapper;
import nsu.isis.register_of_districts.core.districts.DistrictService;
import nsu.isis.register_of_districts.core.districts.new_district.NewDistrictMapper;
import nsu.isis.register_of_districts.domain.District;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/districts")
public class districtController {


    private final DistrictService districtService;

    private final DistrictMapper districtMapper;
    private final NewDistrictMapper newDistrictMapper;


    public districtController(DistrictService districtService, DistrictMapper modelMapper, NewDistrictMapper newDistrictMapper) {
        this.districtService = districtService;
        this.districtMapper = modelMapper;
        this.newDistrictMapper = newDistrictMapper;
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<DistrictDto> allDistricts = districtService.findAllDistricts()
                .stream()
                .map(districtMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(allDistricts, HttpStatus.OK);
    }

    @GetMapping("/registry")
    public ResponseEntity<?> getRegistry(@ModelAttribute DistrictFilter districtFilter){
        List<DistrictDto> allDistricts = districtService.findDistrictsRegistryWithFilters(districtFilter)
                .stream()
                .map(districtMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(allDistricts, HttpStatus.OK);
    }

    @PostMapping("/new-district")
    public ResponseEntity<Void> addNewDistrict(@RequestBody NewDistrictDto newDistrictDto){

        District newDistrict = newDistrictMapper.toEntity(newDistrictDto);
        System.out.println(newDistrict);
        districtService.save(newDistrict);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/to-archive/{id}")
    public ResponseEntity<?> ArchiveDistrict(@PathVariable Long id){
        districtService.archiveDistrictById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/update-district/{id}")
    public ResponseEntity<?> updateDistrict(@PathVariable Long id, @RequestBody DistrictDto districtDto){
        districtService.updateDistrict(id, districtDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
