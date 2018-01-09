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

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class ContextObjectFactory {

    /**
     *
     * @param request
     * @return
     */
    public static RequestObject getRequestObject(HttpServletRequest request) {

        RequestObject ret = new RequestObject();
        String path = request.getServletPath().split(".action")[0];

        if (path.startsWith("/")) {
            path.substring(1);
        }

        ret.setRequestCommand(path);

        // mappa i parametri della request
        Map pMap = request.getParameterMap();
        for (Iterator listaParams = pMap.keySet().iterator(); listaParams.hasNext();) {
            String key = (String) listaParams.next();
            ret.request.put(key, pMap.get(key));
        }

        // mappa i parametri della sessione
        for (Enumeration listaSession = request.getSession().getAttributeNames(); listaSession.hasMoreElements();) {
            String key = (String) listaSession.nextElement();
            ret.session.put(key, request.getSession().getAttribute(key));
        }

        return ret;
    }

    public static ResponseObject getResponseObject() {
        return new ResponseObject();
    }
}
