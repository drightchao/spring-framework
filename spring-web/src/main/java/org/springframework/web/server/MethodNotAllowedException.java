/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.web.server;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

/**
 * Exception for errors that fit response status 405 (method not allowed).
 *
 * @author Rossen Stoyanchev
 */
@SuppressWarnings("serial")
public class MethodNotAllowedException extends ResponseStatusException {

	private String method;

	private Set<String> supportedMethods;


	public MethodNotAllowedException(String method, Collection<String> supportedMethods) {
		super(HttpStatus.METHOD_NOT_ALLOWED, "Request method '" + method + "' not supported");
		Assert.notNull(method, "'method' is required");
		this.method = method;
		this.supportedMethods = Collections.unmodifiableSet(new HashSet<>(supportedMethods));
	}


	/**
	 * Return the HTTP method for the failed request.
	 */
	public String getHttpMethod() {
		return this.method;
	}

	/**
	 * Return the list of supported HTTP methods.
	 */
	public Set<String> getSupportedMethods() {
		return supportedMethods;
	}
}
