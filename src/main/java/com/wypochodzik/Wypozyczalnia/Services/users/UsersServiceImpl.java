package com.wypochodzik.Wypozyczalnia.Services.users;

<<<<<<< HEAD
import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
=======
import com.wypochodzik.Wypozyczalnia.DTO.UserCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UserUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UserEntity;
import com.wypochodzik.Wypozyczalnia.Repositories.UserRepository;
>>>>>>> c426f9754725fb855b9030ce0b6b4ca89c6781f9
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
<<<<<<< HEAD
    public UsersEntity updateUser(Long userId) {
        return null;
    }

    @Override
    public UsersEntity deleteUser(Long userId) {
        return null;
=======
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
>>>>>>> c426f9754725fb855b9030ce0b6b4ca89c6781f9
    }

    //ZMINA HASLA
}
