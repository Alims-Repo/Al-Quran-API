package com.nelu.quran_api.utils

import android.content.Context
import java.io.InputStream

object NativeUtils {
    init {
        System.loadLibrary("native-lib")
    }

    external fun readStringListFromRawResource(inputStream: InputStream): Array<String>?
}

// Usage
fun Context.readBinaryDataFromResource(resourceId: Int): Array<String>? {
    val inputStream = resources.openRawResource(resourceId)
    return NativeUtils.readStringListFromRawResource(inputStream)
}