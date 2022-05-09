package com.mfa.springmsgateway.repository;

import com.mfa.springmsgateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String name); //JPA

    @Query("Select a from User a where a.name =?1")//Eğer (String name,String surname) gibi bir durum olsaydı ?1 name, ?2 surname olacaktı
    Optional<User> findByUsernameQuery(String name);

    @Query(value = "Select a from User a where a.name =?1",nativeQuery = true)
    Optional<User> findByUsernameNativeQuery(String name);

}
