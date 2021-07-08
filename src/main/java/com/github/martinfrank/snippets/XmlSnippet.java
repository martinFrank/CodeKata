package com.github.martinfrank.snippets;

public class XmlSnippet {

    public static void main (String[] args){
        for (int dy = 0; dy < 24; dy ++){
            System.out.println("<!-- "+dy+" -->");
            for (int dx = 0; dx < 24; dx ++){
                System.out.println("<field x=\""+dx+"\" y=\""+dy+"\" type=\"WATER\"/>");
            }

        }

    }

}
