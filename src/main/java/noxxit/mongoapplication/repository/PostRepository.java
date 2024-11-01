package noxxit.mongoapplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import noxxit.mongoapplication.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    
}
