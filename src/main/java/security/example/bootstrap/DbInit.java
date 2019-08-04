package security.example.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.example.model.user.User;
import security.example.model.user.UserRepository;

import java.util.Arrays;
import java.util.List;


@Service
public class DbInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all users to clear DB
        this.userRepository.deleteAll();

        User user = new User("User", passwordEncoder.encode("User1"), "USER", "");
        User admin = new User("Admin", passwordEncoder.encode("Admin1"), "ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("Manager", passwordEncoder.encode("Manager1"),"MANAGER","ACCESS_TEST1");

        List<User> userList = Arrays.asList(user,admin,manager);

        this.userRepository.saveAll(userList);
    }
}
