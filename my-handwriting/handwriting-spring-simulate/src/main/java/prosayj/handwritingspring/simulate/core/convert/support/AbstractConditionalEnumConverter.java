/*
 * Copyright 2002-2017 the original author or authors.
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

package prosayj.handwritingspring.simulate.core.convert.support;


import prosayj.handwritingspring.simulate.core.convert.ConversionService;
import prosayj.handwritingspring.simulate.core.convert.TypeDescriptor;
import prosayj.handwritingspring.simulate.core.convert.converter.ConditionalConverter;
import prosayj.handwritingspring.simulate.util.ClassUtils;

/**
 * A {@link ConditionalConverter} base implementation for enum-based converters.
 *
 * @author Stephane Nicoll
 * @since 4.3
 */
abstract class AbstractConditionalEnumConverter implements ConditionalConverter {

	private final ConversionService conversionService;


	protected AbstractConditionalEnumConverter(ConversionService conversionService) {
		this.conversionService = conversionService;
	}


	@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		for (Class<?> interfaceType : ClassUtils.getAllInterfacesForClassAsSet(sourceType.getType())) {
			if (this.conversionService.canConvert(TypeDescriptor.valueOf(interfaceType), targetType)) {
				return false;
			}
		}
		return true;
	}

}