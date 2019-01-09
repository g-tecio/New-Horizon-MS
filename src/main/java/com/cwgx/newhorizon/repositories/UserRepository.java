package com.cwgx.newhorizon.repositories;

import com.cwgx.newhorizon.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM users WHERE name = ?1", nativeQuery = true)
    User userFindByName(String name);
}
