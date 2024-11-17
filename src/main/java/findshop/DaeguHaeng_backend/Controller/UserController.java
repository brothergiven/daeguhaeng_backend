package findshop.DaeguHaeng_backend.Controller;

import findshop.DaeguHaeng_backend.DTO.LoginRequestDTO;
import findshop.DaeguHaeng_backend.DTO.RegisterRequestDTO;
import findshop.DaeguHaeng_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        try {
            userService.register(registerRequestDTO);
            return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("User registration failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try{
            userService.logIn(loginRequestDTO);
            return new ResponseEntity<>("User logged in successfully!", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("User login failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}