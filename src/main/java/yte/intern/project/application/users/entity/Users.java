package yte.intern.project.application.users.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.project.application.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor
public class Users extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String tc;
    private LocalDate date;
    private String phone;

    public Users(String name, String surname, String email, String password, String tc, LocalDate date, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.tc = tc;
        this.date = date;
        this.phone = phone;
    }

    public void updateUser(Users newUser) {

        this.name = newUser.getName();
        this.surname = newUser.getSurname();
        this.email = newUser.getEmail();
        this.password = newUser.getPassword();
        this.tc = newUser.getTc();
        this.date = newUser.getDate();
        this.phone = newUser.getPhone();
    }
}

