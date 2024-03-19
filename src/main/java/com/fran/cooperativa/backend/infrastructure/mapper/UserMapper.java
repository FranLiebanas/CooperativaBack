package com.fran.cooperativa.backend.infrastructure.mapper;

import com.fran.cooperativa.backend.domain.model.User;
import com.fran.cooperativa.backend.domain.model.UserNoRegister;
import com.fran.cooperativa.backend.infrastructure.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserEntity userEntity);
    Iterable<User> toUsers(Iterable<UserEntity> userEntities);

    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);

    UserNoRegister fromEntityToUserNoRegister(UserEntity userEntity);
    UserEntity fromUserNoRegisterToUserEntity(UserNoRegister userNoRegister);

}
