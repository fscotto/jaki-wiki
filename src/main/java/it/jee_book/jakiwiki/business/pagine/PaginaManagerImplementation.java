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

import it.jee_book.jakiwiki.integration.dao.PaginaDao;
import it.jee_book.jakiwiki.model.Pagina;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Fabio Scotto di Santolo
 */
@Stateless
public class PaginaManagerImplementation implements PaginaManager {

    @EJB
    private PaginaDao dao;

    public void save(Pagina pagina) {
        dao.salva(pagina);
    }

    public void elimina(String titolo) {
        Pagina pagina = leggi(titolo);
        dao.elimina(pagina);
    }

    public Pagina leggi(String titolo) {
        Pagina p = dao.leggi(titolo);

        if (p == null) {
            p = new Pagina();
            p.setTitolo("");
            p.setUltimaModifica(new Date());
            p.setContenuto("Questa è una nuova pagina");
        }

        return p;
    }

    public List elencaPagine() {
        return dao.elencaPagine(0);
    }

    public List elencaPagineRecenti() {
        return dao.elencaPagine(3);
    }

}
