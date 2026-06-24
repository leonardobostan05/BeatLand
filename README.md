# BeatLand

BeatLand is a prototype of a digital production marketplace where music producers
can license and sell their instrumentals to artists, creators and major labels.

## Motivation

My biggest passion is making music as a music producer. Since a few years I am a 
self-employed producer and I work with artists and major labels all over the world.
Before I made myself a name in the scene, I was selling my compositions online and
I always wondered, how it works behind the scenes. Since I got the knowledge and tools
to do it myself, I decided to give it a try and create a marketplace prototype.

## Features

- Create a User with personal information (username, email, password)
- Upload beats with metadata (BPM, key, genre, mood, tags)
- Create reusable license templates (MP3, WAV, STEMS, EXCLUSIVE)
- Perform purchases with automatic availability management

## Tech Stack

- Java (Spring Boot)
- PostgreSQL
- JPA/Hibernate

## Architecture

This project follows a layered architecture:
- Entity: JPA-mapped database models
- Repository: data access layer via Spring Data JPA
- Service: business logic layer
- Controller: REST API layer (HTTP request handling)

## API Endpoints

| Method | Endpoint         | Description                        |
|--------|------------------|------------------------------------|
| GET    | /users           | Get all users                      |
| POST   | /users           | Create a new user                  |
| DELETE | /users/{id}      | Delete a user by ID                |
| GET    | /beats           | Get all beats                      |
| POST   | /beats           | Upload a new beat                  |
| DELETE | /beats/{id}      | Delete a beat by ID                |
| GET    | /licenses        | Get all license templates          |
| POST   | /licenses        | Create a new license template      |
| DELETE | /licenses/{id}   | Delete a license template by ID    |
| GET    | /purchases       | Get all purchases                  |
| POST   | /purchases       | Create a new purchase              |
| DELETE | /purchases/{id}  | Delete a purchase by ID            |

## Data Model

Currently there are 4 entities: User, Beat, Purchase & LicenseTemplate.
A User can upload multiple beats, but a specific beat has only one "Owner" (1:n).
A Beat can have multiple licenses, and multiple licenses can be added to a beat (n:m).
A User can purchase multiple beats and multiple beats can be purchased by multiple Users (n:m).
If a Beat is purchased with the exclusive license, the beat is taken down from the marketplace.



## Business Logic

**Exclusive Purchase Protection:**
When a beat is purchased with an EXCLUSIVE license, BeatLand automatically
marks the beat as unavailable, preventing any future purchases by other users.

**License Tiers:**
BeatLand supports 4 license types with increasing rights and price points:
- MP3: basic non-exclusive license, lowest price
- WAV: higher audio quality, non-exclusive
- STEMS: access to individual tracks, non-exclusive
- EXCLUSIVE: full rights transfer, beat removed from marketplace after purchase

**Automatic Timestamps:**
All entities (users, beats, purchases) automatically record their creation time,
providing a full audit trail of marketplace activity.

**Entity Validation:**
Before processing a purchase, BeatLand verifies that the beat, buyer and license
actually exist in the database, preventing invalid transactions.

## Limitations & Next Steps

- be able to upload real mp3/wav. files
- add collaborators to a single beat with percentage splits
- manage and sell stems separately
- offer free downloads with producer tag protection
- set a beats as public or private
- schedule beat releases in advance

## Status

✅ MVP Complete — v1.0.0