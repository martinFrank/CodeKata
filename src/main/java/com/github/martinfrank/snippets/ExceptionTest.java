package com.github.martinfrank.snippets;

import java.io.IOException;

public class ExceptionTest {


    public void handleException() throws IOException {
        try{
            throwingMethod();
        }catch (IOException e){
            throw new IOException("Reason: Inputfile ", e);
        }
    }

    public void exampleMain(){
        try{
            handleException();
        }catch (IOException e){
            int errorCode = getErrorCode(e.getMessage());

        }
    }

    private int getErrorCode(String message) {
        switch (message){
            case "Invalid imput" : return 1;
            default: return 4; // unknown error
        }
    }


    public void throwingMethod() throws IOException {
        throw new IOException();
    }
}
