package org.leonardo.beatland.service;

import org.leonardo.beatland.entity.Beat;
import org.leonardo.beatland.repository.BeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.io.IOException;
import java.nio.file.*;

@Service
public class BeatService {

    @Autowired
    private BeatRepository beatRepository;

    public Beat createBeat(Beat beat){
        beat.setUploadedAt(LocalDateTime.now());
        return beatRepository.save(beat);
    }

    public Beat fileUpload(Long id, MultipartFile file, String type){
        Beat beat = beatRepository.findById(id).orElseThrow();

        try{
            // Ordner Logik
            String uploadDir = "uploads/beats/" + id + "/";
            Path uploadPath = Paths.get(uploadDir);
            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }

            // Datei speichern Logik

            String filename = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            //Beatpfad

            String savedPath = uploadDir + filename;
            if (type.equals("mp3")){
                beat.setMp3Path(savedPath);
            }
            else if(type.equals("wav")){
                beat.setWavPath(savedPath);
            }
            else if(type.equals("stems")){
                beat.setStemsPath(savedPath);
            }

            return beatRepository.save(beat);

        } catch (IOException e) {
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }
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
