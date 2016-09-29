package program6;

public class Wait {

    public static void oneSec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public static void manySec(long s) {
        try {
            Thread.sleep(s * 1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public static void tenthOfSec(long s) {
        try {
            Thread.sleep(s * 100);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public static void milliSecs(long s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}