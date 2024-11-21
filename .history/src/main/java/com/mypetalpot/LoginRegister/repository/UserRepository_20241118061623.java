package com.mypetalpot.LoginRegister.repository;

import java.util.Optional;
import com.mypetalpot.LoginRegister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
