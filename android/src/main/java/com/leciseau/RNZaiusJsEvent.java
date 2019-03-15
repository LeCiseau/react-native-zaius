package com.leciseau;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class RNZaiusJsEvent {
    private final ReactApplicationContext reactContext;

    public RNZaiusJsEvent(ReactApplicationContext reactContext) {
      this.reactContext = reactContext;
    }

    public void sendEvent(String eventName, WritableMap params) {
        if (this.reactContext.hasActiveCatalystInstance()) {
            this.reactContext
                    .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit(eventName, params);
        }
    }
}
