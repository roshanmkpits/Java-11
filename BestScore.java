package array13;

import java.util.Arrays;
import java.util.Collections;

//Given an array, write a function to get first, second best scores from the array.
//
//        Array may contain duplicates.
//
//        Example
//
//        myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
//        firstSecond(myArray) // 90 87
public class BestScore {
    public static void main(String[] args) {
        BestScore score=new BestScore();
        Integer []myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
        String res=score.fristSecond(myArray);
        System.out.println(res);

    }
    public String fristSecond(Integer []arry) {
        Integer[] arr =arry;
        Arrays.sort(arr,Collections.reverseOrder());
        int frist=arr[0];
        Integer second=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=frist){
                second=arr[i];
                break;
            }

        }
        return ""+frist+" "+second;

    }
}

//output
//90 87