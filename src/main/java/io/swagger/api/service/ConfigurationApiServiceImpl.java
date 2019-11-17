package io.swagger.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.api.dao.ConfigurationApiDao;
import io.swagger.model.ModelConfiguration;

@Service("modelConfigurationApiService")
public class ConfigurationApiServiceImpl implements ConfigurationApiService{

	@Autowired
	private ConfigurationApiDao modelConfigurationApiDao;


	@Override
	public ModelConfiguration getConfiguration() {
		return modelConfigurationApiDao.getConfiguration();
	}

	@Override
	public void updateConfiguration(ModelConfiguration config) {
		modelConfigurationApiDao.save(config);
		
	}

}
