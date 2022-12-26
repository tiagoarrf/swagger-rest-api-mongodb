package api.swagger.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import api.swagger.demo.model.User;

public interface UserRepository extends MongoRepository<User,String> {

}
