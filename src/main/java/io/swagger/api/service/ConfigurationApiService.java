package io.swagger.api.service;

import io.swagger.model.ModelConfiguration;

public interface ConfigurationApiService {
	
	public ModelConfiguration getConfiguration();
	
	void updateConfiguration(ModelConfiguration body);
}
