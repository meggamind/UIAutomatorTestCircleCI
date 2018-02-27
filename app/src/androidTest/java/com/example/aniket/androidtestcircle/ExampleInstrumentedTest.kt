package com.example.aniket.androidtestcircle

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private var mDevice: UiDevice? = null

    @Before
    fun initITSetup() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @Test
    @Throws(Exception::class)
    fun testLoginProcess() {
        val context = InstrumentationRegistry.getContext()
        val intent = context.packageManager.getLaunchIntentForPackage(APP_NAME)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
        println("mDevice!!.currentPackageName: " + mDevice!!.currentPackageName)
        throw Exception("mDevice!!.currentPackageName: " + mDevice!!.currentPackageName)

        mDevice!!.wait(Until.hasObject(By.textContains("TESTING BUTTON")), 60000 * 1)
        if (!UiObject(UiSelector().textContains("TESTING BUTTON")).exists()) {
            println("View not Found ")
            throw Exception("View not Found")
        } else {
            println("Found View")
        }
    }

    companion object {
        const val APP_NAME = "com.example.aniket.androidtestcircle"
    }
}
