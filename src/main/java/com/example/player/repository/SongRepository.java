package com.example.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.player.model.Song;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}