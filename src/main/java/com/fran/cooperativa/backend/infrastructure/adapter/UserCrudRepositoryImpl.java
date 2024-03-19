package com.fran.cooperativa.backend.infrastructure.adapter;

import com.fran.cooperativa.backend.domain.model.User;
import com.fran.cooperativa.backend.domain.model.UserNoRegister;
import com.fran.cooperativa.backend.domain.port.IUserRepository;
import com.fran.cooperativa.backend.infrastructure.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    private final IUserCrudRepository iUserCrudRepository;
    private final UserMapper userMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, UserMapper userMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByDNI(String dni) {
        return userMapper.toUser(iUserCrudRepository.findByDni(dni).orElseThrow(
                () -> new RuntimeException("El usuario con DNI: " + dni + " no existe.")
        ));
    }

    @Override
    @Transactional
    public User save(User user) {
        iUserCrudRepository.save(userMapper.toUserEntity(user));

        return user;
    }

    @Override
    @Transactional
    public UserNoRegister saveUserNoRegister(UserNoRegister userNoRegister) {
        iUserCrudRepository.save(userMapper.fromUserNoRegisterToUserEntity(userNoRegister));

        return userNoRegister;
    }

}
