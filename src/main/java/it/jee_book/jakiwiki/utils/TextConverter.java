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
package it.jee_book.jakiwiki.utils;

/**
 *
 * @author Fabio Scotto di Santolo
 */
public class TextConverter {

    /**
     * Converte il testo inserito dall'utente in sintassi wiki
     *
     * @param input
     * @return
     */
    public static String convert(String input) {

        // sostituisce gli a capo con <br>
        input = input.replaceAll("\n", " <br /> ");

        // crea la wiki-syntax
        String[] tokens = input.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (isWikiWord(tokens[i])) {
                tokens[i] = creaLink(tokens[i]);
            }
        }

        return componiToken(tokens);
    }

    private static boolean isWikiWord(String word) {
        if (word == null || word.length() < 4) {
            return false;
        }

        if (Character.isUpperCase(word.charAt(0)) && Character.isLowerCase(word.charAt(1))
                && !(word.substring(2).toLowerCase().equals(word.substring(2)))) {
            return true;
        }

        return false;
    }

    private static String componiToken(String[] tokens) {
        String output = "";

        for (int i = 0; i < tokens.length; i++) {
            output += tokens[i] + " ";
        }

        return output;
    }

    private static String creaLink(String word) {
        return "<a href='main.action?titolo=" + word + "'>" + word + "</a>";
    }

}
