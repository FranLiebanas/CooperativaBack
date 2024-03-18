package com.fran.cooperativa.backend.application;

import com.fran.cooperativa.backend.domain.model.User;
import com.fran.cooperativa.backend.domain.port.IUserRepository;

public class UserService {
    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User save (User user){
        return iUserRepository.save(user);
    }

    public User findById (Integer id){
        return this.iUserRepository.findById(id);
    }


}
