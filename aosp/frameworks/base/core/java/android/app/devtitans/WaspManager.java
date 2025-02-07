package android.app.devtitans;

import android.content.Context;
import android.os.devtitans.IWaspService;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.annotation.Nullable;
import android.annotation.NonNull;

public class WaspManager {
    private static final String TAG = "WaspManager";

    public static final String SERVICE_NAME = Context.WASP_SERVICE;

    private final Context mContext;
    private final IWaspService mService;
    
    /** @hide */
    public WaspManager(@NonNull Context context, @NonNull IWaspService service) {
        mContext = context;
        mService = service;
    }
    
    @Nullable
    public String modifyNotificationText(@NonNull String appName, @NonNull String originalText) {
        try {
            return mService.modifyNotificationText(appName, originalText);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to modify notification text", e);
            return originalText;
        }
    }
    @Nullable
    public String getModifiedText(@NonNull String appName) {
        try {
            return mService.getModifiedText(appName);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get modified text", e);
            return null;
        }
    }

    public boolean hasModifiedText(@NonNull String appName) {
        try {
            return mService.hasModifiedText(appName);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to check modified text", e);
            return false;
        }
    }
    
    public void clearModifiedTexts() {
        try {
            mService.clearModifiedTexts();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to clear modified texts", e);
        }
    }

    /** 
     * Pegando a interface WaspService do system service manager
     * @hide
    */
    public static IWaspService getService() {
        return IWaspService.Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
    }
}