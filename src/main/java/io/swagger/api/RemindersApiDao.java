package io.swagger.api;

import java.util.List;

import io.swagger.model.Reminder;

public interface RemindersApiDao {
	
	public void addReminder(Reminder reminder);
	
	public List<Reminder> getReminders();

	public void cancelReminder(long id);

	public Reminder getReminderById(long id);

	public List<Reminder> getReminderByType(String type);
}
