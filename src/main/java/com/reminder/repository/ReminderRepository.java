package com.reminder.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reminder.model.Reminder;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    // Custom query methods can be defined here if needed
    // List<Reminder> findByUser(User user);
    List<Reminder> findByUserId(Long userId);

    void deleteByIdAndUserId(Long id, Long userId);
}
