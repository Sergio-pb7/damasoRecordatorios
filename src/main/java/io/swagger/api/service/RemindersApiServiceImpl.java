package io.swagger.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.api.dao.RemindersApiDao;
import io.swagger.model.Reminder;
import io.swagger.model.Reminder.TypeEnum;

@Service("remindersApiService")
public class RemindersApiServiceImpl implements RemindersApiService{

	@Autowired
	private RemindersApiDao remindersApiDao;
	
	@Override
	public void addReminder(Reminder reminder) {
		remindersApiDao.save(reminder);
		
	}

	@Override
	public List<Reminder> getReminders() {
		return (List<Reminder>) remindersApiDao.findAll();
	}

	@Override
	public void cancelReminder(long id) {
		remindersApiDao.delete(new Reminder().id(id));
		
	}

	@Override
	public Reminder getReminderById(long id) {
		return remindersApiDao.getReminderById(id);
	}

	@Override
	public List<Reminder> getReminderByType(TypeEnum type) {
		return remindersApiDao.getReminderByType(type);
	}
	
	@Override
	public void updateReminder(long reminderId, Reminder reminder) {
		reminder.setId(reminderId);
		remindersApiDao.save(reminder);
	}

}
