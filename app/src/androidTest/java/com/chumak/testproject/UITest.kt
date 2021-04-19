package com.chumak.testproject

import android.os.Process
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
// @RunWith(ProcessLogRunner::class)
@RunWith(AndroidJUnit4::class)
class UITest {

    @Rule
    @JvmField
    val activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun checkButtonClick() {
        // println("InstrumentationRegistry.getArguments().keySet() = ${InstrumentationRegistry.getArguments().keySet()}")
        // Thread.sleep(10000)
        println("instrumentationProcess = ${Process.myPid()}")
        throw RuntimeException("Test failure")
        onView(withId(R.id.resultText))
            .check(matches(withText("Started")))
        onView(withId(R.id.button))
            .check(matches(withText("Start New Activity")))
        onView(withId(R.id.button))
            .perform(click())
        // Thread.sleep(10000)
        intended(toPackage("com.chumak.testproject"))
        intended(hasExtra("URL", "https://www.google.com/"))
        onView(withId(R.id.second_activity_text))
            .check(matches(withText("Activity Second")))

        // // Context of the app under test.
        // println("appProcess = ${Process.myPid()}")
        // val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        // assertEquals("com.chumak.testproject", appContext.packageName)
    }
}