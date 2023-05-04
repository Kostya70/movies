package com.movie.movies.aop;

import com.movie.movies.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspect {
    @Around("Pointcuts.allSaveMethods()")
    public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint) { //доступ к сигнатуре вызываемогог метода и аргументам которые переданы
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Movie movie = null;
        if (methodSignature.getName().equals("saveMovie")) {
            Object[] arguments = joinPoint.getArgs();//собираю все аргументы которые передавались с этим методом
            for (Object arg : arguments) {
                if (arg instanceof Movie) {
                    movie = (Movie) arg;
                    log.info("Попытка добавить фильм {}", movie.getTitle());
                }
            }
        }

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
        log.info("Добавлен фильм {}", movie.getTitle());
        return result;
    }

    @Around("Pointcuts.allGetMethods()")
    public Object aroundGettingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String title = null;

        if (methodSignature.getName().equals("getAllMovies")) {
            log.info("Попытка получить все фильмы");
        } else if (methodSignature.getName().equals("getMovie")) {
            Object[] arguments = joinPoint.getArgs();//собираю все аргументы которые передавались с этим методом
            for (Object arg : arguments) {
                if (arg instanceof String) {
                    title = (String) arg;
                    log.info("Попытка получить фильм {}", title);
                }
            }
        }

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }

        if (methodSignature.getName().equals("getAllMovies"))
            log.info("Все фильмы получены");
        else if (methodSignature.getName().equals("getMovie")) {
            log.info("Фильм с названием {} получен" , title);
        }
        return result;
    }
}
