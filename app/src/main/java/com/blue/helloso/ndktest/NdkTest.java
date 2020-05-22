package com.blue.helloso.ndktest;

public class NdkTest {
    public static native String stringFromJNI(String string);

    static {
        System.loadLibrary("native-lib");
    }
}
