package kz.aitu.assign_4.services;

import kz.aitu.assign_4.models.UserModel;
import kz.aitu.assign_4.repositories.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiece {

    private final UserRepository userRepository;

    public UserServiece(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel registerUser(String login,String password,String email){
        if(login == null && password == null){
            return null;
        }else {
            if(userRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Dublicate Login");
                return null;
            }
            UserModel userModel = new UserModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setEmail(email);
            return userRepository.save(userModel);
        }
    }
    public UserModel authenticate(String login, String password){
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
