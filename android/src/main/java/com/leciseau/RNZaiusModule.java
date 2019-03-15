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
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMapKeySetIterator;

import com.zaius.androidsdk.Zaius;
import com.zaius.androidsdk.ZaiusEvent;
import com.zaius.androidsdk.ZaiusPageView;
import com.zaius.androidsdk.ZaiusException;

import android.util.Log;

public class RNZaiusModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private final RNZaiusJsEvent jsEvent;

  public RNZaiusModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;

    RNZaiusJsEvent jsEvent = new RNZaiusJsEvent(reactContext);
    this.jsEvent = jsEvent;
    registerNotificationsRegistration();
  }

  @Override
  public String getName() {
    return "RNZaius";
  }

  private void registerNotificationsRegistration() {
      IntentFilter intentFilter = new IntentFilter(getReactApplicationContext().getPackageName() + ".RNZaiusTokenRegistered");
      final RNZaiusJsEvent jsEvent = this.jsEvent;
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
      try {
          Zaius.setCustomerId(customerId);
      } catch (ZaiusException e) {
          Log.e("com.leciseau.RNZaiusModule", "Zaius identity failed", e);
      }
  }

  @ReactMethod
  public void anonymize() {
      try {
          Zaius.anonymize();
      } catch (ZaiusException e) {
          Log.e("com.leciseau.RNZaiusModule", "Zaius anonymize failed", e);
      }
  }

  @ReactMethod
  public void event(String eventType, ReadableMap fields) {
    ZaiusEvent newEvent = new ZaiusEvent(eventType)
      .action(fields.getString("action"));
    ReadableMapKeySetIterator iterator = fields.keySetIterator();
    while (iterator.hasNextKey()) {
        String key = iterator.nextKey();
        if (key != "action" && key != null) {
            newEvent.addField(key, fields.getString(key));
        }
    }
    try {
        Zaius.sendEvent(newEvent);
    } catch (ZaiusException e) {
        Log.e("com.leciseau.RNZaiusModule", "Zaius event failed", e);
    }
  }

  @ReactMethod
  public void pageView(String page) {
    try {
        Zaius.sendEvent(new ZaiusPageView().page(page));
    } catch (ZaiusException e) {
        Log.e("com.leciseau.RNZaiusModule", "Zaius pageView failed", e);
    }
  }
}
