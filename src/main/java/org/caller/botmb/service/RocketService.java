package org.caller.botmb.service;

import org.caller.botmb.model.Rocket;
import org.caller.botmb.repository.RocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RocketService {

    private final RocketRepository rocketRepository;

    @Autowired
    public RocketService(RocketRepository rocketRepository) {
        this.rocketRepository = rocketRepository;
    }

    public List<Rocket> getAllRockets() {
        return rocketRepository.findAll();
    }

    public Optional<Rocket> getRocketById(Long id) {
        return rocketRepository.findById(id);
    }

    public Rocket createRocket(Rocket rocket) {
        return rocketRepository.save(rocket);
    }

    public void deleteRocket(Long id) {
        rocketRepository.deleteById(id);
    }
}
