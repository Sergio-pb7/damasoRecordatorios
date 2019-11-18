package io.swagger.api.controller;

import io.swagger.model.InlineResponse200;
import io.swagger.model.Reminder;
import io.swagger.model.Reminder.TypeEnum;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.service.RemindersApiService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-16T21:07:28.234Z[GMT]")
@Controller
public class RemindersApiController implements RemindersApi {

    private static final Logger log = LoggerFactory.getLogger(RemindersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private RemindersApiService remindersApiService;

    @org.springframework.beans.factory.annotation.Autowired
    public RemindersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<InlineResponse200> addReminder(@ApiParam(value = "Añade un nuevo recordatorio" ,required=true )  @Valid @RequestBody Reminder body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	remindersApiService.addReminder(body);
                return new ResponseEntity<InlineResponse200>(objectMapper.readValue("{\n  \"id\" : " + body.getId() + "\n}", InlineResponse200.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse200>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse200>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> cancelReminder(@ApiParam(value = "ID del recordatorio a cancelar",required=true) @PathVariable("reminderId") Long reminderId) {
        String accept = request.getHeader("Accept");
        try {
        	remindersApiService.cancelReminder(reminderId);
        	return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    public ResponseEntity<Reminder> getReminderById(@ApiParam(value = "ID del recordatorio",required=true) @PathVariable("reminderId") Long reminderId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Reminder>(remindersApiService.getReminderById(reminderId), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Reminder>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Reminder>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Reminder>> getReminderByType(@ApiParam(value = "tipo del recordatorio",required=true, allowableValues="medicine, food, inactivity") @PathVariable("reminderType") String reminderType) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Reminder>>(remindersApiService.getReminderByType(TypeEnum.fromValue(reminderType)), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Reminder>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Reminder>>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Reminder>> getReminders() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Reminder>>(remindersApiService.getReminders(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Reminder>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Reminder>>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> updateReminder(@ApiParam(value = "Información con la que se va a actualizar el recordatorio" ,required=true )  @Valid @RequestBody Reminder body,@ApiParam(value = "ID del recordatorio a modificar",required=true) @PathVariable("reminderId") Long reminderId) {
        String accept = request.getHeader("Accept");
        try{
        	remindersApiService.updateReminder(reminderId, body);
        	return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch(Exception e) {
        	return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}