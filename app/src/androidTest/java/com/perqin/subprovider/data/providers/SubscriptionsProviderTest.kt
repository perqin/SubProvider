package com.perqin.subprovider.data.providers

import android.net.Uri
import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SubscriptionsProviderTest {
    @Test
    fun testOpenFile() {
        // Test Context should also work
        val context = InstrumentationRegistry.getInstrumentation().context
        val text = context.contentResolver.openInputStream(Uri.parse("content://com.perqin.subprovider.provider.sub/1"))!!.use {
            it.readBytes().toString(Charsets.UTF_8)
        }
        Log.v("androidTest", text)
    }
}