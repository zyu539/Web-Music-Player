package com.example.player.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.player.exceptions.ResourceNotFoundException;
import com.example.player.model.Song;
import com.example.player.repository.SongRepository;

@Controller
public class PlayerController {
	
	@Autowired
    SongRepository songRepository;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/songs/save")
	@ResponseBody
	public Song saveSong(@Valid @RequestBody Song song) {
	    return songRepository.save(song);
	}
	
	@GetMapping("/songs/{id}")
	public Song getSongById(@PathVariable(value = "id") Long songId) {
		return songRepository.findById(songId)
	            .orElseThrow(() -> new ResourceNotFoundException("Song", "id", songId));
	}
	
	@GetMapping("/songs")
	public List<Song> getSongs() {
		return songRepository.findAll();
	}
	
	@DeleteMapping("/songs/{id}")
	public ResponseEntity<?> removeSong(@PathVariable(value = "id") Long songId) {
	    Song note = songRepository.findById(songId)
	            .orElseThrow(() -> new ResourceNotFoundException("Song", "id", songId));

	    songRepository.delete(note);

	    return ResponseEntity.ok().build();
	}
}
