package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersEntity getUser(Long userId) {
        Optional<UsersEntity> userEntityOptional = this.usersRepository.findById(userId);
        if (userEntityOptional.isEmpty()){
            return null; // wyjatek
        }
        return userEntityOptional.get();
    }

    @Override
    public UsersEntity createUser(UsersCreationDTO usersCreationDTO) {
        if (this.usersRepository.findByEmail(usersCreationDTO.getEmail()) != null){
            return null; // wyjatek
        }
        UsersEntity usersEntity = this.modelMapper.map(usersCreationDTO, UsersEntity.class);
        usersEntity.setTotalPayed(0);
        usersEntity.setBanned(false);
        return this.usersRepository.save(usersEntity);
    }

    @Override
    public UsersEntity updateUser(Long userId) {
        return null;
    }

    @Override
    public UsersEntity deleteUser(Long userId) {
        return null;
    }
}
