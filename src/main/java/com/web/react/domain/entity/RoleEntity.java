/*
 * Copyright (c) 2018 Zuan_Wiko
 */
package com.web.react.domain.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Class RoleEntity.
 *
 * @author <a href="mailto:minhquan9402@gmail.com">zuan_</a>
 */
@Table(name = "Role")
@Entity(name = "Role")
public class RoleEntity implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -1463060033895386393L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** The name. */
  @Column(name = "name", nullable = false, unique = true)
  private String name;

  /** The users. */
  @ManyToMany(mappedBy = "roles")
  private Collection<UserEntity> users;

  /** The privileges. */
  @ManyToMany
  @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
  private Collection<PrivilegeEntity> privileges;

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
   * Gets the users.
   *
   * @return the users
   */
  public Collection<UserEntity> getUsers() {
    return users;
  }

  /**
   * Gets the privileges.
   *
   * @return the privileges
   */
  public Collection<PrivilegeEntity> getPrivileges() {
    return privileges;
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
   * Sets the users.
   *
   * @param users
   *          the new users
   */
  public void setUsers(Collection<UserEntity> users) {
    this.users = users;
  }

  /**
   * Sets the privileges.
   *
   * @param privileges
   *          the new privileges
   */
  public void setPrivileges(Collection<PrivilegeEntity> privileges) {
    this.privileges = privileges;
  }

}
