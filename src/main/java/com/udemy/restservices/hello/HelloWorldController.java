package com.udemy.restservices.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.restservices.hello.model.UserDetails;

@RestController
public class HelloWorldController {

	@Autowired
	private ResourceBundleMessageSource messageResource;

	@GetMapping("/helloworld")
	public String helloWorld() {
		return "HelloWorld";
	}

	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Paavo", "Silva", "Curitiba");
	}

	@GetMapping("/hello-int")
	public String getMessagesInI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String locale) {
		return messageResource.getMessage("label.hello", null, new Locale(locale));
	}

	@GetMapping("/hello-int2")
	public String getMessagesInI18NFormat2() {
		return messageResource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
	}
}
