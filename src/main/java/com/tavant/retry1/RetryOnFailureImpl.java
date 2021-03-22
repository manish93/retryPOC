package com.tavant.retry1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetryOnFailureImpl implements RetryOnFailure {
    /**
     * This method retries the operation 3 times before routing to the recoverDefault method
     *
     * @param list
     */
    @Override
    public void retryOnException(List<Integer> list, List<Integer> list2) throws Exception{

        try {
            list2.add(list.get(0));
            list.get(10);
        } catch (Exception e) {
            list2.add(list.get(0));
            //list.add(32);
            list.remove(0);
            //list2.add(list.get(0));
            throw new Exception();
        }
    }

    @Override
    public void recoverDefault(Exception e, List<Integer> list, List<Integer> list2) {

        System.out.println("The new size of the list is : " + list.size());
        System.out.println("Elements of the list are : " + list.toString());

        System.out.println("The size of list2 is : " + list2.size());
        System.out.println("Elements of list2 are : " + list2.toString());
    }
}
