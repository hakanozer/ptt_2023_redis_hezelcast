package com.works.repositories;

import com.works.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    // select * from admin email = '' and password = ''
    //Optional<Admin> findAdminByEmailEqualsAndPasswordEquals(String email, String password);

    Optional<Admin> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);

}
