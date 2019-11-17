package io.swagger.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.api.service.ConfigurationApiService;
import io.swagger.model.ModelConfiguration;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-16T21:07:28.234Z[GMT]")
@Controller
public class ConfigurationApiController implements ConfigurationApi {

    private static final Logger log = LoggerFactory.getLogger(ConfigurationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private ConfigurationApiService configurationApiService;

    @org.springframework.beans.factory.annotation.Autowired
    public ConfigurationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ModelConfiguration> getConf() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ModelConfiguration>(configurationApiService.getConfiguration(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelConfiguration>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelConfiguration>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateConf(@ApiParam(value = "Nueva configuración" ,required=true )  @Valid @RequestBody ModelConfiguration body) {
        String accept = request.getHeader("Accept");
        try {
			configurationApiService.updateConfiguration(body);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
    }

}
