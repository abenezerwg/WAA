package waa.lab4.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import waa.lab4.domain.entity.Logger;
import waa.lab4.repository.LoggerRepository;

import java.util.Date;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private LoggerRepository loggerRepository;

    @Around("@annotation(waa.lab4.Aspects.ExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // Proceed with the original method execution
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // Log the execution time and other details to the 'Logger' table
        logExecutionTime(joinPoint, executionTime);

        return result;
    }

    private void logExecutionTime(ProceedingJoinPoint joinPoint, long executionTime) {
        Logger logger = new Logger();
        logger.setDate(new Date());
        logger.setTime(getCurrentTime());
        logger.setPrinciple("FakeStaticUser");
        logger.setOperation(joinPoint.getSignature().toShortString());

        // Save log to the database
        loggerRepository.save(logger);
    }

    private String getCurrentTime() {
        // Implement logic to get current time as a string
        return "CurrentTime";
    }
}
