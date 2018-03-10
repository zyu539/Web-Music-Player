package com.example.player.web.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.player.constants.GeneralConstants;
import com.example.player.web.exceptions.ResourceNotFoundException;
import com.example.player.web.repository.SongRepository;
import com.example.player.web.model.Song;

@Controller
@SessionAttributes(GeneralConstants.ID_SESSION_ACCOUNT)
public class PlayerController {
	
	@Autowired
    SongRepository songRepository;

	@PostMapping("/songs/save")
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
	
	
	@GetMapping("/")
	@ResponseBody
	public String name(@RequestParam(name="username", required=false, defaultValue="ZY God") String name) {
		return "Hello " + name;
	}
}
