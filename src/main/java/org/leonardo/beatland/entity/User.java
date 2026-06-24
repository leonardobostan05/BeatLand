package org.leonardo.beatland.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")


public class User {

    // Rollen, welche ein User einnehmen kann
    // (Produzent, Käufer, oder auch beides: denn beide können theoretisch beides tuhen)

    public enum Role {

        PRODUCER,
        BUYER,
        BOTH

    }

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;


    //Getter & Setter Methoden

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
