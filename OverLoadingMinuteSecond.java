public class OverLoadingMinuteSecond {

   public static  String  getDurationString(long minutes,long seconds)
    {
        if(minutes < 0 || seconds < 0|| seconds > 59)
        {
            return "Invalid Value";
        }
        long hours=minutes/60;
        long remainingMinute=minutes % 60;

     return hours+"h"+remainingMinute+"m"+seconds+"s";
    }

    private static String getDurationString(long seconds) {
        if(seconds < 0) {
            return "Invalid value";
        }

        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }
    public static void main(String[] args) {
        System.out.println(OverLoadingMinuteSecond.getDurationString(65,60));
        System.out.println(OverLoadingMinuteSecond.getDurationString(3945));
    }
}
