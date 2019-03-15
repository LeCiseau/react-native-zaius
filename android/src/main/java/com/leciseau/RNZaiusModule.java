package com.leciseau;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.WritableMap;

import com.zaius.Zaius;
import com.zaius.ZaiusEvent;

public class RNZaiusModule extends ReactContextBaseJavaModule implements ActivityEventListener {

  private final ReactApplicationContext reactContext;

  public RNZaiusModule(ReactApplicationContext reactContext) {
    super(reactContext);
    reactContext.addActivityEventListener(this);
    this.reactContext = reactContext;

    jsEvent = new RNZaiusJsEvent(reactContext);
    registerNotificationsRegistration();
  }

  @Override
  public String getName() {
    return "RNZaius";
  }

  private void registerNotificationsRegistration() {
      IntentFilter intentFilter = new IntentFilter(getReactApplicationContext().getPackageName() + ".RNZaiusTokenRegistered");

      getReactApplicationContext().registerReceiver(new BroadcastReceiver() {
          @Override
          public void onReceive(Context context, Intent intent) {
              String token = intent.getStringExtra("token");
              WritableMap params = Arguments.createMap();
              params.putString("token", token);
              jsEvent.sendEvent("notificationsRegistered", params);
          }
      }, intentFilter);
  }

  @ReactMethod
  public void identify(String customerId) {
      Zaius.setCustomerId(customerId);
  }

  @ReactMethod
  public void anonymize() {
      Zaius.anonymize();
  }

  @ReactMethod
  public void event(String eventType, ReadableMap fields) {
    ZaiusEvent newEvent = new ZaiusEvent(eventType)
      .action(fields.getString("action"));
    ReadableMapKeySetIterator iterator = fields.keySetIterator();
    while (iterator.hasNextKey()) {
        String key = iterator.nextKey();
        if (key != "action" && key != null) {
            newEvent.addField(key, key.getString());
        }
    }
    Zaius.sendEvent(newEvent);
  }

  @ReactMethod
  public void pageView(String page) {
      Zaius.sendEvent(new ZaiusPageView().page(page));
  }
}
