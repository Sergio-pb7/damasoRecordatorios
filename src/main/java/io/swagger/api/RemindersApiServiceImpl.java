package io.swagger.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Reminder;

@Service
public class RemindersApiServiceImpl implements RemindersApiService{

	@Autowired
	private RemindersApiDao remindersApiDao;
	
	@Override
	public void addReminder(Reminder reminder) {
		remindersApiDao.addReminder(reminder);
		
	}

	@Override
	public List<Reminder> getReminders() {
		return remindersApiDao.getReminders();
	}

}
