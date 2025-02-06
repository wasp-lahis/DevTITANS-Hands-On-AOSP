package com.android.server.notification.devtitans;

import android.os.devtitans.IWaspService;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;


public class WaspService extends IWaspService.Stub {
    private static final String TAG = "WaspService:";
    private Map<String, String> modifiedTexts;

    public WaspService() {
        modifiedTexts = new HashMap<>();
        Log.d(TAG, "WaspService iniciado");
    }

    @Override
    public String modifyNotificationText(String appName, String originalText) {
        String modifiedText = "DevTitans: " + originalText;
        modifiedTexts.put(appName, modifiedText);
        return modifiedText;
    }
    
    @Override
    public String getModifiedText(String appName) {
        return modifiedTexts.get(appName);
    }
    
    @Override
    public boolean hasModifiedText(String appName) {
        return modifiedTexts.containsKey(appName);
    }
    
    @Override
    public void clearModifiedTexts() {
        modifiedTexts.clear();
    }

}