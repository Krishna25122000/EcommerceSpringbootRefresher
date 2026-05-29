package SpringbootRefresher.SpringbootRefresher.user;

import java.util.List;

import SpringbootRefresher.SpringbootRefresher.user.dto.UserRequest;
import SpringbootRefresher.SpringbootRefresher.user.dto.UserResponse;

public interface UserService {
    User createUser(UserRequest request);
    User modifyUser(UserRequest request,Long id);
    // UserResponse getUserById(Long id);
    List<UserResponse> fetchUsers();
    User updateUser(Long id, UserRequest request);
    User deleteUser(Long id);
}