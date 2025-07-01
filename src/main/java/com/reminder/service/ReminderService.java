package com.reminder.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reminder.model.Reminder;
import com.reminder.model.User;
import com.reminder.repository.ReminderRepository;
import com.reminder.repository.UserRepository;


@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private UserRepository userRepository;

    public Reminder createReminder(Reminder reminder, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        reminder.setUser(user);
        reminderRepository.save(reminder);
        return reminder;
    }

    public List<Reminder> getRemindersByUser(Long id) {
        return reminderRepository.findByUserId(id);
    }

    public void deleteReminder(Long reminderId) {
        if (reminderRepository.existsById(reminderId)){
            reminderRepository.deleteById(reminderId);
        } else {
            throw new IllegalArgumentException("Reminder not found with id: " + reminderId);
        }
    }

    // Additional methods for updating and deleting reminders can be added here

}
