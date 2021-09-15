package yte.intern.project.application.users.entity;

import lombok.Getter;
import yte.intern.project.application.common.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
public class Admin extends BaseEntity {

    private String  name;
    private String surname;
    private String email;
    private String password;

    public Admin(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public void updateAdmin(Admin newAdmin) {
        this.name = newAdmin.getName();
        this.surname = newAdmin.getSurname();
        this.email = newAdmin.getEmail();
        this.password = newAdmin.getPassword();
    }

}
