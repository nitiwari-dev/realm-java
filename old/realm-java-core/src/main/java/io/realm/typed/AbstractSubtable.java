/*
 * Copyright 2014 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.typed;

import io.realm.Table;

/**
 * Super-type of the generated XyzTable classes for the Xyz nested table.
 */
public abstract class AbstractSubtable<Cursor, View, Query> extends AbstractTable<Cursor, View, Query> {

    public AbstractSubtable(EntityTypes<?, View, Cursor, Query> types, Table subtable) {
        super(types, subtable);
    }

    protected static <S> S createSubtable(Class<S> subtableClass, Table subtableBase) {
        try {
            S subtable = subtableClass.getConstructor(Table.class).newInstance(subtableBase);
            return subtable;
        } catch (Exception e) {
            throw new RuntimeException("Cannot create subtable instance!", e);
        }
    }

}
