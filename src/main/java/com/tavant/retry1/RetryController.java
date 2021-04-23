package com.tavant.retry1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/listData")
public class RetryController {

    @Autowired
    RetryOnFailure retryOnFailure;

    @GetMapping("/listElements")
    public void listElements() {
        List<Integer> list = Arrays.asList(1,3,5,7,2);
        try {
            retryOnFailure.retryOnException(list, new ArrayList<Integer>());
        } catch (Exception e) {
            System.out.print("What's Up");
            e.printStackTrace();
        }

    }
}
