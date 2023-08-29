package org.caller.botmb.service;

import org.caller.botmb.model.Attack;
import org.caller.botmb.model.City;
import org.caller.botmb.model.Rocket;
import org.caller.botmb.model.User;
import org.caller.botmb.repository.AttackRepository;
import org.caller.botmb.repository.CityRepository;
import org.caller.botmb.repository.RocketRepository;
import org.caller.botmb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttackService {

    private final AttackRepository attackRepository;
    private final CityRepository cityRepository;
    private final UserRepository userRepository;
    private final RocketRepository rocketRepository;


    @Autowired
    public AttackService(AttackRepository attackRepository, CityRepository cityRepository, UserRepository userRepository, RocketRepository rocketRepository) {
        this.attackRepository = attackRepository;
        this.cityRepository = cityRepository;
        this.userRepository = userRepository;
        this.rocketRepository = rocketRepository;
    }

    public Attack createAttack(Attack attack) {

        return attackRepository.save(attack);
    }

    public Optional<Attack> getAttackById(Long id) {
        return attackRepository.findById(id);
    }

    public List<Attack> getAllAttacks() {
        return attackRepository.findAll();
    }

    public void deleteAttack(Long id) {
        attackRepository.deleteById(id);
    }

    public double calculateDamage(double powerOfAttack, City city, double influenceCoefficient) {
        return (powerOfAttack * city.getPopulationDensity()) * influenceCoefficient;
    }

    public double performAttack(User attacker, City city, Rocket rocket) {
        double powerOfAttack = rocket.getPower();
        double influenceCoefficient = Math.random();

        double damage = calculateDamage(powerOfAttack, city, influenceCoefficient);

        int points = (int) (damage / 100);
        attacker.setPoints(attacker.getPoints() + points);
        userRepository.save(attacker);

        Attack attack = new Attack();
        attack.setAttacker(attacker);
        attack.setCity(city);
        attack.setDamage(damage);
        attackRepository.save(attack);

        return damage;
    }

}
