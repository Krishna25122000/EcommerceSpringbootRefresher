package SpringbootRefresher.SpringbootRefresher.user;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootRefresher.SpringbootRefresher.user.dto.UserRequest;
import SpringbootRefresher.SpringbootRefresher.user.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<UserResponse> FetchAllUsers(){
        List<UserResponse> allUsers = userService.fetchUsers();

        return allUsers;
    }

    @PostMapping()
    public User CreateUser(@Valid @RequestBody UserRequest request){
        User createdUser = userService.createUser(request);
        return createdUser;
    }
    @PutMapping("/{id}")
    public User ModifyUser(@Valid @RequestBody UserRequest request, @PathVariable Long id) {
        User modifiedUser = userService.modifyUser(request, id);
        return modifiedUser;
    }
    @PatchMapping("/{id}")
    public User UpdateUser(@Valid @RequestBody UserRequest request, @PathVariable Long id){
        User updatedUser = userService.updateUser( id,request );
        return updatedUser;
    }
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Long id){
        User deletedUser = userService.deleteUser(id);
        return deletedUser;
    }


}