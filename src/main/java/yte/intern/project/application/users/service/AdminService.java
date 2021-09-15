package yte.intern.project.application.users.service;

import org.springframework.stereotype.Service;
import yte.intern.project.application.common.infomessage.MessageResponse;
import yte.intern.project.application.common.infomessage.MessageType;
import yte.intern.project.application.users.entity.Admin;
import yte.intern.project.application.users.repository.AdminRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;


    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Transactional
    public MessageResponse addAdmin(Admin admin) {
        adminRepository.save(admin);
        return new MessageResponse("You are added to the system successfully!", MessageType.SUCCESS);
    }

    @Transactional
    public MessageResponse updateAdmin(Long id, Admin newAdmin) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("This admin (id: %s) is not found".formatted(id)));
        admin.updateAdmin(newAdmin);
        adminRepository.save(admin);
        return new MessageResponse("Your information is updated successfully", MessageType.SUCCESS);
    }

    public MessageResponse deleteAdmin(Long id) {
        adminRepository.deleteById(id);
        return new MessageResponse("You are deleted successfully!", MessageType.SUCCESS);
    }

}
