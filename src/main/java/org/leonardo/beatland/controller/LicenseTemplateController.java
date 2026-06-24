package org.leonardo.beatland.controller;


import org.leonardo.beatland.entity.LicenseTemplate;
import org.leonardo.beatland.service.LicenseTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicenseTemplateController {

    @Autowired
    private LicenseTemplateService licenseTemplateService;

    @GetMapping
    public List<LicenseTemplate> getAllLicenses(){
        return licenseTemplateService.getAllLicenses();
    }

    @PostMapping
    public LicenseTemplate createLicense(@RequestBody LicenseTemplate licenseTemplate){
        return licenseTemplateService.createLicense(licenseTemplate);
    }

    @DeleteMapping("/{id}")
    public void deleteLicense(@PathVariable Long id){
        licenseTemplateService.deleteLicense(id);
    }

}
