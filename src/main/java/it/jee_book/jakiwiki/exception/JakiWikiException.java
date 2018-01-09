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
package it.jee_book.jakiwiki.exception;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class JakiWikiException extends Throwable {

    public static final String ACTION_ERROR = "Azione errata";
    public static String SERVICE_CONNECTION_ERROR = "Errore di connessione al servizio";

    private String error;
    private String msg;
    private Throwable exception;

    public JakiWikiException(String error, String msg) {
        this(error, msg, null);
    }

    public JakiWikiException(String error, String msg, Throwable exception) {
        this.error = error;
        this.msg = msg;
        this.exception = exception;
    }

    public JakiWikiException(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

}
