/*
 * Copyright (c) 2018 Zuan_Wiko
 */
package com.web.react.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
 * The Class UserEntity.
 *
 * @author <a href="mailto:minhquan9402@gmail.com">zuan_</a>
 */
@Table(name = "User")
@Entity(name = "User")
public class UserEntity implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -8805807099326249976L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** The username. */
  @Column(name = "username", nullable = false, unique = true)
  private String username;

  /** The password. */
  @Column(name = "password", nullable = false)
  private String password;

  /** The enabled. */
  @Column(name = "enabled", nullable = false)
  private boolean enabled;

  /** The phone. */
  @Column(name = "phone")
  private String phone;

  /** The email. */
  @Column(name = "email")
  private String email;

  /** The last login time. */
  @Column(name = "lastLoginTime", nullable = true)
  private Timestamp lastLoginTime;

  /** The archived. */
  @Column(name = "archived")
  private boolean archived;

  /** The roles. */
  @ManyToMany
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Collection<RoleEntity> roles;

  /**
   * The domain create time.
   */
  @Column(name = "createTime")
  private Timestamp createTime;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Gets the username.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Gets the password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Checks if is enabled.
   *
   * @return true, if is enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * Gets the phone.
   *
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Gets the last login time.
   *
   * @return the last login time
   */
  public Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  /**
   * Checks if is archived.
   *
   * @return true, if is archived
   */
  public boolean isArchived() {
    return archived;
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
   * Gets the creates the time.
   *
   * @return the creates the time
   */
  public Timestamp getCreateTime() {
    return createTime;
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
   * Sets the username.
   *
   * @param username
   *          the new username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Sets the password.
   *
   * @param password
   *          the new password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Sets the enabled.
   *
   * @param enabled
   *          the new enabled
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Sets the phone.
   *
   * @param phone
   *          the new phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Sets the email.
   *
   * @param email
   *          the new email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Sets the last login time.
   *
   * @param lastLoginTime
   *          the new last login time
   */
  public void setLastLoginTime(Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  /**
   * Sets the archived.
   *
   * @param archived
   *          the new archived
   */
  public void setArchived(boolean archived) {
    this.archived = archived;
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

  /**
   * Sets the creates the time.
   *
   * @param createTime
   *          the new creates the time
   */
  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

}
