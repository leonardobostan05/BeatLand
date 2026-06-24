package org.leonardo.beatland.service;

import org.leonardo.beatland.entity.Beat;
import org.leonardo.beatland.repository.BeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BeatService {

    @Autowired
    private BeatRepository beatRepository;

    public Beat uploadBeat(Beat beat){
        beat.setUploadedAt(LocalDateTime.now());
        return beatRepository.save(beat);
    }

    public List<Beat> getAllBeats(){
        return beatRepository.findAll();
    }

    public Beat getBeatById(Long id){
        return beatRepository.findById(id).orElse(null);
    }

    public void deleteBeat(Long id){
        beatRepository.deleteById(id);
    }


}
