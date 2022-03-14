package ma.enset.jpaenset;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;
import ma.enset.jpaenset.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaEnsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEnsetApplication.class, args);
    }


    @Bean  //va s'exécuter au démarrage
    CommandLineRunner start(UserService userService){
        return args -> {
            User user = new User();
            user.setUsername("user1");
            user.setPassword("123456789");
            userService.addNewUser(user);

            User user1 = new User();
            user1.setUsername("admin");
            user1.setPassword("123456789");
            userService.addNewUser(user1);

            Stream.of("STUDENT","USER","ADMIN").forEach(r->{
                Role role1 = new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);
            });

            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","USER");
            userService.addRoleToUser("admin","USER");
            userService.addRoleToUser("admin","ADMIN");

            try {
                User user2 = userService.autheticate("user1","123456789");
                System.out.println(user2.getUserId());
                System.out.println(user2.getUsername());
                System.out.println("roles");
                user2.getRoles().forEach(r->{
                    System.out.println("Role => "+r.toString());
                });
            }catch (Exception e){

            }
        };
    }
}
