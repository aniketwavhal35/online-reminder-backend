package com.reminder.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reminder.model.Reminder;
import com.reminder.service.ReminderService;


@RestController
@RequestMapping("/reminder")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping("/user/{userId}")
    public Reminder createReminder(@PathVariable Long userId, @RequestBody Reminder reminder) {
        return reminderService.createReminder(reminder, userId);
    }

    @GetMapping("/user/{userId}")
    public List<Reminder> getReminders(@PathVariable Long userId) {
        return reminderService.getRemindersByUser(userId);
    }

}
