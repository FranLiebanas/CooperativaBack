package com.fran.cooperativa.backend.infrastructure.adapter;

import com.fran.cooperativa.backend.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<UserEntity,Integer> {

}
