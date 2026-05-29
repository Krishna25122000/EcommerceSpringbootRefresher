package SpringbootRefresher.SpringbootRefresher.user;

import java.util.List;

import org.springframework.stereotype.Service;

import SpringbootRefresher.SpringbootRefresher.user.dto.UserRequest;
import SpringbootRefresher.SpringbootRefresher.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    // Fetch all users 
    @Override
    public List<UserResponse> fetchUsers(){
        List<User> users =  userRepository.findAll();

        List<UserResponse> userResponse = users.stream()
        .map(user-> new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole()
            ))
        .toList();
        
        return userResponse;
        
    }

    @Override
    public User createUser(UserRequest request){

       User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        return user;
    }

    @Override
    public User modifyUser(UserRequest request,Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(request.getName()); 
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        return user;
    }
    @Override
    public User updateUser(Long id, UserRequest request){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        // at this point i need to check what fields i am getting here 
        if(request.getName()!= null)
            user.setName(request.getName());
        if(request.getEmail()!=null)
            user.setEmail(request.getEmail());
        if(request.getPassword()!=null)
            user.setPassword(request.getPassword());
        userRepository.save(user);

        return user;
    }
    @Override
    public User deleteUser(Long id){

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
        log.info("User deleted successfully");

        return user;
    }
//  need to replace int with integer because int changes to '0' but integer does not changes to 0 instead in nullz
}
