/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.song.model.Song;
import com.example.song.service.SongH2Service;

@RestController
public class SongController{

    @Autowired
    public SongH2Service songH2Service;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs(){
        return songH2Service.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId")int songId){
        return songH2Service.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songH2Service.addSong(song);
    }

    @PutMapping("/songs/{songid}")
    public Song updateSong(@PathVariable("songId") int songId,@RequestBody Song song){
        return songH2Service.updateSong(songId,song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId){
        songH2Service.deleteSong(songId);
    }

    
}
