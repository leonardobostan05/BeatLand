package org.leonardo.beatland.controller;

import org.leonardo.beatland.entity.Beat;
import org.leonardo.beatland.service.BeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    // File Upload von Beats
    @PostMapping("/{id}/upload")
    public Beat fileUpload(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file,
            @RequestParam("type") String type){
        return beatService.fileUpload(id, file, type);
    }

    @PostMapping
    public Beat createBeat(@RequestBody Beat beat){
        return beatService.createBeat(beat);
    }

    @DeleteMapping("/{id}")
    public void deleteBeat(@PathVariable Long id){
        beatService.deleteBeat(id);
    }

}
