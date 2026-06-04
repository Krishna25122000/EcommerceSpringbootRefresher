Spring Security Creation Steps
✅ Create SecurityConfig --> which endpoints are public and protected 
✅ Create RegisterRequest --> this is Dto
✅ Create LoginRequest --> This is dto
✅ Create AuthResponse --> dto 
✅ Create AuthController --> signup, login request reaches this controller first 
✅ Create AuthService --> request received by the AuthService for signup & login logic 
✅ Create AuthServiceImpl --> actual signup/login (business logic)
✅ Create JwtService --> responsible for jwt token creation and validation signature
✅ Create JwtAuthFilter --> intercept the http request validate request and set security context