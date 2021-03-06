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
package com.monits.commons.model;

import org.joda.time.DateTime;

/**
 * Interface that specifies that the entity has a creation date. Implementors
 * should have a field name with the same name as
 * {@link CreationDateable#FIELD_NAME} for the {@link CreationDateInterceptor}
 * to work
 *
 */
public interface CreationDateable {

	public static final String FIELD_NAME = "creationDate";

	DateTime getCreationDate();
}
