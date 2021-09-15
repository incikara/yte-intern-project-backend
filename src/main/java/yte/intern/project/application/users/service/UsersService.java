package yte.intern.project.application.users.service;

import org.springframework.stereotype.Service;
import yte.intern.project.application.common.infomessage.MessageResponse;
import yte.intern.project.application.common.infomessage.MessageType;
import yte.intern.project.application.users.entity.Users;
import yte.intern.project.application.users.repository.UsersRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public MessageResponse addUsers(Users users) {
        usersRepository.save(users);
        return new MessageResponse("Your account is created successfully!", MessageType.SUCCESS);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Transactional
    public MessageResponse updateUser(Long id, Users newUser) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(("This user (id: %s) is not found".formatted(id))));
        user.updateUser(newUser);
        usersRepository.save(user);
        return new MessageResponse("Your information is updated successfully!",MessageType.SUCCESS);
    }

    public MessageResponse deleteUser(Long id) {
        usersRepository.deleteById(id);
        return new MessageResponse("Your account deleted successfully!",MessageType.SUCCESS);
    }
}
