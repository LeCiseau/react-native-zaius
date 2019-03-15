package com.leciseau;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;

public class RNZaiusJsEvent {
    private final ReactApplicationContext reactContext;

    public RNZaiusJsEvent(ReactApplicationContext reactContext) {
      super(reactContext);
      this.reactContext = reactContext;
    }

    public void sendEvent(String eventName, @Nullable WritableMap params) {
        if (mReactContext.hasActiveCatalystInstance()) {
            mReactContext
                    .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit(eventName, params);
        }
    }
}
