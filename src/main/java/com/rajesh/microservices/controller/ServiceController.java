package com.rajesh.microservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rajesh.microservices.model.Question;
import com.rajesh.microservices.model.Survey;
import com.rajesh.microservices.service.SurveyService;

@Controller
public class ServiceController {

	@Autowired
	private SurveyService service;
	
	@GetMapping("/fetchAllServey")
	@ResponseBody
	public List<Survey> sendAllSurveys() {
		return service.retrieveAllSurveys();
	}
	
	@GetMapping("/survey/{surveyId}")
	@ResponseBody
	public Survey retrieveSurvey(@PathVariable String surveyId) {
		return service.retrieveSurvey(surveyId);
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
    ResponseEntity<?> add(@PathVariable String surveyId,
            @RequestBody Question question) {

        Question createdTodo = service.addQuestion(surveyId, question);

        if (createdTodo == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        ResponseEntity.status(200).build();

        return ResponseEntity.created(location).build();

    }
}
