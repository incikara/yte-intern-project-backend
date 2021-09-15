package yte.intern.project.application.users.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.intern.project.application.users.entity.Users;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@ToString
public class UpdateUsersRequest {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final String tc;
    private final LocalDate date;
    private final String phone;

    public Users toEntity() {
        return new Users(name, surname, email, password, tc, date, phone);
    }
}

