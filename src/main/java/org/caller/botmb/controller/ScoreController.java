package org.caller.botmb.controller;

import org.caller.botmb.model.User;
import org.caller.botmb.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/add/{userId}/{points}")
    public User addPoints(@PathVariable Long userId, @PathVariable int points) {
        return scoreService.addPoints(userId, points);
    }

    @PostMapping("/deduct/{userId}/{points}")
    public User deductPoints(@PathVariable Long userId, @PathVariable int points) {
        return scoreService.deductPoints(userId, points);
    }

    @GetMapping("/balance/{userId}")
    public int getPoints(@PathVariable Long userId) {
        return scoreService.getPoints(userId);
    }

}
