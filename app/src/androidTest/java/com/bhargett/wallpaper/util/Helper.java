package com.bhargett.wallpaper.util;

import android.app.Instrumentation;
import android.os.Build;
import android.view.View;

import com.bhargett.wallpaper.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.matcher.BoundedMatcher;

public class Helper {

    public static int stringToId(String key) {
        switch (key) {
            case "Home":
                return R.id.navigation_home;
            case "Dashboard":
                return R.id.navigation_dashboard;
            case "Notifications":
                return R.id.navigation_notifications;
        }
        throw new UnsupportedOperationException();
    }

    private static void grantWritePermissions() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            try {
                Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
                String appPackage = instrumentation.getTargetContext().getPackageName();
                instrumentation.getUiAutomation().executeShellCommand("pm grant " + appPackage
                        + " android.permission.READ_EXTERNAL_STORAGE");
                instrumentation.getUiAutomation().executeShellCommand("pm grant " + appPackage
                        + " android.permission.WRITE_EXTERNAL_STORAGE");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }}
