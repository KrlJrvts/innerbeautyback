package com.example.innerbeautyback.business.users;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {


    @Resource
    private UsersService usersService;


    @PostMapping("/user/register")
    @Operation(summary = "Register new user by email, password, firstName, lastName", description = """
            User enters email, password, firstName, lastName. And will get automatically userId, roleName,
            status. System also checks if email is already in use. If it is, error with errorCode 112 is thrown""")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User registration completed successfully!"), @ApiResponse(responseCode = "403", description = "Email already in use")})
    public void addUser(@RequestBody UserRequest userRequest) {
        usersService.addUser(userRequest);
    }


    @PutMapping("/user/edit")
    @Operation(summary = "Edit user by password, image", description = """
               User enters password, password confirmaltion and/or new image. And will update named fields in database.
            """)
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User edit completed successfully!"), @ApiResponse(responseCode = "403", description = "Profile edit failed!")})
    public void editUser(@RequestParam Integer userId, @RequestBody UserEditRequest userEditRequest) {
        usersService.editUser(userId, userEditRequest);
    }
}