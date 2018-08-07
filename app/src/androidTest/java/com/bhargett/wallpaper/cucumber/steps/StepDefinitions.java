package com.bhargett.wallpaper.cucumber.steps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.bhargett.wallpaper.MainActivity;
import com.bhargett.wallpaper.R;
import com.bhargett.wallpaper.util.ActivityFinisher;
import com.bhargett.wallpaper.util.Helper;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;

import org.junit.Assert;
import org.junit.Rule;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class StepDefinitions {

    public static final String TAG = StepDefinitions.class.getSimpleName();
    private Context mInstrumentationContext;
    private Context mAppContext;
    private Activity mActivity;

    @Rule
    private ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class,
            false, false);

    @Before
    public void setUp() throws Exception {
        mInstrumentationContext = InstrumentationRegistry.getContext();
        mAppContext = InstrumentationRegistry.getTargetContext();
        mActivity = mActivityRule.launchActivity(new Intent()); // Start Activity before each test scenario
        assertNotNull(mActivity);
    }

    @After
    public void tearDown() throws Exception {
        ActivityFinisher.finishOpenActivities(); // Required for testing App with multiple activities
    }

    @Given("^\'([^\"]*)\' is selected$")
    public void isSelected(String current) {
        BottomNavigationItemView viewById = mActivity.findViewById(Helper.stringToId(current));
        Assert.assertEquals(current + " not selected ", true, viewById.isSelected());
    }

    @Then("^Tap Nav item \'([^\"]*)\'$")
    public void tap(String key) {
        BottomNavigationItemView viewById = mActivity.findViewById(Helper.stringToId(key));
        viewById.post(()->viewById.performClick());
    }

    @Given("^Text should equal \'([^\"]*)\'")
    public void textCheck(String text) {
        onView(withId(R.id.message)).check(ViewAssertions.matches(ViewMatchers.withText(text)));
    }
}
