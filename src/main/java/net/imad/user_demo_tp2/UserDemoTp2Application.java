package net.imad.user_demo_tp2;

import net.imad.user_demo_tp2.entities.Role;
import net.imad.user_demo_tp2.entities.User;
import net.imad.user_demo_tp2.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UserDemoTp2Application {

    public static void main(String[] args) {
        SpringApplication.run(UserDemoTp2Application.class, args);
    }

    @Bean  //chaque methide BEAN s'execute au demarage de lapplication
    CommandLineRunner start(UserService userService){
        return args -> {
            User u1 = new User();
            u1.setUserName("IMAD");
            u1.setPassword("123456"); //des otiles pour le hachage exemple de BCrypt !!!!
            userService.addNewUser(u1);


            User u2 = new User();
            u2.setUserName("admin");
            u2.setPassword("123456"); //des otiles pour le hachage exemple de BCrypt !!!!
            userService.addNewUser(u2);


            Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
                Role r1 = new Role();
                r1.setRoleName(r);
                r1.setDesc("Student role");
                userService.addNewRole(r1);

            });

            userService.addRoleToUser("IMAD", "STUDENT");
            userService.addRoleToUser("IMAD", "USER");
            userService.addRoleToUser("admin", "ADMIN");
            userService.addRoleToUser("admin", "USER");


        //Methode pour authontifier un utilisateur
        try{
            User user = userService.authenticate("IMAD", "123456");
            System.out.println("User authenticated : " + user.getUserName()
                    + "id : " + user.getUserId()
                    + "roles : ==> "
            );
            user.getRoles().forEach(
                    r -> {System.out.println("Role ==>" + r.toString());
                    });

        }
        catch (Exception e){
            e.printStackTrace();
        }
        };
    }
}
