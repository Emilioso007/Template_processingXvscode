package Utils;

public class KH {

    private static int[] keys = new int[1023];
    
    private KH() {
    }

    public static void setKey(int keyID, int state) {
        keys[keyID] = state;
    }

    public static boolean keyDown(int keyID) {
        return keys[keyID] == 1;
    }

    public static boolean keyUp(int keyID) {
        return keys[keyID] == 0;
    }

    public static boolean keyReleased(int keyID) {
        return keys[keyID] == 2;
    }

    public static boolean keyPressed(int keyID) {
        return keys[keyID] == 3;
    }

    public static void initialize() {
        for (int i = 0; i < keys.length; i++) {
            keys[i] = 0;
        }
    }

    public static void update() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == 2) {
                keys[i] = 0;
            } else if (keys[i] == 3) {
                keys[i] = 1;
            }
        }
    }

}