package org.leonardo.beatland.repository;

import org.leonardo.beatland.entity.LicenseTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseTemplateRepository extends JpaRepository<LicenseTemplate, Long> {
}
