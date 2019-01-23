package com.buy.together.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/indexer")
public class IndexerController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String requestIndexerList(Locale locale) {
		return "/views/admin/indexer";

	}

}
