package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.UserCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UserUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UserEntity;
import com.wypochodzik.Wypozyczalnia.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUser(Long userId) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(userId);
        if (userEntityOptional.isEmpty()){
            return null; // wyjatek
        }
        return userEntityOptional.get();
    }

    @Override
    public UserEntity createUser(UserCreationDTO userCreationDTO) {
        if (this.userRepository.findByEmail(userCreationDTO.getEmail()) != null){
            return null; // wyjatek
        }
        UserEntity userEntity = this.modelMapper.map(userCreationDTO, UserEntity.class);
        userEntity.setTotalPayed(0);
        userEntity.setBanned(false);
        return this.userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(Long userId, UserUpdateDTO userUpdateDTO) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(userId);
        if (userEntityOptional.isEmpty()){
            return null; // wyjatek
        }
        UserEntity userEntity = this.modelMapper.map(userUpdateDTO, UserEntity.class);
        userEntity.setEmail(userEntityOptional.get().getEmail());
        userEntity.setUserId(userEntityOptional.get().getUserId());
        userEntity.setCardData(userEntityOptional.get().getCardData());
        userEntity.setTotalPayed(userEntityOptional.get().getTotalPayed());
        userEntity.setDiscountRatio(userEntityOptional.get().getDiscountRatio());
        userEntity.setIntPromo(userEntityOptional.get().isIntPromo());
        userEntity.setPasswd(userEntityOptional.get().getPasswd());
        userEntity.setBanned(userEntityOptional.get().isBanned());
        return this.userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(userId);
        if (userEntityOptional.isEmpty()){
            int p =1; // wyjatek
        }
        else{
            UserEntity userEntity = userEntityOptional.get();
            this.userRepository.delete(userEntity);
        }
    }

    //ZMINA HASLA
}
