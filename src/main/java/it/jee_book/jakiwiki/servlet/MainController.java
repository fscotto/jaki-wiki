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
package it.jee_book.jakiwiki.servlet;

import it.jee_book.jakiwiki.context.ContextObjectFactory;
import it.jee_book.jakiwiki.context.RequestObject;
import it.jee_book.jakiwiki.context.ResponseAndView;
import it.jee_book.jakiwiki.context.ViewDispatcher;
import it.jee_book.jakiwiki.controller.ActionFactory;
import it.jee_book.jakiwiki.controller.Configuration;
import it.jee_book.jakiwiki.controller.action.Action;
import it.jee_book.jakiwiki.exception.JakiWikiException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class MainController extends HttpServlet {

    /**
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        Configuration.init(config);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JakiWikiException {
        RequestObject requestObject = ContextObjectFactory.getRequestObject(request);
        Action action = ActionFactory.createAction(requestObject);
        ResponseAndView responseObject = action.createResponseAndView(requestObject);
        dispatchView(request, response, responseObject);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (JakiWikiException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            handleRequest(request, response);
        } catch (JakiWikiException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param request
     * @param response
     * @param responseAndView
     * @throws JakiWikiException
     * @throws ServletException
     * @throws IOException
     */
    private void dispatchView(HttpServletRequest request, HttpServletResponse response, ResponseAndView responseAndView) throws JakiWikiException, ServletException, IOException {
        String view = responseAndView.getView();

        String resultPage = Configuration.getViewPage(view);

        if (resultPage == null) {
            throw new JakiWikiException(JakiWikiException.ACTION_ERROR, "Non è configurata alcuna action con il nome: " + view);
        }

        ViewDispatcher viewDispatcher = new ViewDispatcher(request.getRequestDispatcher(resultPage));
        viewDispatcher.forward(request, response, responseAndView);
    }

}
