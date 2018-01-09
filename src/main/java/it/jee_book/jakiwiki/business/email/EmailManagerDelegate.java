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
package it.jee_book.jakiwiki.business.email;

import it.jee_book.jakiwiki.business.AbstractDelegate;
import it.jee_book.jakiwiki.exception.JakiWikiException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class EmailManagerDelegate extends AbstractDelegate implements EmailManager {

    @Override
    protected String getServiceName() {
        return "java:global/JakiWiki/EmailManager";
    }

    public void sendEmail(String mittente, String destinatario, String commento, String titolo) {
        try {
            ((EmailManager) getService()).sendEmail(mittente, destinatario, commento, titolo);
        } catch (JakiWikiException ex) {
            Logger.getLogger(EmailManagerDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
