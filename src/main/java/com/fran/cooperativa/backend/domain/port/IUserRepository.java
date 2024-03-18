package com.fran.cooperativa.backend.domain.port;

import com.fran.cooperativa.backend.domain.model.User;

public interface IUserRepository {
    User save(User user);
    User findByEmail(String email);
    User findById(Integer id);

}
