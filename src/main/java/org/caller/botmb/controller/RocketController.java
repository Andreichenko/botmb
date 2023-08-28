package org.caller.botmb.controller;


import org.caller.botmb.model.Rocket;
import org.caller.botmb.service.RocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rockets")
public class RocketController {

    private final RocketService rocketService;

    @Autowired
    public RocketController(RocketService rocketService) {
        this.rocketService = rocketService;
    }

    @GetMapping
    public List<Rocket> getAllRockets() {
        return rocketService.getAllRockets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rocket> getRocketById(@PathVariable Long id) {
        return rocketService.getRocketById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rocket> createRocket(@RequestBody Rocket rocket) {
        Rocket createdRocket = rocketService.createRocket(rocket);
        return ResponseEntity.ok(createdRocket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRocket(@PathVariable Long id) {
        rocketService.deleteRocket(id);
        return ResponseEntity.noContent().build();
    }
}
