package net.imad.user_demo_tp2.Repositories;

//la couche DAO

import net.imad.user_demo_tp2.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepositorey extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
