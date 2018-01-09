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
package it.jee_book.jakiwiki.controller;

import java.io.FileInputStream;
import java.util.Properties;
import javax.servlet.ServletConfig;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class Configuration {

    protected static Properties views;
    protected static Properties actions;

    /**
     *
     * @param config
     */
    public static void init(ServletConfig config) {
        String actionFile = config.getServletContext().getRealPath("WEB-INF/actions.properties");
        String viewsFile = config.getServletContext().getRealPath("WEB-INF/views.properties");
        views = new Properties();
        actions = new Properties();
        try {
            views.load(new FileInputStream(viewsFile));
            actions.load(new FileInputStream(actionFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param view
     * @return
     */
    public static String getViewPage(String view) {
        return views.getProperty(view);
    }

    /**
     *
     * @param action
     * @return
     */
    public static String getAction(String action) {
        return actions.getProperty(action);
    }

}
