package noxxit.mongoapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noxxit.mongoapplication.model.Post;
import noxxit.mongoapplication.repository.PostRepository;
import noxxit.mongoapplication.service.exception.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
