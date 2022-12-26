package api.swagger.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.swagger.demo.model.User;
import api.swagger.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User getUserByUserId(String userId){
        return repository.findById(userId).get();
    }

    public User updateUser(User userRequest){
        User existingUser = repository.findById(userRequest.getUserId()).get();
        existingUser.setName(userRequest.getName());
        existingUser.setPassword(userRequest.getPassword());

        return repository.save(existingUser);
    }

    public String deleteUser(String userId){
        repository.deleteById(userId);
        return userId+" user deleted sucess! ";
    }
}
