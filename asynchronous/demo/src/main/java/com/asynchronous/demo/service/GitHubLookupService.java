package com.asynchronous.demo.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.asynchronous.demo.model.User;

@Service
public class GitHubLookupService {

	private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);
	private final RestTemplate restTemplate;

	public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Async
	public CompletableFuture<User> findUser(String user) throws InterruptedException {
		logger.info("Looking up " + user);
		String url = String.format("http://api.github.com/user/%s", user);
		
		User results = restTemplate.getForObject(url, User.class);
		
		Thread.sleep(1000L);
		
		// the method's return type CompletableFuture<User> instead of User
		return CompletableFuture.completedFuture(results);
	}
}
