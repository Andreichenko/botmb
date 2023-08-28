package org.caller.botmb.service;

import org.caller.botmb.model.User;
import org.caller.botmb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService {

    private final UserRepository userRepository;

    @Autowired
    public ScoreService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addPoints(Long userId, int points) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPoints(user.getPoints() + points);
            return userRepository.save(user);
        }
        return null;
    }

    public User deductPoints(Long userId, int points) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPoints(user.getPoints() - points);
            return userRepository.save(user);
        }
        return null;
    }

    public int getPoints(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(User::getPoints).orElse(0);
    }
}
