package com.wypochodzik.Wypozyczalnia.Controllers;

import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UsersRestResponseDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchUserException;
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
    public UsersRestResponseDTO getUser(@PathVariable Long userId) throws NoSuchUserException {

        UsersEntity usersEntity = this.usersService.getUser(userId);
        return this.modelMapper.map(usersEntity, UsersRestResponseDTO.class);
    }

    @ApiOperation(value = "Add a new user", notes = "Adding a new user to database")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 409, message = "User already exists "),
            @ApiResponse(code = 415, message = "Unsupported Media Type "),
            @ApiResponse(code = 500, message = "Server malfunction")
    })
    @PostMapping(value = "/users")
    public ResponseEntity<UsersRestResponseDTO> createUser(
             @RequestBody UsersCreationDTO usersCreationDTO) {

        UsersEntity usersEntity = this.usersService.createUser(usersCreationDTO);

        UsersRestResponseDTO usersRestResponseDto = this.modelMapper.map(usersEntity, UsersRestResponseDTO.class);
        return new ResponseEntity<>(usersRestResponseDto, HttpStatus.CREATED);
    }
}
