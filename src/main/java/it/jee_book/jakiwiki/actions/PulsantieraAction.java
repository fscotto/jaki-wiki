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
package it.jee_book.jakiwiki.actions;

import it.jee_book.jakiwiki.context.RequestObject;
import it.jee_book.jakiwiki.context.ResponseAndView;
import it.jee_book.jakiwiki.controller.action.Action;
import it.jee_book.jakiwiki.exception.JakiWikiException;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class PulsantieraAction implements Action {

    private final String PRINCIPALE = "principale";
    private final String RECENTI = "recenti";
    private final String TUTTE = "tutte";
    private final String EMAIL = "email";
    private final String CONFIGURA = "configura";

    @Override
    public ResponseAndView createResponseAndView(RequestObject requestObject) throws JakiWikiException {

        if (requestObject.getValue(PRINCIPALE) != null) {
            requestObject.setValue("titolo", null);
            return new VediPaginaAction().createResponseAndView(requestObject);
        }

        if (requestObject.getValue(TUTTE) != null) {
            requestObject.setValue("tipo_richiesta", "tutte");
            return new ListaPagineAction().createResponseAndView(requestObject);
        }

        if (requestObject.getValue(RECENTI) != null) {
            requestObject.setValue("tipo_richiesta", "recenti");
            return new ListaPagineAction().createResponseAndView(requestObject);
        }

        if (requestObject.getValue(EMAIL) != null) {
            return new ResponseAndView(null, "email");
        }

        throw new JakiWikiException("Action non valida");
    }
}
