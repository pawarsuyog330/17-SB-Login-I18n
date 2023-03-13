package com.ashokit.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.mvc.entity.LoginEntity;

public interface LoginEntityRepository extends JpaRepository<LoginEntity, String> {

}
