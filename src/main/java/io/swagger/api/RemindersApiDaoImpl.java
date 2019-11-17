package io.swagger.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.model.Reminder;

public class RemindersApiDaoImpl implements RemindersApiDao{

	Map<String, List<Reminder>> reminderMap = new HashMap<>();
	
	@Override
	public void addReminder(Reminder reminder) {
		List<Reminder> reminderList = reminderMap.get(reminder.getType().name());
		if(reminderList != null) {
			reminderList.add(reminder);
		}else {
			reminderList = Arrays.asList(reminder);
		}
		reminderMap.put(reminder.getType().name(), reminderList);
		
	}

	@Override	
	public List<Reminder> getReminders() {
		List<Reminder> result = new ArrayList<>();
		List<List<Reminder>> reminderLists = new ArrayList<>(reminderMap.values());
		reminderLists.forEach(list -> result.addAll(list));
		return result;
	}
	
}
