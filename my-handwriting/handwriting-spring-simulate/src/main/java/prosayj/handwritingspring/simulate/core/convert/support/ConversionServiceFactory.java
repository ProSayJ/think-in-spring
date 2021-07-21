/*
 * Copyright 2002-2018 the original author or authors.
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

import prosayj.handwritingspring.simulate.core.convert.converter.Converter;
import prosayj.handwritingspring.simulate.core.convert.converter.ConverterFactory;
import prosayj.handwritingspring.simulate.core.convert.converter.ConverterRegistry;
import prosayj.handwritingspring.simulate.core.convert.converter.GenericConverter;
import prosayj.handwritingspring.simulate.core.lang.Nullable;

import java.util.Set;

/**
 * A factory for common {@link org.springframework.core.convert.ConversionService}
 * configurations.
 *
 * @author Keith Donald
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 3.0
 */
public final class ConversionServiceFactory {

	private ConversionServiceFactory() {
	}


	/**
	 * Register the given Converter objects with the given target ConverterRegistry.
	 * @param converters the converter objects: implementing {@link Converter},
	 * {@link ConverterFactory}, or {@link GenericConverter}
	 * @param registry the target registry
	 */
	public static void registerConverters(@Nullable Set<?> converters, ConverterRegistry registry) {
		if (converters != null) {
			for (Object converter : converters) {
				if (converter instanceof GenericConverter) {
					registry.addConverter((GenericConverter) converter);
				}
				else if (converter instanceof Converter<?, ?>) {
					registry.addConverter((Converter<?, ?>) converter);
				}
				else if (converter instanceof ConverterFactory<?, ?>) {
					registry.addConverterFactory((ConverterFactory<?, ?>) converter);
				}
				else {
					throw new IllegalArgumentException("Each converter object must implement one of the " +
							"Converter, ConverterFactory, or GenericConverter interfaces");
				}
			}
		}
	}

}