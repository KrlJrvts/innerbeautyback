package com.example.innerbeautyback.business.login;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControllerOrig {

    @Resource
    private LoginService loginService;


    @GetMapping("/login")
    @Operation(summary = "Login function. Returns userId and roleName",
            description = """
                    The system searches for a user with username and password, whose account is also active.
                    If no match is found, an error with errorCode 111 is thrown""")
//    @ApiResponse(value = {
//            @ApiResponse(responseCode = "200", description = "OK"),
//            @ApiResponse(responseCode = "403", description = "Wrong username or password",
//                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LoginResponse login(@RequestParam String email, @RequestParam String password) {
        LoginResponse loginResponse = loginService.login(email, password);
        return loginResponse;
    }
}
