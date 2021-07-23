package com.perennialsys.repository;

import com.perennialsys.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("SELECT u from Role u ")
  public Role findbyName();
@Query("select r from Role r where r.name=?1")
    public Role findBySpecificName(String name);
}
