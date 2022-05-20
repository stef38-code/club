package org.stephane.club.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stephane.club.services.adherent.BrandsService;

import java.util.Map;

@RestController
@RequestMapping("/v1/brands")
public class BrandsApiController extends BaseRestController<BrandsDto, Brands, String, String> {

    public BrandsApiController(BrandsService service) {
        super(service);
    }

    @Override
    @ApiOperation(value = "브랜드 등록", notes = "신규 브랜드를 등록등록합니다.")
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody BrandsDto dto) {
        return super.create(dto.getBrandId(), dto);
    }

    @Override
    @ApiOperation(value = "브랜드 수정", notes = "브랜드를 수정합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "브랜드 ID", required = true, dataType = "string", paramType = "path", defaultValue = ""),
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody BrandsDto dto) {
        return super.update(id, dto);
    }

    @Override
    @ApiOperation(value = "브랜드 조회", notes = "브랜드을 조회합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "브랜드 ID", required = true, dataType = "string", paramType = "path", defaultValue = ""),
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> select(@PathVariable String id) {
        return super.select(id);
    }

    @Override
    @ApiOperation(value = "브랜드 검색", notes = "브랜드를 검색합니다.")
    @GetMapping("/")
    public ResponseEntity<?> search(@RequestParam Map<String, String> params) {
        return super.search(params);
    }
}
