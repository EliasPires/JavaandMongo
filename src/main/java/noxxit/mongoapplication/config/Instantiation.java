package noxxit.mongoapplication.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import noxxit.mongoapplication.dto.AuthorDTO;
import noxxit.mongoapplication.dto.CommentDTO;
import noxxit.mongoapplication.model.Post;
import noxxit.mongoapplication.model.User;
import noxxit.mongoapplication.repository.PostRepository;
import noxxit.mongoapplication.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        // Limpando as coleções
        userRepository.deleteAll();
        postRepository.deleteAll();

        // Instancia usuários
        User joao = new User(null, "Joao da Silva", "joao.silva2@gmail.com");
        User elias = new User(null, "Elias da Cunha Pires", "elias.cpires@gmail.com");
        User antonio = new User(null, "Antonio Lopes", "anlopes@gmail.com");

        // Salva users no banco de dados
        userRepository.saveAll(Arrays.asList(joao, elias, antonio));

        // Instanciou posts
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(elias));    
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(elias));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(antonio));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(joao));
        CommentDTO c3 = new CommentDTO("TTenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(antonio));


        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        // Salva posts no banco de dados
        postRepository.saveAll(Arrays.asList(post1, post2));

        elias.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(elias);
    }
    
}
