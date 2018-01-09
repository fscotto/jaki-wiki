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
package it.jee_book.jakiwiki.controller;

import it.jee_book.jakiwiki.context.RequestObject;
import it.jee_book.jakiwiki.controller.action.Action;
import it.jee_book.jakiwiki.exception.JakiWikiException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class ActionFactory {

    protected static Map actions = new HashMap();

    /**
     *
     * @param requestObject
     * @return
     * @throws JakiWikiException
     */
    public static Action createAction(RequestObject requestObject) throws JakiWikiException {

        String requestCommand = requestObject.getRequestCommand().substring(1);
        Action action = (Action) actions.get(requestCommand);

        if (action == null) {
            String actionClassName = Configuration.getAction(requestCommand);

            if (actionClassName == null) {
                throw new JakiWikiException(JakiWikiException.ACTION_ERROR, "Non esiste nessuna action");
            }

            try {
                action = (Action) Class.forName(actionClassName).newInstance();
                actions.put(requestCommand, action);
            } catch (Throwable t) {
                throw new JakiWikiException(JakiWikiException.ACTION_ERROR, actionClassName, t);
            }
        }

        return action;
    }

}
