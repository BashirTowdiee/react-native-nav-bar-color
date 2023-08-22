package com.navigationbarcolor;

import androidx.annotation.NonNull;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import java.util.Map;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = NavigationBarColorModule.NAME)
public class NavigationBarColorModule extends ReactContextBaseJavaModule {
  public static final String NAME = "NavigationBarColor";

  public NavigationBarColorModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void setNavigationBarColor(String color) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      final int parsedColor = Color.parseColor(color);
      getCurrentActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
          Window window = getCurrentActivity().getWindow();
          window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
          window.setNavigationBarColor(parsedColor);
        }
      });
    }
  }
}
