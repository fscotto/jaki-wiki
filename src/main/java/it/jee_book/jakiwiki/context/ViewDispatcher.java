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

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class ViewDispatcher {

    protected RequestDispatcher dispatcher;

    /**
     *
     * @param requestDispatcher
     */
    public ViewDispatcher(RequestDispatcher requestDispatcher) {
        dispatcher = requestDispatcher;
    }

    /**
     *
     * @param request
     * @param response
     * @param responseAndView
     * @throws ServletException
     * @throws IOException
     */
    public void forward(HttpServletRequest request, HttpServletResponse response, ResponseAndView responseAndView)
            throws ServletException, IOException {
        mergeDataRequest(request, responseAndView.getResponseObject());
        dispatcher.forward(request, response);
    }

    private void mergeDataRequest(HttpServletRequest request, ResponseObject responseObject) {

        if (responseObject == null) {
            return;
        }

        for (Iterator listaParams = responseObject.getResponseKeys().iterator(); listaParams.hasNext();) {
            String key = (String) listaParams.next();
            request.setAttribute(key, responseObject.getValue(key));
        }

        for (Iterator listaParams = responseObject.getSessionKeys().iterator(); listaParams.hasNext();) {
            String key = (String) listaParams.next();
            request.getSession().setAttribute(key, responseObject.getValue(key));
        }
    }
}
