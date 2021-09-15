package yte.intern.project.application.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.project.application.users.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
