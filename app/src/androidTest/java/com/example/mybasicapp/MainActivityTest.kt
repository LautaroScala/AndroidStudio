package com.example.mybasicapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testTextComparison() {
        onView(withId(R.id.editText1))
            .perform(typeText("test1"), closeSoftKeyboard())

        onView(withId(R.id.editText2))
            .perform(typeText("test2"), closeSoftKeyboard())

        onView(withId(R.id.compareButton)).perform(click())

        onView(withId(R.id.resultTextView))
            .check(matches(withText("Los textos son diferentes.")))
    }
}
