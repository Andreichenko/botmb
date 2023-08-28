package org.caller.botmb.controller;

import org.caller.botmb.model.Attack;
import org.caller.botmb.service.AttackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attacks")
public class AttackController {

    private final AttackService attackService;

    @Autowired
    public AttackController(AttackService attackService) {
        this.attackService = attackService;
    }

    @GetMapping
    public List<Attack> getAllAttacks() {
        return attackService.getAllAttacks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attack> getAttackById(@PathVariable Long id) {
        return attackService.getAttackById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Attack> createAttack(@RequestBody Attack attack) {
        Attack createdAttack = attackService.createAttack(attack);
        return ResponseEntity.ok(createdAttack);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttack(@PathVariable Long id) {
        attackService.deleteAttack(id);
        return ResponseEntity.noContent().build();
    }
}
