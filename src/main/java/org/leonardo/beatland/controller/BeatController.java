package org.leonardo.beatland.controller;

import org.leonardo.beatland.entity.Beat;
import org.leonardo.beatland.repository.BeatRepository;
import org.leonardo.beatland.service.BeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beats")
public class BeatController {

    @Autowired
    private BeatService beatService;

    @GetMapping
    public List<Beat> getAllBeats(){
        return beatService.getAllBeats();
    }

    @PostMapping
    public Beat uploadBeat(@RequestBody Beat beat){
        return beatService.uploadBeat(beat);
    }

    @DeleteMapping("/{id}")
    public void deleteBeat(@PathVariable Long id){
        beatService.deleteBeat(id);
    }

}
