#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_blue_helloso_MainActivity_stringFromJNI( JNIEnv* env, jobject instance/* this */, jstring jstr) {
    jclass String_clazz = env->FindClass("java/lang/String");
    jmethodID concat_methodID = env->GetMethodID(String_clazz, "concat", "(Ljava/lang/String;)Ljava/lang/String;");
    jstring str = env->NewStringUTF("   from so ---[AIHackerTeam 孤狼]");
    jobject str1 = env->CallObjectMethod(jstr, concat_methodID, str);
    const char* chars = env->GetStringUTFChars((jstring)str1, 0);
    return env->NewStringUTF(chars);
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_blue_helloso_ndktest_NdkTest_stringFromJNI( JNIEnv* env, jclass jclass1, jstring jstr) {
    jclass String_clazz = env->FindClass("java/lang/String");
    jmethodID concat_methodID = env->GetMethodID(String_clazz, "concat", "(Ljava/lang/String;)Ljava/lang/String;");
    jstring str = env->NewStringUTF("   from so ---[AIHackerTeam 孤狼]");
    jobject str1 = env->CallObjectMethod(jstr, concat_methodID, str);
    const char* chars = env->GetStringUTFChars((jstring)str1, 0);
    return env->NewStringUTF(chars);
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
}