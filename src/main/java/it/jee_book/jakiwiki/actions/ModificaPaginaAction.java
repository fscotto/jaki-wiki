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

import it.jee_book.jakiwiki.business.pagine.PaginaManager;
import it.jee_book.jakiwiki.business.pagine.PaginaManagerDelegate;
import it.jee_book.jakiwiki.context.ContextObjectFactory;
import it.jee_book.jakiwiki.context.RequestObject;
import it.jee_book.jakiwiki.context.ResponseAndView;
import it.jee_book.jakiwiki.context.ResponseObject;
import it.jee_book.jakiwiki.controller.action.Action;
import it.jee_book.jakiwiki.exception.JakiWikiException;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class ModificaPaginaAction implements Action {

    private PaginaManager paginaManager = new PaginaManagerDelegate();

    public ResponseAndView createResponseAndView(RequestObject requestObject) throws JakiWikiException {
        ResponseObject response = ContextObjectFactory.getResponseObject();
        String titolo = (String) requestObject.getValue("titolo");

        response.setValue("titolo", titolo);
        response.setValue("contenuto", paginaManager.leggi(titolo));

        return new ResponseAndView(response, "edit");
    }

}
