package net.imad.user_demo_tp2.services;
// la couche metier !!!!


import net.imad.user_demo_tp2.entities.User;
import net.imad.user_demo_tp2.entities.Role;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String UserName);
    Role findRoleByRoleName(String RoleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String username, String password);
}
