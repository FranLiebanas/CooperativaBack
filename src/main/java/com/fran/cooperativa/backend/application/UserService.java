package com.fran.cooperativa.backend.application;

import com.fran.cooperativa.backend.domain.model.User;
import com.fran.cooperativa.backend.domain.model.UserNoRegister;
import com.fran.cooperativa.backend.domain.port.IUserRepository;

public class UserService {
    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User save(User user) {
        return iUserRepository.save(user);
    }

    public UserNoRegister saveNoRegisterUser(UserNoRegister userNoRegister) {
        return iUserRepository.saveUserNoRegister(userNoRegister);
    }

    public User findByDNI(String dni) {
        return this.iUserRepository.findByDNI(dni);
    }


}
