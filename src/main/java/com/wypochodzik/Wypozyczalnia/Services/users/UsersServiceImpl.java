package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UsersUpdateDTO;
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

    public UsersEntity updateUser(Long userId, UsersUpdateDTO usersUpdateDTO) {
        Optional<UsersEntity> userEntityOptional = this.usersRepository.findById(userId);
        if (userEntityOptional.isEmpty()){
            return null; // wyjatek
        }
        UsersEntity usersEntity = this.modelMapper.map(usersUpdateDTO, UsersEntity.class);
        usersEntity.setEmail(userEntityOptional.get().getEmail());
        usersEntity.setUserId(userEntityOptional.get().getUserId());
        usersEntity.setCardData(userEntityOptional.get().getCardData());
        usersEntity.setTotalPayed(userEntityOptional.get().getTotalPayed());
        usersEntity.setDiscountRatio(userEntityOptional.get().getDiscountRatio());
        usersEntity.setIntPromo(userEntityOptional.get().isIntPromo());
        usersEntity.setPasswd(userEntityOptional.get().getPasswd());
        usersEntity.setBanned(userEntityOptional.get().isBanned());
        return this.usersRepository.save(usersEntity);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<UsersEntity> userEntityOptional = this.usersRepository.findById(userId);
        if (userEntityOptional.isEmpty()){
            int p =1; // wyjatek
        }
        else{
            UsersEntity userEntity = userEntityOptional.get();
            this.usersRepository.delete(userEntity);
        }
    }

    //ZMINA HASLA
}
