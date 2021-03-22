package com.tavant.retry1;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import java.util.List;

public interface RetryOnFailure {

    /**
     * This method retries the operation 3 times before routing to the recoverDefault method
     */
    @Retryable(value = Exception.class)
    void retryOnException(List<Integer> list, List<Integer> list2) throws Exception;


    @Recover
    void recoverDefault(Exception e, List<Integer> list, List<Integer> list2);
}
