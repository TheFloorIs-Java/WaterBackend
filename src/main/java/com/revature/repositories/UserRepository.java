package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);

    /**
     * Retrieves the ID of a user from the database 
     * 
     * @param email must correspond to a user in the database
     * @return the ID of a user from the database
     */
    @Query(value = "SELECT id FROM Users WHERE email = :email", nativeQuery = true)
    public int getIDByEmail(@Param("email") String email);
}
