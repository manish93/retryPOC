package com.tavant.retry1;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.List;

@SpringBootApplication
@EnableRetry
@Configuration
public class Retry1Application {

	public static void main(String[] args) {
		SpringApplication.run(Retry1Application.class, args);
	}

	//@Bean
	MethodInterceptor argumentChanger() {
		adfjsdf
		RetryTemplate retryTemplate = new RetryTemplate();
		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(3);
		FixedBackOffPolicy backOff = new FixedBackOffPolicy();
		backOff.setBackOffPeriod(1000L);
		retryTemplate.setRetryPolicy(retryPolicy);
		retryTemplate.setBackOffPolicy(backOff);
		return invocation -> {
			return retryTemplate.execute(context -> {
				if (context.getRetryCount() > 2) {
					Object[] args = invocation.getArguments();
					int size = ((List<Integer>) args[0]).size();
					args[0] = ((List<Integer>) args[0]).remove(size-1);
				}
				return invocation.proceed();
			});
		};
	}//

}
