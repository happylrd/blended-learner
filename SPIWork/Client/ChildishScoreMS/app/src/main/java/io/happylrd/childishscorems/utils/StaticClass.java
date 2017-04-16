package io.happylrd.childishscorems.utils;

public class StaticClass {

    private static final String NAIVE_SCORE_MS_IP = "10.8.173.184";
    private static final String NAIVE_SCORE_MS_PORT = "8000";
    public static final String NAIVE_SCORE_MS_BASE_URL = "http://" + NAIVE_SCORE_MS_IP + ":" + NAIVE_SCORE_MS_PORT + "/";
    public static final String ADMIN_MS_URL = NAIVE_SCORE_MS_BASE_URL + "admin/";

    public static final String SHARE_CURRENT_USER = "current_user";

    public static final int PERMISSION_TYPE_NORMAL = 0;
    public static final int PERMISSION_TYPE_ADD = 1;
    public static final int PERMISSION_TYPE_CHECK = 2;

    public static String autoFillZero(int number, int length) {
        return String.format("%0" + length + "d", number);
    }
}
