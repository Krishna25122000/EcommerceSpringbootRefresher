package SpringbootRefresher.SpringbootRefresher.auth;

import SpringbootRefresher.SpringbootRefresher.auth.dto.AuthResponse;
import SpringbootRefresher.SpringbootRefresher.auth.dto.LoginRequest;
import SpringbootRefresher.SpringbootRefresher.auth.dto.RegisterRequest;
import SpringbootRefresher.SpringbootRefresher.config.JwtService;
import SpringbootRefresher.SpringbootRefresher.user.Role;
import SpringbootRefresher.SpringbootRefresher.user.User;
import SpringbootRefresher.SpringbootRefresher.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        // Check duplicate email
        // if (userRepository.findByEmail(request.getEmail())) {
        //     throw new RuntimeException("Email already registered");
        // }

        // Save user with hashed password
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // ✅ hashed
                .role(Role.USER)
                .build();

        userRepository.save(user);

        // Generate token
        String token = jwtService.generateToken(user);
        return new AuthResponse(token,user.getId(), user.getName(), user.getEmail(), user.getRole().name());
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        // ✅ Spring Security verifies email + password automatically
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user.getId(),user.getName(), user.getEmail(), user.getRole().name());
    }
}