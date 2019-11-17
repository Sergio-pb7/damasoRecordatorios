package io.swagger.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.ModelConfiguration;
import io.swagger.model.Reminder;
import io.swagger.model.Reminder.TypeEnum;

@Repository("modelConfigurationApiDao")
public interface ConfigurationApiDao extends CrudRepository<ModelConfiguration, Integer> {

	@Query("SELECT c FROM ModelConfiguration c WHERE version = (SELECT max(version) FROM ModelConfiguration)")
	public ModelConfiguration getConfiguration();

}
