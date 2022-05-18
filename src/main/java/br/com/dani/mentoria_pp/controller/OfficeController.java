package br.com.dani.mentoria_pp.controller;

import br.com.dani.mentoria_pp.dto.OfficeDto;
import br.com.dani.mentoria_pp.service.OfficeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/office")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping
    public ResponseEntity create (@RequestBody OfficeDto officeDto) {
        officeService.createOffice(officeDto);
        return ResponseEntity.ok(Map.of("message", "Create Office"));
    }

}
