package com.campuslands.southpark.controller;

import com.campuslands.southpark.model.Episode;
import com.campuslands.southpark.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {
    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/{id}")
    public Episode getEpisodeById(@PathVariable int id) {
        return episodeService.getEpisodeById(id);
    }
}
