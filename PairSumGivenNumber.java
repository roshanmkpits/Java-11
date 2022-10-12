package arrayexecise;


//Write a program to find all pairs of integers whose sum is equal to a given number.
//
//        Examples
//
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Output: Because nums[0] + nums[1] == 9, we return [0, 1]
//
//
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]


import java.util.Arrays;

public class PairSumGivenNumber {
    public static void main(String[] args) {
        PairSumGivenNumber number=new PairSumGivenNumber();
        int []nums = {2,7,11,15};
       int temp[]= number.sumPair(nums,9);
        System.out.println("pair "+ Arrays.toString(temp));

    }
    public int[] sumPair(int arry[],int traget) {
        for (int i = 0; i < arry.length; i++) {
            for (int j = i+1; j < arry.length; j++) {
                if(arry[i]+arry[j]==traget) {
                    return new int[]{i,j};
                }

            }

        }
        throw new IllegalArgumentException("no solution ");

    }
}

//output
//pair [0, 1]