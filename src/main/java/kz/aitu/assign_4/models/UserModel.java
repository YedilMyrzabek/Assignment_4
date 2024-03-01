package kz.aitu.assign_4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "users_table")
@Getter@Setter

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String login;
    String password;
    String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(login, userModel.login) && Objects.equals(password, userModel.password) && Objects.equals(email, userModel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
