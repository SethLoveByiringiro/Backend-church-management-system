package com.Church.ChurchMgtSystem.controller;

import com.Church.ChurchMgtSystem.model.Video;
import com.Church.ChurchMgtSystem.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VideoController {
    @Autowired
    private VideoRepo videoRepo;

    @PostMapping("/video")
    public Video createVideo(@RequestBody Video newVideo) {
        return videoRepo.save(newVideo);
    }

    @GetMapping("/videos")
    public List<Video> getAllVideos() {
        return videoRepo.findAll();
    }

    @GetMapping("/video/{id}")
    public Optional<Video> getVideoById(@PathVariable int id) {
        return videoRepo.findById(id);
    }

    @PutMapping("/video/{id}")
    public Video updateVideo(@PathVariable int id, @RequestBody Video updatedVideo) {
        return videoRepo.findById(id)
                .map(video -> {
                    video.setVideo_name(updatedVideo.getVideo_name());
                    video.setVideo_title(updatedVideo.getVideo_title());
                    return videoRepo.save(video);
                })
                .orElseGet(() -> {
                    updatedVideo.setId(id);
                    return videoRepo.save(updatedVideo);
                });
    }

    @DeleteMapping("/video/{id}")
    public void deleteVideo(@PathVariable int id) {
        videoRepo.deleteById(id);
    }
}
