package io.swagger.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Reminder;
import io.swagger.model.Reminder.TypeEnum;

@Repository("remindersApiDao")
public interface RemindersApiDao extends CrudRepository<Reminder, Integer> {

	public Reminder getReminderById(Long id);
	
	public List<Reminder> getReminderByType(TypeEnum type);
}
