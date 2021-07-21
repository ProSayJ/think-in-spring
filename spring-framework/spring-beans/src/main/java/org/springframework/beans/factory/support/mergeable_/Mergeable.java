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

package org.springframework.beans.factory.support.mergeable_;

import org.springframework.beans.factory.support.mergeable_.ManagedList;
import org.springframework.beans.factory.support.mergeable_.ManagedMap;
import org.springframework.beans.factory.support.mergeable_.ManagedProperties;
import org.springframework.beans.factory.support.mergeable_.ManagedSet;
import org.springframework.lang.Nullable;

/**
 * 可合并
 * <p>
 * Interface representing an object whose value set can be merged with that of a parent object.
 * <br>
 * 表示其值集可以与父对象的值集合并的对象的接口。
 *
 * @author Rob Harrop
 * @see ManagedSet
 * @see ManagedList
 * @see ManagedMap
 * @see ManagedProperties
 * @since 2.0
 */
public interface Mergeable {

    /**
     * Is merging enabled for this particular instance?
     */
    boolean isMergeEnabled();

    /**
     * Merge the current value set with that of the supplied object.
     * <p>The supplied object is considered the parent, and values in
     * the callee's value set must override those of the supplied object.
     *
     * @param parent the object to merge with
     * @return the result of the merge operation
     * @throws IllegalArgumentException if the supplied parent is {@code null}
     * @throws IllegalStateException    if merging is not enabled for this instance
     *                                  (i.e. {@code mergeEnabled} equals {@code false}).
     */
    Object merge(@Nullable Object parent);

}
