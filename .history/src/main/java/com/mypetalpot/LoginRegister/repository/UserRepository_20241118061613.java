package com.mypetalpot.LoginRegister.repository;

import java.util.Optional;
impor
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
