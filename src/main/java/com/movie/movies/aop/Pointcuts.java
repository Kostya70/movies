package com.movie.movies.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* com.movie.movies.service.MovieServiceImpl.get*(..))")
    public void allGetMethods(){}

    @Pointcut("execution(* com.movie.movies.service.MovieServiceImpl.save*(..))")
    public void allSaveMethods(){}
}
