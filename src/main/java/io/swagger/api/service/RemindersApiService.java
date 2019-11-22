package io.swagger.api.service;

import java.util.List;

import io.swagger.model.Reminder;
import io.swagger.model.Reminder.TypeEnum;

public interface RemindersApiService {
	public Long addReminder(Reminder reminder);
	
	public List<Reminder> getReminders();
	
	public void cancelReminder(long id);
	
	public Reminder getReminderById(long id);
	
	public List<Reminder> getReminderByType(TypeEnum type);

	void updateReminder(long reminderId, Reminder reminder);
}
