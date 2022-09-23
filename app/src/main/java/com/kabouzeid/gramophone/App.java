package com.kabouzeid.gramophone;

import android.app.Application;

import com.kabouzeid.appthemehelper.ThemeStore;
import com.kabouzeid.gramophone.appshortcuts.DynamicShortcutManager;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class App extends Application {

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
        new DynamicShortcutManager(this).initDynamicShortcuts();
    }

    public static App getInstance() {
        return app;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
