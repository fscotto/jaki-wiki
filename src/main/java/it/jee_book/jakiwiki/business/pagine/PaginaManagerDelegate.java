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
package it.jee_book.jakiwiki.business.pagine;

import it.jee_book.jakiwiki.business.AbstractDelegate;
import it.jee_book.jakiwiki.exception.JakiWikiException;
import it.jee_book.jakiwiki.model.Pagina;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class PaginaManagerDelegate extends AbstractDelegate implements PaginaManager {

    @Override
    protected String getServiceName() {
        return "java:global/JakiWiki/PaginaManagerImplementation";
    }

    public void save(Pagina pagina) {
        try {
            ((PaginaManager) getService()).save(pagina);
        } catch (JakiWikiException ex) {
            Logger.getLogger(PaginaManagerDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void elimina(String titolo) {
        try {
            ((PaginaManager) getService()).elimina(titolo);
        } catch (JakiWikiException ex) {
            Logger.getLogger(PaginaManagerDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pagina leggi(String titolo) {
        try {
            return ((PaginaManager) getService()).leggi(titolo);
        } catch (JakiWikiException ex) {
            Logger.getLogger(PaginaManagerDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List elencaPagine() {
        try {
            ((PaginaManager) getService()).elencaPagine();
        } catch (JakiWikiException ex) {
            Logger.getLogger(PaginaManagerDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List elencaPagineRecenti() {
        try {
            return ((PaginaManager) getService()).elencaPagineRecenti();
        } catch (JakiWikiException ex) {
            Logger.getLogger(PaginaManagerDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
