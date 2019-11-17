package io.swagger.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import io.swagger.model.Reminder;
@Repository(("remindersApiDao"))
public class RemindersApiDaoImpl implements RemindersApiDao{

	Map<String, List<Reminder>> reminderMap = new HashMap<>();

	@Override
	public void addReminder(Reminder reminder) {
		List<Reminder> reminderList = reminderMap.get(reminder.getType().name());
		List<Reminder> list = new ArrayList<>(); 
		if(reminderList != null) {
			list.add(reminder);
			list = new ArrayList<>(reminderList); 
		}else {
			list = Arrays.asList(reminder);
		}
		reminderMap.put(reminder.getType().name(), list);

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
				element -> {List<Reminder> newList = removeFromList(list, element);
					if(newList != null) {
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


	private List<Reminder> removeFromList(List<Reminder> list, Reminder reminder){
		List<Reminder> newList = new ArrayList<>(list); 
		for(int i = 0; i < newList.size(); i++) {
			if(newList.get(i).getId() == reminder.getId()) {
				newList.remove(i);
				return newList;
			}
		}
		return null;
	}


	


}
