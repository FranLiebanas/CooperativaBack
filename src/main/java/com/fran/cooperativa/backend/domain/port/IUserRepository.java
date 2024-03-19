package com.fran.cooperativa.backend.domain.port;

import com.fran.cooperativa.backend.domain.model.User;
import com.fran.cooperativa.backend.domain.model.UserNoRegister;

public interface IUserRepository {
    User save(User user);
    User findByEmail(String email);
    User findByDNI(String dni);

    UserNoRegister saveUserNoRegister(UserNoRegister userNoRegister);
}
