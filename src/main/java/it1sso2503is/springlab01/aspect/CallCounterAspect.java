
package it1sso2503is.springlab01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class CallCounterAspect {

    private final Map<String, Integer> counters =
            new ConcurrentHashMap<>();

    @Before("it1sso2503is.springlab01.aspect.Pointcuts.serviceOperation()")
    public void countCall(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();

        counters.merge(method, 1, Integer::sum);
    }

    public Map<String, Integer> getStatistics() {
        return new ConcurrentHashMap<>(counters);
    }
}
