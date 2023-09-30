package com.abdul.cinemamoviesservice.exception;

public class MovieAlreadyRegisteredException extends RuntimeException{

    public MovieAlreadyRegisteredException() {
        super("Movie already registered");
    }
}
