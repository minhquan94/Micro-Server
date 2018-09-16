/*
 * Copyright (c) 2018 Zuan_Wiko
 */
package com.web.react.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.react.domain.entity.UserEntity;

/**
 * The Interface UserRepository.
 *
 * @author <a href="mailto:developer@hitachiconsulting.com">zuan_</a>
 */
public interface UserRepository extends BaseJpaRepository<UserEntity, Long> {

  /**
   * Find by username.
   *
   * @param username
   *          the username
   * @return the user entity
   */
  @Query("SELECT u FROM User u where u.username = :username")
  UserEntity findByUsername(@Param(value = "username") String username);

}
