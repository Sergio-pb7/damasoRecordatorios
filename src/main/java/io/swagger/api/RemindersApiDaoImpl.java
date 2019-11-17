package io.swagger.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import io.swagger.model.Reminder;
@Repository(("remindersApiDao"))
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
		List<List<Reminder>> reminderLists = new ArrayList<>();
		reminderLists.forEach(list -> result.addAll(list));
		return result;
	}

	@Override
	public void cancelReminder(long id) {
		reminderMap.values().forEach(list -> list.forEach(
				element -> {if(removeFromList(list, element)) {
					reminderMap.put(element.getType().toString(), list);
				}
				return;
				}));

	}

	@Override
	public Reminder getReminderById(long id) {
		List<String> keySet = new ArrayList<>(reminderMap.keySet());
		for(int i = 0; i < keySet.size(); i++) {
			for(Reminder r : reminderMap.get(keySet.get(i))) {
				if(r.getId() == id) return r;

			}
		}
		return null;
	}
	
	@Override
	public List<Reminder> getReminderByType(String type) {
		return reminderMap.get(type);
	}


	private boolean removeFromList(List<Reminder> list, Reminder reminder){
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == reminder.getId()) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}


	


}
