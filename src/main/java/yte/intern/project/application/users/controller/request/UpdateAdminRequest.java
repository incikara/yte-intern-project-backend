package yte.intern.project.application.users.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@RequiredArgsConstructor
@Getter
@ToString
public class UpdateAdminRequest {

    private final String name;
    private final String surname;
    private final String email;
    private final String password;

    public Admin toEntity() {
        return new Admin(name, surname, email, password);
    }
}
