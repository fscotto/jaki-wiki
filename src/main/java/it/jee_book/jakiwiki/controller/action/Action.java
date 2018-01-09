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
package it.jee_book.jakiwiki.controller.action;

import it.jee_book.jakiwiki.context.RequestObject;
import it.jee_book.jakiwiki.context.ResponseAndView;
import it.jee_book.jakiwiki.exception.JakiWikiException;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public interface Action {

    /**
     *
     * @param requestObject
     * @return
     * @throws it.jee_book.jakiwiki.exception.JakiWikiException
     */
    ResponseAndView createResponseAndView(RequestObject requestObject) throws JakiWikiException;

}
