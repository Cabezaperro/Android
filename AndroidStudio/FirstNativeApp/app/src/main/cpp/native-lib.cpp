#include <jni.h>
#include <string>
#include <vector>
#include <thread>
#include <sstream>
#include <mutex>
#include <atomic>

using namespace std;

// int h = 0;
// atomic<int> h;
int * h;
mutex m;

void computa(int thid, int nth, int size)
{
    int hh = 0;

    // m.lock();

    for (int i = thid * size / nth; i < (thid + 1) * size / nth; i++)
        hh++;

    // m.unlock();

    h[thid] = hh;
}

extern "C" JNIEXPORT jstring

JNICALL
Java_com_cabezaperro_pjgamboa_firstnativeapp_MainActivity_stringFromJNI(JNIEnv *env, jobject /* this */)
{
    int size = 1000000;
    int nth = 10;
    string hello = "Valor de h: ";
    stringstream ss;
    // thread t1(computa, size);
    vector<thread> t;

    h = new int[nth];

    // computa(size)

    for (int i = 0; i < nth; i++)
        t.push_back(thread(computa, i, nth, size));

    for (auto &th: t)
        th.join();

    for (int i = 1; i < nth; i++)
        h[0] += h[i];

    // t1.join();

    ss << hello << h[0];
    hello = ss.str();

    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_cabezaperro_pjgamboa_firstnativeapp_MainActivity_sumaCPP(JNIEnv *env, jobject instance, jint a)
{
    return a * a;
}