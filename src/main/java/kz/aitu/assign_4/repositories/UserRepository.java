package kz.aitu.assign_4.repositories;

import kz.aitu.assign_4.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<UserModel,Integer> {
    Optional<UserModel> findByLoginAndPassword(String login,String password);
    Optional<UserModel> findFirstByLogin(String login);
}
