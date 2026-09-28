package SpringbootRefresher.SpringbootRefresher.auth;

import SpringbootRefresher.SpringbootRefresher.auth.dto.AuthResponse;
import SpringbootRefresher.SpringbootRefresher.auth.dto.LoginRequest;
import SpringbootRefresher.SpringbootRefresher.auth.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}