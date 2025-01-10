package com.movieshop.service_authentication.service;

import com.movieshop.service_authentication.models.User;
import com.movieshop.service_authentication.models.UserCredentials;
import com.movieshop.service_authentication.models.UserPrinciple;
import com.movieshop.service_authentication.repository.UserRepository;
import com.movieshop.service_authentication.utils.UserNameTakenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public String saveUser(UserCredentials user){
        Optional<User> exist = Optional.ofNullable(repo.findByUsername(user.getUsername()));
        if(exist.isPresent()){
            throw new UserNameTakenException("Username is already taken.");
        }
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encoder.encode(user.getPassword()));
        repo.save(newUser);
        return "User Registered Successully !!!";
    }

    public String deleteUser(String Id){
        Optional<User> user = repo.findById(Id);
        if(user.isEmpty()){
            return "User Not Found!!!";
        }
        repo.deleteById(Id);

        return "User Deleted!!";
    }

    public List<User> getAll(){
        return repo.findAll();
    }

    public Optional<User> getUserById(String Id){
        Optional<User> user = repo.findById(Id);
        return  user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("User not found !!");
        }
        return new UserPrinciple(user);
    }
}
