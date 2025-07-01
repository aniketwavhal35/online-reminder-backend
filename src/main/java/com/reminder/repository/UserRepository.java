package com.reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reminder.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be defined here if needed

}
