package com.springaop.springaop.data;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retrieveData(){
        return new int[] {1, 2, 3, 4, 5, 20};
    }
}
