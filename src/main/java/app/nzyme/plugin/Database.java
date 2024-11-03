/*
 * This file is part of nzyme-plugin.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Server Side Public License, version 1,
 * as published by MongoDB, Inc.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Server Side Public License for more details.
 *
 * You should have received a copy of the Server Side Public License
 * along with this program. If not, see
 * <http://www.mongodb.com/licensing/server-side-public-license>.
 */

package app.nzyme.plugin;

import liquibase.exception.LiquibaseException;
import org.jdbi.v3.core.HandleCallback;
import org.jdbi.v3.core.HandleConsumer;
import org.joda.time.DateTime;

public interface Database {

    void initialize() throws LiquibaseException;
    void migrate() throws LiquibaseException;

    long getTotalSize();
    DateTime getDatabaseClock();

    <R, X extends Exception> R withHandle(HandleCallback<R, X> callback) throws X;
    <X extends Exception> void useHandle(final HandleConsumer<X> callback) throws X;

}
