package yte.intern.project.application.users.controller.response;

import lombok.Getter;
import yte.intern.project.application.users.entity.Users;

import java.time.LocalDate;

@Getter
public class UsersQueryResponse {

    private final Long id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final String tc;
    private final LocalDate date;
    private final String phone;

    public UsersQueryResponse(Users user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.tc = user.getTc();
        this.date = user.getDate();
        this.phone = user.getPhone();
    }
}
