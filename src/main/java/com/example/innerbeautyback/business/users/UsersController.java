package com.example.innerbeautyback.business.users;


import com.example.innerbeautyback.business.users.dto.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {


    @Resource
    private RegisterService registerService;

    @PostMapping("/register")
    @Operation(summary = "Register new user by email, password, firstName, lastName",
            description = """
                    User enters email, password, firstName, lastName. And will get automatically userId, roleName, 
                    status. System also checks if email is already in use. If it is, error with errorCode 112 is thrown""")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Email already in use")})
    public void addUser(@RequestBody UserResponse userResponse) {
        registerService.addUser(userResponse);
    }


}