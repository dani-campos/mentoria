package br.com.dani.mentoria_pp.service;

import br.com.dani.mentoria_pp.dto.OfficeDto;
import br.com.dani.mentoria_pp.model.Office;
import br.com.dani.mentoria_pp.repository.OfficeRepository;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public void createOffice(OfficeDto officeDto){
        var officeEntity = new Office(
                officeDto.getDescription(),
                officeDto.getOfficeName()
        );

        officeRepository.save(officeEntity);
    }
}
