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
 * GenericDao interface
 *
 * @copyright 2010 Monits
 * @license   Apache 2.0 License
 * @version   Release: 1.0.0
 * @link      http://www.monits.com/
 * @since     1.0.0
 */
package com.monits.commons.dao;

import java.util.List;

import com.monits.commons.PaginatedResult;
import com.monits.commons.model.Builder;

/**
 * GenericDao interface
 *
 * @author    jborda  <jborda@monits.com>
 * @author    lbritez <lbritez@monits.com>
 * @copyright 2010 Monits
 * @license   Apache 2.0 License
 * @version   Release: 1.0.0
 * @link      http://www.monits.com/
 * @since     1.0.0
 */
public interface GenericDao<E> {

	/**
	 * Retrieve an instance with the given {@code id}
	 *
	 * @param id The id of the {@link E}
	 *
	 * @return {@code E}
	 */
	E get(Long id);

	/**
	 * Returns all the {@code E} instances
	 *
	 * @return list {@link List<E>} with all {@code E} instances
	 */
	List<? extends E> getAll();

	/**
	 * Same behaviour as {@link #getAll()} but allows pagination.
	 *
	 * @param page current page to fetch (The first page is zero).
	 * @param amount maximum amount of results.
	 *
	 * @return paginated results
	 */
	PaginatedResult<E> getAll(int page, int amount);

	/**
	 * Deletes the given entity
	 *
	 * @param entity
	 *            to be deleted
	 */
	void delete(E entity);

	/**
	 * Create a new entity.
	 *
	 * @param builder The entity builder.
	 *
	 * @return The entity created.
	 */
	<T extends E> T create(Builder<T> builder);

	/**
	 * Updates an existant entity.
	 * @param entity to be updated.
	 */
	void update(E entity);
}