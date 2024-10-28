package noxxit.mongoapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noxxit.mongoapplication.model.User;
import noxxit.mongoapplication.repository.UserRepository;

@Service
public class UserService {

    @Autowired 
    private UserRepository repo;
    
    public List<User> findAll() {
        return repo.findAll();
    }
}
