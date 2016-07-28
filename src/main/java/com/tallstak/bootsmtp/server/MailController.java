package com.tallstak.bootsmtp.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * HTTP endpoints for retreiving and deleting emails
 */
@Controller
public class MailController {

	private EmailRepository emailRepository;

	@Autowired
	public MailController(EmailRepository emailRepository) {
		this.emailRepository = emailRepository;
	}

//	@RequestMapping("/")
//	public String root() {
//		return "redirect:mail";
//	}

	/**
	 * Returns all in-memory emails
	 * @return
	 */
	@RequestMapping(
		path = "/mail",
		method = RequestMethod.GET
	)
	@ResponseBody
	public List<Email> getMail() {
		return (List<Email>) emailRepository.findAll();
	}

	/**
	 * Deletes all in-memory and file based emails
	 */
	@RequestMapping(
		path = "/mail",
		method = RequestMethod.DELETE
	)
	@ResponseBody
	public void deleteMail() {
		emailRepository.deleteAll();
	}
}