package com.psf.psfrest;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEmailTools

public class PsfRestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PsfRestApplication.class, args);
		Thread premium = new Thread(ctx.getBean(PremiumUsersCheck.class));
		premium.start();
		System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "{}");
	}
}
