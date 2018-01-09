/*
 * Copyright 2016 Fabio Scotto di Santolo.
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
package it.jee_book.jakiwiki.business;

import it.jee_book.jakiwiki.exception.JakiWikiException;
import javax.naming.InitialContext;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public abstract class AbstractDelegate {

    /**
     * In ogni delegato è necessario implementare questo metodo in modo che
     * ritorni il nome jndi del servizio.
     *
     * @return il nome del servizio
     */
    protected abstract String getServiceName();

    /**
     * Accede al servizio
     *
     * @return
     */
    protected Object getService() throws JakiWikiException {
        InitialContext context;

        try {
            context = new InitialContext();
            Object lookup = context.lookup(getServiceName());
            return lookup;
        } catch (Exception e) {
            throw new JakiWikiException(JakiWikiException.SERVICE_CONNECTION_ERROR, "Non esiste il servizio denominato "
                    + getServiceName(), e);
        }
    }
}
