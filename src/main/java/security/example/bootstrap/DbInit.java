package security.example.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import security.example.model.user.User;
import security.example.model.user.UserRepository;

import java.util.Arrays;
import java.util.List;


@Service
public class DbInit implements CommandLineRunner {

    private final UserRepository userRepository;

    public DbInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        User user = new User("User", "User1", "USER", "");
        User admin = new User("Admin", "Admin1", "ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("Manager", "Manager1","MANAGER","ACCESS_TEST1");

        List<User> userList = Arrays.asList(user,admin,manager);

        this.userRepository.saveAll(userList);
    }
}
