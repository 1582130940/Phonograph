package com.kabouzeid.gramophone;

import android.app.Application;
import android.os.Build;

import com.kabouzeid.appthemehelper.ThemeStore;
import com.kabouzeid.gramophone.appshortcuts.DynamicShortcutManager;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class App extends Application {

    public static final String GOOGLE_PLAY_LICENSE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjMeADN5Ffnt/ml5SYxNPCn8kGcOYGpHEfNSCts99vVxqmCn6C01E94c17j7rUK2aeHur5uxphZylzopPlQ8P8l1fqty0GPUNRSo18FCJzfGH8HZAwZYOcnRFPaXdaq3InyFJhBiODh2oeAcVK/idH6QraQ4r9HIlzigAg6lgwzxl2wJKDh7X/GMdDntCyzDh8xDQ0wIawFgvgojHwqh2Ci8Gnq6EYRwPA9yHiIIksT8Q30QyM5ewl5QcnWepsls7enNqeHarhpmSibRUDgCsxHoOpny7SyuvZvUI3wuLckDR0ds9hrt614scHHqDOBp/qWCZiAgOPVAEQcURbV09qQIDAQAB";
    public static final String PRO_VERSION_PRODUCT_ID = "pro_version";

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        // default theme
        if (!ThemeStore.isConfigured(this, 1)) {
            ThemeStore.editTheme(this)
                    .primaryColorRes(R.color.md_indigo_500)
                    .accentColorRes(R.color.md_pink_A400)
                    .commit();
        }

        // Set up dynamic shortcuts
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            new DynamicShortcutManager(this).initDynamicShortcuts();
        }
    }

    public static boolean isProVersion() {
        return BuildConfig.DEBUG || app.billingProcessor.isPurchased(PRO_VERSION_PRODUCT_ID);
    }

    private static OnProVersionChangedListener onProVersionChangedListener;

    public static void setOnProVersionChangedListener(OnProVersionChangedListener listener) {
        onProVersionChangedListener = listener;
    }

    public static void notifyProVersionChanged() {
        if (onProVersionChangedListener != null) {
            onProVersionChangedListener.onProVersionChanged();
        }
    }

    public interface OnProVersionChangedListener {
        void onProVersionChanged();
    }

    public static App getInstance() {
        return app;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
