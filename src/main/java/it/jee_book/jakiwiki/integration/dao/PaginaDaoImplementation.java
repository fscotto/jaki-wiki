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
package it.jee_book.jakiwiki.integration.dao;

import it.jee_book.jakiwiki.model.Pagina;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Fabio Scotto di Santolo
 */
@Stateless
public class PaginaDaoImplementation implements PaginaDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void salva(Pagina pagina) {
        entityManager.merge(pagina);
    }

    public void elimina(Pagina pagina) {
        entityManager.remove(pagina);
    }

    public Pagina leggi(String titolo) {
        return entityManager.find(Pagina.class, titolo);
    }

    public List elencaPagine(int maxRisultati) {
        Query query = entityManager.createQuery("SELECT p FROM Pagina p");

        if (maxRisultati > 0) {
            query.setMaxResults(3);
        }

        return query.getResultList();
    }

}
