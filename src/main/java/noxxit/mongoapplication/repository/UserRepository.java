package noxxit.mongoapplication.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import noxxit.mongoapplication.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    
}
