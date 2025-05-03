package net.imad.user_demo_tp2.Repositories;
//la couche DAO
import net.imad.user_demo_tp2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepositorey extends JpaRepository<net.imad.user_demo_tp2.entities.User, Long> {
    User findByUserName(String userName);

}
