package com.leciseau;

import com.zaius.androidsdk.ZaiusReceiver;

import android.content.Intent;
import android.content.Context;

public class RNZaiusReceiver extends ZaiusReceiver {
  @Override
  public void onTokenRegistration(Context context, String token) {
    Intent intent = new Intent(this.getPackageName() + ".RNZaiusTokenRegistered");
    intent.putExtra("token", token);
    context.sendBroadcast(intent);
  }
}
