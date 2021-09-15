package yte.intern.project.application.users.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.intern.project.application.users.entity.Admin;

@RequiredArgsConstructor
@Getter
@ToString
public class AddAdminRequest {

    private final String name;
    private final String surname;
    private final String email;
    private final String password;

    public Admin toEntity() {
        return new Admin(name, surname, email, password);
    }
}
