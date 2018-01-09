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

import it.jee_book.jakiwiki.model.Pagina;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Fabio Scotto di Santolo
 */
@Local
public interface PaginaManager {

    /**
     *
     * @param pagina
     */
    public void save(Pagina pagina);

    /**
     *
     * @param titolo
     */
    public void elimina(String titolo);

    /**
     *
     * @param titolo
     * @return la pagina con che si chiama titolo
     */
    public Pagina leggi(String titolo);

    /**
     *
     * @return l'elenco di tutte le pagine
     */
    public List elencaPagine();

    /**
     *
     * @return l'elenco di tutte le recenti pagine
     */
    public List elencaPagineRecenti();

}
