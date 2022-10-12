package arrayexecise;
//Write a program to check if an array is unique or not.
//
//        Example
//
//        int[] intArray = {1,2,3,4,5,6};
//        isUnique(intArray) // true
public class UniqueArray {
    public static void main(String[] args) {
        UniqueArray array=new UniqueArray();
        int[] intArray = {1,2,3,4,5,6};
       boolean res= array.uniqueArray(intArray);
        System.out.println(res);

    }
    public boolean uniqueArray(int []arry)
    {
        for (int i = 0; i < arry.length; i++) {
            for (int j = i+1; j < arry.length; j++) {
                if(arry[i]==arry[j]){
                    return false;
                }

            }

        }
        return true;
    }
}

//output
//true