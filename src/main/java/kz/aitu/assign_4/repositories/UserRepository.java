package kz.aitu.assign_4.repositories;

import kz.aitu.assign_4.models.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    Optional<UserModel> findByLoginAndPassword(String login,String password);
    Optional<UserModel> findFirstByLogin(String login);
}
