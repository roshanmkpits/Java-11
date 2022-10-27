
//Describe how you could use a single Array to implement three stacks.
class ThreeInOne {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public boolean isFull(int stackNum) {
        if (sizes[stackNum] == stackCapacity) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isEmpty(int stackNum) {
        if (sizes[stackNum] == 0) {
            return true;
        } else {
            return false;
        }
    }



    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            System.out.println("The Stack is Full");
        } else {
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }
    }


    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("The Stack is Empty");
            return -1;
        } else {
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return value;
        }
    }

    // peek

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("The Stack is Empty");
            return -1;
        } else {
            return values[indexOfTop(stackNum)];
        }
    }

}



public class ThreeOneMain {
    public static void main(String[] args) {
        ThreeInOne threeInOne=new ThreeInOne(3);
        threeInOne.push(0,23);
        threeInOne.push(0,24);
        threeInOne.push(0,223);
        threeInOne.push(1,233);
        threeInOne.push(1,264);
        threeInOne.push(2,235);
        threeInOne.push(2,238);
        int res =threeInOne.peek(0);
        System.out.println("oth stack peek "+res);
         res =threeInOne.peek(1);
        System.out.println("1 st stack peek"+res);

    }
}

//    oth stack peek 223
//        1 st stack peek264