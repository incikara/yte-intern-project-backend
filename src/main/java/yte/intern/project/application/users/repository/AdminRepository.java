package yte.intern.project.application.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.project.application.users.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
