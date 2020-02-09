package com.boylegu.springboot_vue.service.user;

import antlr.StringUtils;
import com.boylegu.springboot_vue.PasswordEncryption.PasswordEncryptionService;
import com.boylegu.springboot_vue.controller.dto.request.LoginRequestDto;
import com.boylegu.springboot_vue.controller.dto.request.UserCreateDto;
import com.boylegu.springboot_vue.controller.dto.response.UserListResponseDto;
import com.boylegu.springboot_vue.dto.UserDto;
import com.boylegu.springboot_vue.dto.UserPantryDto;
import com.boylegu.springboot_vue.entities.User;
import com.boylegu.springboot_vue.entities.UserPantry;
import com.boylegu.springboot_vue.entities.UserPassword;
import com.boylegu.springboot_vue.repository.UserPantryRepo;
import com.boylegu.springboot_vue.repository.UserPasswordRepo;
import com.boylegu.springboot_vue.repository.UserRepo;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements  UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserPasswordRepo userPasswordRepo;

    @Autowired
    UserPantryRepo userPantryRepo;

    @Override
    public UserListResponseDto getUserList() throws Exception {
        List<User> userEntities = userRepo.findAll();

        UserListResponseDto userListResponseDto = new UserListResponseDto(new ArrayList<>());
        for (User user : userEntities) {
            UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmailAddress());
            List<UserDto> userDtoList = userListResponseDto.getData();
            userDtoList.add(userDto);
            userListResponseDto.setData(userDtoList);
        }
        return userListResponseDto;
    }

    @Override
    public UserDto getUserById(UUID userId) throws Exception {
        if (Objects.isNull(userId)) {
            throw new IllegalArgumentException("id cannot be empty/null");
        }
        final Optional<User> userOptional = userRepo.findOneById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new UserDto(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmailAddress());
        }
        throw new Exception("User with id: " + userId + "does not exist.");
    }

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setEmailAddress(userCreateDto.getEmailAddress());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setUsername(userCreateDto.getUsername());

        userRepo.save(user);

        return new UserDto(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmailAddress());
    }

    @Override
    @Transactional
    public UserDto createPassword(final UUID userId, final String password) throws Exception {
        if (Objects.isNull(userId)) {
            throw new IllegalArgumentException("id cannot be empty/null");
        }

        Optional<User> userEntityOptional = userRepo.findOneById(userId);
        if (userEntityOptional.isPresent()) {
            User user = userEntityOptional.get();

//            ArrayList<String> errors = validPassword(password, localUserEntity);
//            if (errors.size() != 0) {
//                String errorDetails = String.join(" ,", errors);
//                throw new PasswordNotValidException(AuthnErrorDetails.PASSWORD_INVALID_ERROR, errorDetails);
//            }

            // generating a new salt for each password
            byte[] salt = PasswordEncryptionService.generateSalt();
            byte[] encryptedPassword = PasswordEncryptionService.getEncryptedPassword(password, salt);

            List<UserPassword> ineffectivePasswords =
                    userPasswordRepo.findByUserAndIneffectiveIsNull(user);
            for (int i = 0; i < ineffectivePasswords.size(); i++) {
                UserPassword oldPassword = ineffectivePasswords.get(i);
                oldPassword.setIneffective(LocalDateTime.now());
            }

            UserPassword localUserPassword = new UserPassword();
            localUserPassword.setEffective(LocalDateTime.now());
            localUserPassword.setUser(user);
            localUserPassword.setPassword(encryptedPassword);
            localUserPassword.setSalt(salt);
            userPasswordRepo.save(localUserPassword);

            return new UserDto(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmailAddress());

        }
        throw new Exception("User with id: " + userId + "does not exist.");
    }

    @Override
    @Transactional()
    public UserDto login(LoginRequestDto loginDto) throws Exception {
//        if (StringUtils.isBlank(username)) {
//            throw new IllegalArgumentException("username cannot be empty/null");
//        }
//        if (StringUtils.isBlank(password)) {
//            throw new IllegalArgumentException("password cannot be empty/null");
//        }

        Optional<User> userOptional = userRepo.findOneByEmailAddress(loginDto.getEmail());
        if (!userOptional.isPresent()) {
            throw new Exception("Username does not exist.");
        }

        User user = userOptional.get();
        Optional<UserPassword> userPasswordOptional =
                userPasswordRepo.findByUserIdAndIneffectiveIsNull(user.getId());

        if (!userPasswordOptional.isPresent()) {
            throw new Exception("No password has been set for your account yet.");
        }
        UserPassword userPassword = userPasswordOptional.get();

        byte[] salt = userPassword.getSalt();
        byte[] encryptedPassword = PasswordEncryptionService.getEncryptedPassword(loginDto.getPassword(), salt);
        byte[] actualPassword = userPassword.getPassword();
        if (!Arrays.equals(actualPassword, encryptedPassword)) {
            throw new Exception("Password is invalid.");
        }
        return new UserDto(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmailAddress());

    }

    @Override
    @Transactional()
    public void addToPantry(UUID userId, int sku, int value, String unit, String name) {
        Optional<UserPantry> userPantryOptional = userPantryRepo.findOneByUserIdAndSku(userId, sku);
        if(userPantryOptional.isPresent()){
            UserPantry userPantry = userPantryOptional.get();
            userPantry.setValue( userPantry.getValue() + value);
        }
        else {
            UserPantry userPantry = new UserPantry();

            userPantry.setUserId(userId);
            userPantry.setSku(sku);
            userPantry.setValue(value);
            userPantry.setUnit(unit);
            userPantry.setName(name);

            userPantryRepo.save(userPantry);
        }
    }



    @Override
    public List<UserPantry> getUserPantry(UUID id) throws Exception{
        List<UserPantry> pantry =  userPantryRepo.findAllByUserId(id);
        return pantry;
    }

}
