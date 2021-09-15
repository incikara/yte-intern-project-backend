package yte.intern.project.application.users.controller;

import org.springframework.web.bind.annotation.*;
import yte.intern.project.application.common.infomessage.MessageResponse;
import yte.intern.project.application.users.controller.request.AddUsersRequest;
import yte.intern.project.application.users.controller.request.UpdateUsersRequest;
import yte.intern.project.application.users.controller.response.UsersQueryResponse;
import yte.intern.project.application.users.entity.Users;
import yte.intern.project.application.users.service.UsersService;


import javax.validation.Valid;
import java.util.List;

@RestController
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<UsersQueryResponse> getAllUsers() {
        return usersService.getAllUsers()
                .stream()
                .map(user -> new UsersQueryResponse(user))
                .toList();
    }

    @PostMapping("/users")
    public MessageResponse addUser(@Valid @RequestBody AddUsersRequest addUsersRequest) {
        Users users = addUsersRequest.toEntity();
        return usersService.addUsers(users);
    }

    @PutMapping("/users/{id}")
    public MessageResponse updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUsersRequest updateUsersRequest) {
        return usersService.updateUser(id, updateUsersRequest.toEntity());
    }

    @DeleteMapping("/users/{id}")
    public MessageResponse deleteUser(@PathVariable Long id) {
        return usersService.deleteUser(id);
    }
}
