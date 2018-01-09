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
package it.jee_book.jakiwiki.tag;

import it.jee_book.jakiwiki.model.Pagina;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class ListaPagine extends SimpleTagSupport {

    private List pagine;

    public List getPagine() {
        return pagine;
    }

    public void setPagine(List pagine) {
        this.pagine = pagine;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (getPagine() == null || getPagine().size() == 0) {
            return;
        }

        getJspContext().getOut().write("<table cellpadding = '10'>"
                + "<tr><td><b>Titolo</b></td><td><b>Data ultima"
                + " modifica</b></td><td></td><td></td></tr>");

        for (int i = 0; i < getPagine().size(); i++) {
            Pagina pagina = (Pagina) getPagine().get(i);
            String line = "<tr><td><a href='main.action?titolo="
                    + pagina.getTitolo() + "'>" + pagina.getTitolo()
                    + "</a></td>\n";
            line += "<td>" + pagina.getUltimaModifica() + "</td>\n";
            line += "<td><a href='edit.action?titolo=" + pagina.getTitolo()
                    + "'>Modifica</a></td>\n";
            line += "<td><a href='elimina.action?titolo=" + pagina.getTitolo()
                    + "'>Elimina</a></td></tr>\n";
            getJspContext().getOut().write(line);
        }
        getJspContext().getOut().write("</table>");
    }
}
