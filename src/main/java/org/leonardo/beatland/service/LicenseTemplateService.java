package org.leonardo.beatland.service;


import org.leonardo.beatland.entity.LicenseTemplate;
import org.leonardo.beatland.repository.LicenseTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseTemplateService {

    @Autowired
    private LicenseTemplateRepository licenseTemplateRepository;

    public LicenseTemplate createLicense(LicenseTemplate licenseTemplate){
        return licenseTemplateRepository.save(licenseTemplate);
    }

    public List<LicenseTemplate> getAllLicenses(){
        return licenseTemplateRepository.findAll();
    }

    public LicenseTemplate getLicenseById(Long id){
        return licenseTemplateRepository.findById(id).orElse(null);
    }

    public void deleteLicense(Long id){
        licenseTemplateRepository.deleteById(id);
    }

}
