package com.wypochodzik.Wypozyczalnia.Controllers;

import com.wypochodzik.Wypozyczalnia.DTO.UserCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UserRestResponseDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UserEntity;
import com.wypochodzik.Wypozyczalnia.Services.users.UsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(value = "api")
public class UsersController {

    private final UsersService usersService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @ApiOperation(value = "Find user by Id", notes = "Provides information about user with given Id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Server malfunction")
    })
    @GetMapping(value = "/users/{userId}")
    public UserRestResponseDTO getUser(@PathVariable Long userId) {

        UserEntity userEntity = this.usersService.getUser(userId);
        return this.modelMapper.map(userEntity, UserRestResponseDTO.class);
    }

    @ApiOperation(value = "Add a new user", notes = "Adding a new user to database")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 409, message = "User already exists "),
            @ApiResponse(code = 415, message = "Unsupported Media Type "),
            @ApiResponse(code = 500, message = "Server malfunction")
    })
    @PostMapping(value = "/users")
    public ResponseEntity<UserRestResponseDTO> createUser(
             @RequestBody UserCreationDTO userCreationDTO) {

        UserEntity userEntity = this.usersService.createUser(userCreationDTO);

        UserRestResponseDTO userRestResponseDto = this.modelMapper.map(userEntity, UserRestResponseDTO.class);
        return new ResponseEntity<>(userRestResponseDto, HttpStatus.CREATED);
    }
}
