package yte.intern.project.application.users.controller;

import org.springframework.web.bind.annotation.*;
import yte.intern.project.application.common.infomessage.MessageResponse;
import yte.intern.project.application.users.controller.request.AddAdminRequest;
import yte.intern.project.application.users.controller.request.UpdateAdminRequest;
import yte.intern.project.application.users.entity.Admin;
import yte.intern.project.application.users.service.AdminService;

import javax.validation.Valid;

@RestController
public class AdminController {

    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin")
    public MessageResponse addAdmin(@Valid @RequestBody AddAdminRequest addAdminRequest) {
        Admin admin = addAdminRequest.toEntity();
        return adminService.addAdmin(admin);
    }

    @PutMapping("/admin/{id}")
    public MessageResponse updateAdmin(@PathVariable Long id, @Valid @RequestBody UpdateAdminRequest updateAdminRequest) {
        return adminService.updateAdmin(id, updateAdminRequest.toEntity());
    }

    @DeleteMapping("/admin/{id}")
    public MessageResponse deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id);
    }
}
