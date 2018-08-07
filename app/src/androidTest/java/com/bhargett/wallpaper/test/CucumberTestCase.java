package com.bhargett.wallpaper.test;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "features", glue = {"com.bhargett.wallpaper.cucumber.steps"})
class CucumberTestCase {
}
