package mumsched.services;

import mumsched.domain.User;
import mumsched.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(String username, String password){
        User obj = new User(username, password);
        userRepository.save(obj);

        return obj;
    }
}
