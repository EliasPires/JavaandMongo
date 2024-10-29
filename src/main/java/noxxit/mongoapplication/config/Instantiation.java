package noxxit.mongoapplication.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import noxxit.mongoapplication.model.User;
import noxxit.mongoapplication.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        
        User joao = new User(null, "Joao da Silva", "joao.silva2@gmail.com");
        User elias = new User(null, "Elias da Cunha Pires", "elias.cpires@gmail.com");
        User antonio = new User(null, "Antonio Lopes", "anlopes@gmail.com");

        userRepository.saveAll(Arrays.asList(joao, elias, antonio));
    }
    
}
