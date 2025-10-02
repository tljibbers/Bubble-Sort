package com.project544.bubblesortapp.service;

import com.project544.bubblesortapp.model.NumbersResponse;
import com.project544.bubblesortapp.model.SortStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * BubbleSort Algorithm
 */
@Service
public class BubbleSortService {
    private static final Logger logger= LoggerFactory.getLogger(BubbleSortService.class);

    public NumbersResponse sort(List<Integer> numbers){
        logger.info("Sorting started. Numbers: {}", numbers);
        List<Integer> numList=new ArrayList<>(numbers);
        List<SortStep> steps=new ArrayList<>();
        int n=numList.size();

        for(int i=0;i<n-1;i++){
            boolean swapped=false;
            //start-of-pass
            steps.add(new SortStep(List.copyOf(numList),i,n-1,i+1,"start-of-pass"));

            for(int j=n-1;j>i;j--){
                if(numList.get(j)<numList.get(j-1)){
                    logger.debug("Swapping {} and {}", numList.get(j-1), numList.get(j));
                    //swap step
                    steps.add(new SortStep(List.copyOf(numList),j-1,j,i+1,"swap"));

                    int temp=numList.get(j);
                    numList.set(j,numList.get(j-1));
                    numList.set(j-1, temp);
                    swapped = true;
                }
            }
            logger.info("Array after pass {}:{}", i+1, numList);
            steps.add(new SortStep(List.copyOf(numList),null,null,i+1,"end-of-pass"));
            if(!swapped){
                break;
            }
        }
        logger.info("Sorting finished. Numbers: {}", numList);
        
        return new NumbersResponse(steps);
    }
}
