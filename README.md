# Running Mobile App using Appium


## Prerequisites
To run the mobile app using Appium, we need the following:

1. Appium installed 
2. Android and iOS SDKs installed 
3. Mobile device or emulator connected 
4. Mobile app file (APK or IPA) to be tested
5. Testing framework (TestNG)

## Running the tests locally
1. Open Appium and start the Appium server.
2. Make sure the emulator is up and running
3. In order to run the test

```
mvn clean test -Dplatform="local"
```

## Running the tests through Saucelabs
For running Android app,

```
mvn clean test -Dplatform="android"
```

For running the iOS app,

```
mvn clean test -Dplatform="iOS"
```
