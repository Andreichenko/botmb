package org.caller.botmb.repository;

import org.caller.botmb.model.Attack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttackRepository extends JpaRepository<Attack, Long> {
}
