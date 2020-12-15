package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UsersUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
import com.wypochodzik.Wypozyczalnia.DTO.UserChangePasswordDTO;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.InvalidPasswordException;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchUserException;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.UserAlreadyExistsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public UsersEntity getUser(Long userId) throws NoSuchUserException{
        Optional<UsersEntity> userEntityOptional = this.usersRepository.findById(userId);
        if (userEntityOptional.isEmpty()){
            throw new NoSuchUserException();
        }
        return userEntityOptional.get();
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        return this.usersRepository.findAll();
    }

    @Override
    public UsersEntity createUser(UsersCreationDTO usersCreationDTO) throws UserAlreadyExistsException {
        if (this.usersRepository.findByEmail(usersCreationDTO.getEmail()) != null){
            throw new UserAlreadyExistsException();
        }
        UsersEntity usersEntity = this.modelMapper.map(usersCreationDTO, UsersEntity.class);
        usersEntity.setTotalPayed(0.0);
        usersEntity.setBanned(false);
        return this.usersRepository.save(usersEntity);
    }

    public UsersEntity updateUser(Long userId, UsersUpdateDTO usersUpdateDTO) throws NoSuchUserException{
        Optional<UsersEntity> userEntityOptional = this.usersRepository.findById(userId);
        if (userEntityOptional.isEmpty()){
            throw new NoSuchUserException();
        }
        UsersEntity usersEntity = this.modelMapper.map(usersUpdateDTO, UsersEntity.class);
        usersEntity.setEmail(userEntityOptional.get().getEmail());
        usersEntity.setUserId(userEntityOptional.get().getUserId());
        usersEntity.setCardData(userEntityOptional.get().getCardData());
        usersEntity.setTotalPayed(userEntityOptional.get().getTotalPayed());
        usersEntity.setDiscountRatio(userEntityOptional.get().getDiscountRatio());
        usersEntity.setInfPromo(userEntityOptional.get().isInfPromo());
        usersEntity.setPasswd(userEntityOptional.get().getPasswd());
        usersEntity.setBanned(userEntityOptional.get().isBanned());
        return this.usersRepository.save(usersEntity);
    }

    @Override
    public void deleteUser(Long userId) throws NoSuchUserException{
        Optional<UsersEntity> userEntityOptional = this.usersRepository.findById(userId);
        if (userEntityOptional.isEmpty()){
            throw new NoSuchUserException();
        }
        else{
            UsersEntity userEntity = userEntityOptional.get();
            this.usersRepository.delete(userEntity);
        }
    }

    @Override
    public UsersEntity changePassword(Long userId, UserChangePasswordDTO userPasswordChangeDto) throws NoSuchUserException, InvalidPasswordException{
        Optional<UsersEntity> userEntityOptional = this.usersRepository.findById(userId);
        if (userEntityOptional.isEmpty())
            throw new NoSuchUserException();

        UsersEntity userEntity = userEntityOptional.get();
        if (!userEntity.getPasswd().equals(userPasswordChangeDto.getOldPass()))
            throw new InvalidPasswordException();
        else
            userEntity.setPasswd(userPasswordChangeDto.getNewPass());
        return this.usersRepository.save(userEntity);
    }

}
