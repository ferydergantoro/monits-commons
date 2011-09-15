/*

   Copyright 2011 Monits
 
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/



/**
 * Field MatchValidator.
 *
 * @copyright 2010 Monits
 * @license Apache 2.0 License
 * @version Release: 1.0.0
 * @link http://www.monits.com/
 * @since 1.0.0
 */
package com.monits.commons.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Field MatchValidator.
 *
 * @author jborda <jborda@monits.com>
 * @copyright 2010 Monits
 * @license Apache 2.0 License
 * @version Release: 1.0.0
 * @link http://www.monits.com/
 * @since 1.0.0
 */
public class FieldMatchValidator implements
		ConstraintValidator<FieldMatch, Object> {
	private String firstFieldName;
	private String secondFieldName;
	private FieldMatchType type;

	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		type = constraintAnnotation.type();
	}

	@Override
	public boolean isValid(final Object value,
			final ConstraintValidatorContext context) {
		try {
			final Object firstObj = PropertyUtils.getProperty(value,
					firstFieldName);
			final Object secondObj = PropertyUtils.getProperty(value,
					secondFieldName);

			return type.isValid(firstObj, secondObj);
		} catch (final Exception ignore) {
			// ignore
		}
		return true;
	}
}