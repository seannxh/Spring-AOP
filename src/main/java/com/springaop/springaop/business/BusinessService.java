package com.springaop.springaop.business;


import com.springaop.springaop.data.DataService1;
import com.springaop.springaop.data.TrackTime;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService {

    private DataService1 dataService1;

    public BusinessService(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }
    @TrackTime
    public int calculateMax(){
        int[] data = dataService1.retrieveData();
        try{
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e) {
            };
        }
        //throw new RuntimeException("Something Went Wrong");
        int maxNumber = Arrays.stream(data).max().orElse(0);
        return maxNumber;
    }
}
