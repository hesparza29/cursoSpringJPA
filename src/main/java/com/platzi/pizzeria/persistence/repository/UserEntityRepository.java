package com.platzi.pizzeria.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.platzi.pizzeria.persistence.entity.UserEntity;

public interface UserEntityRepository extends CrudRepository<UserEntity, String> {

}
