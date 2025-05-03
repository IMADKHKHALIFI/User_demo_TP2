package net.imad.user_demo_tp2.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.imad.user_demo_tp2.Repositories.UserRepositorey;
import net.imad.user_demo_tp2.Repositories.RoleRepositorey;
import net.imad.user_demo_tp2.entities.Role;
import net.imad.user_demo_tp2.entities.User;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepositorey userRepositorey;
    private RoleRepositorey roleRepositorey;



    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        //user.setPassword();
        return userRepositorey.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepositorey.save(role);
    }

    @Override
    public User findUserByUserName(String UserName) {
        return userRepositorey.findByUserName(UserName);
    }

    @Override
    public Role findRoleByRoleName(String RoleName) {
        return roleRepositorey.findByRoleName(RoleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user =  findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles() != null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepositorey.save(user);
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepositorey.findByUserName(username);
        if(user == null) throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}
