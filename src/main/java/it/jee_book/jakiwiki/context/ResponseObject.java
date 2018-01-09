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
package it.jee_book.jakiwiki.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class ResponseObject {

    protected Map response = new HashMap();
    protected Map session = new HashMap();

    protected String responseCommand;

    /**
     * Imposta una chiave-valore nella richiesta corrente
     */
    public void setValue(String key, Object value) {
        response.put(key, value);
    }

    /**
     * Imposta chiave-valore nella sessione corrente
     */
    public void setValueInSession(String key, Object value) {
        session.put(key, value);
    }

    /**
     * Ritorna il valore associato ad una chiave, cercandolo prima nell
     * richiesta corrente e poi nella sessione.
     */
    public Object getValue(String key) {
        Object value = response.get(key);

        if (value == null) {
            return value = session.get(key);
        }

        if (value instanceof Object[]) {
            value = ((Object[]) value)[0];
        }

        return value;
    }

    /**
     * Ritorna tutte le chiavi a cui sono associati dei valore nella richiesta
     * corrente.
     */
    public Set getResponseKeys() {
        return response.keySet();
    }

    /**
     * Ritorna tutte le chiavi a cui sono associati dei valori nella sessione
     * corrente.
     */
    public Set getSessionKeys() {
        return session.keySet();
    }

    public String getResponseCommand() {
        return responseCommand;
    }

    public void setResponseCommand(String responseCommand) {
        this.responseCommand = responseCommand;
    }

}
