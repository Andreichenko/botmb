package org.caller.botmb.service;

import org.caller.botmb.model.Attack;
import org.caller.botmb.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttackService {

    private final AttackRepository attackRepository;

    @Autowired
    public AttackService(AttackRepository attackRepository) {
        this.attackRepository = attackRepository;
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

}
