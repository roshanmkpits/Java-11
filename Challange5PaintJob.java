//The second parameter should be named height of type double. This parameter represents the height of the wall.
//
//        The third parameter should be named areaPerBucket. This parameter represents the area that can be covered with one bucket of paint.
//
//        The fourth parameter should be named extraBuckets. This parameter represents the bucket count that Bob has at home.
//
//        The method needs to return a value of type int that represents the number of buckets that Bob needs to buy before going to work. To calculate the bucket count, refer to the notes below.
//
//        If one of the parameters width, height or areaPerBucket is less or equal to 0 or if extraBuckets is less than 0, the method needs to return -1 to indicate an invalid value.
public class Challange5PaintJob {

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }
        double areaReqPaint = width * height;
        double hasPaint = areaPerBucket * (double) extraBuckets;
        double bucketsNeeded = areaReqPaint - hasPaint;
        int bucketsCount = 0;
        while (bucketsNeeded > 0) {
            bucketsNeeded -= areaPerBucket;
            bucketsCount++;
        }
        return bucketsCount;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        double areaReqPaint = width * height;
        int bucketsCount = 0;
        while (areaReqPaint > 0) {
            areaReqPaint -= areaPerBucket;;
            bucketsCount++;
        }
        return bucketsCount;
    }

    public static int getBucketCount(double area,double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        int bucketsCount = 0;
        while (area > 0) {
            area -= areaPerBucket;
            bucketsCount++;
        }
        return bucketsCount;
    }

    public static void main(String[] args) {

        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));

    }
}
