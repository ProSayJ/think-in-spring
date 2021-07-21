/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.expection_;

import org.springframework.beans.factory.support.bean_.definition_.AbstractBeanDefinition;

/**
 * Exception thrown when a bean instance has been requested for
 * a bean definition which has been marked as abstract.
 *
 * @author Juergen Hoeller
 * @since 1.1
 * @see AbstractBeanDefinition#setAbstract
 */
@SuppressWarnings("serial")
public class BeanIsAbstractException extends BeanCreationException {

	/**
	 * Create a new BeanIsAbstractException.
	 * @param beanName the name of the bean requested
	 */
	public BeanIsAbstractException(String beanName) {
		super(beanName, "Bean definition is abstract");
	}

}
