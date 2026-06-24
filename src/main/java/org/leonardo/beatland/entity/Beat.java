package org.leonardo.beatland.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "beats")


public class Beat {

    public Beat() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beatId;

    // boolean um zu prüfen, ob ein Beat verkauft wurde für die Exclusive-License Logik
    private boolean isAvailable = true;

    private String beatname;
    private String description;
    private String genre;
    private String mood;
    private String key;

    //Extra Datenbank für die Tags: es können maximal 3 vorkommen
    @ElementCollection
    private List<String> tags = new ArrayList<>();

    private int bpm;
    private LocalDateTime uploadedAt;

    //Getter & Setter Methoden

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeatname() {
        return beatname;
    }

    public void setBeatname(String beatname) {
        this.beatname = beatname;
    }

    public Long getBeatId() {
        return beatId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
