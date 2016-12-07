package com.buy.together.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.service.BuyTogetherService;

@RestController
@RequestMapping("/restBuytogether/*")
public class BuyTogetherRestController {

	private static final Logger logger = LoggerFactory.getLogger(BuyTogetherRestController.class);

	@Inject
	private BuyTogetherService service;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<BuyTogetherDTO>> ListTest() {

		ResponseEntity<List<BuyTogetherDTO>> entity = null;

		try {
			
			entity = new ResponseEntity<>(service.buyTogetherList(), HttpStatus.OK);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return entity;
	}

}