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

/**
 *
 * @author Fabio Scotto di Santolo
 */
class ListaPagineAction implements Action {

    private PaginaManager paginaManager = new PaginaManagerDelegate();

    @Override
    public ResponseAndView createResponseAndView(RequestObject requestObject) {
        ResponseObject response = ContextObjectFactory.getResponseObject();
        String tipoRichiesta = (String) requestObject.getValue("tipo_richiesta");

        if ("tutte".equals(tipoRichiesta)) {
            response.setValue("intestazione", "Tutte le pagine");
            response.setValue("lista", paginaManager.elencaPagine());
        } else {
            response.setValue("intestazione", "Ultime pagine modificate");
            response.setValue("lista", paginaManager.elencaPagineRecenti());
        }

        return new ResponseAndView(response, "list");
    }

}
