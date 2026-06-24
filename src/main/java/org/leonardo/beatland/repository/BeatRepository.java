package org.leonardo.beatland.repository;

import org.leonardo.beatland.entity.Beat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeatRepository extends JpaRepository<Beat, Long> {
}
