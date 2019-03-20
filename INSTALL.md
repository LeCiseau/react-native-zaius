## INSTALL

### Getting started

`$ npm install react-native-zaius --save`

#### iOS

1. Add `pod 'RNZaius', :path => '../node_modules/react-native-zaius'` in your `Podfile`
2. Run `pod install`
3. Open `AppDelegate.m`
  ```objective-c
    ...
    #import <ZaiusSDK_iOS/ZaiusSDK_iOS.h>

    ...
    - (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
    {
        [Zaius autoIntegrate:^(ZaiusBuilder *_Nonnull builder) {
          builder.trackerId = @"MY_TRACKER_ID";
          builder.appId = @"MY_APPLICATION_ID";
          builder.launchOptions = launchOptions;
          builder.collectTokenWhenAnonymous = YES;
          builder.sandbox = NO;
        }];

        ...
    }
  ```

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  ```java
  ...
  import com.leciseau.RNZaiusPackage;
  import com.zaius.androidsdk.Zaius;
  import com.zaius.androidsdk.ZaiusConfig;
  import com.zaius.androidsdk.ZaiusEnvironment;
  import com.zaius.androidsdk.ZaiusException;
  import android.util.Log;

  public class MainApplication ... {
      ...

      protected List<ReactPackage> getPackages() {
          ...
          return Arrays.<ReactPackage>asList(
              ...
              new RNZaiusPackage()
          );
      }

      @Override
      public void onCreate() {
        ...

        String trackerId = "MY_TRACKER_ID";
        String applicationId = "MY_APPLICATION_ID";
        String senderId = "123456789";
        boolean managePushTokens = true;
        boolean collectTokensWhenAnonymous = true;
        int flushIntervalSeconds = 60;
        boolean enableLogging = true;
        // set ZaiusEnvironment
        ZaiusConfig zaiusConfig = new ZaiusConfig(ZaiusEnvironment.PRODUCTION, managePushTokens, flushIntervalSeconds, collectTokensWhenAnonymous);
        try {
            Zaius.start(this.getApplicationContext(), trackerId, applicationId, senderId, zaiusConfig);
        } catch (ZaiusException e) {
            Log.e("com.leciseau.customer", "Zaius start failed", e);
        }

        ...
      }
  }

  ```
2. Append the following lines to `android/settings.gradle`:
  	```gradle
  	include ':react-native-zaius'
  	project(':react-native-zaius').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-zaius/android')
  	```
3. Add the following in `android/build.gradle`:
    ```gradle
    allprojects {
        repositories {
            ...
            maven { url "http://maven.zaius.com" }
        }
    }
  	```
4. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```gradle
    implementation project(':react-native-zaius')
    implementation 'com.zaius:androidsdk:2.1.0'
  	```
5. Add the following in `android/app/main/AndroidManifest.xml`
    ```xml
    ...
    <application
      ...
      <service android:name="com.zaius.androidsdk.ZaiusRegistrationIntentService"/>
      ...
    </application>
    ```
