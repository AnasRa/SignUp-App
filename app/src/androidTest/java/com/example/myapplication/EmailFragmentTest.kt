package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class EmailFragmentTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testInputBeforeGoNext() {
        val r = Registerer("test@test.com", "test1234", "test", "Te")
        onView(withId(R.id.startButton)).perform(click())
        onView(withId(R.id.inputEmail)).perform(typeText(r.email))
        onView(withId(R.id.inputPassword)).perform(
            typeText(r.password),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.submitEmail)).perform(click())
        onView(withId(R.id.inputFirstName)).perform(typeText(r.firstName))
        onView(withId(R.id.inputLastName)).perform(
            typeText(r.lastName),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.submitName)).perform(click())
        onView(withId(R.id.confirm)).perform(click())
    }
}