package io.swagger.api;

import java.util.List;

import io.swagger.model.Reminder;

public interface RemindersApiService {
	public void addReminder(Reminder reminder);
	
	public List<Reminder> getReminders();
}
