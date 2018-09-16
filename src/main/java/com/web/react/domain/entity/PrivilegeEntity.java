/*
 * Copyright (c) 2018 Zuan_Wiko
 */
package com.web.react.domain.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Class PrivilegeEntity.
 *
 * @author <a href="mailto:minhquan9402@gmail.com">zuan_</a>
 */
@Table(name = "Privilege")
@Entity(name = "Privilege")
public class PrivilegeEntity {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** The name. */
  @Column(name = "name", nullable = false, unique = true)
  private String name;

  /** The roles. */
  @ManyToMany(mappedBy = "privileges")
  private Collection<RoleEntity> roles;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the roles.
   *
   * @return the roles
   */
  public Collection<RoleEntity> getRoles() {
    return roles;
  }

  /**
   * Sets the id.
   *
   * @param id
   *          the new id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Sets the name.
   *
   * @param name
   *          the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the roles.
   *
   * @param roles
   *          the new roles
   */
  public void setRoles(Collection<RoleEntity> roles) {
    this.roles = roles;
  }

}
