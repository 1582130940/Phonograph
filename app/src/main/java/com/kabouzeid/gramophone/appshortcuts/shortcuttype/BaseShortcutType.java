package com.kabouzeid.gramophone.appshortcuts.shortcuttype;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.os.Bundle;

import com.kabouzeid.gramophone.appshortcuts.AppShortcutLauncherActivity;

/**
 * @author Adrian Campos
 */
public abstract class BaseShortcutType {

    static final String ID_PREFIX = "com.kabouzeid.gramophone.appshortcuts.id.";

    Context context;

    public BaseShortcutType(Context context) {
        this.context = context;
    }

    static public String getId() {
        return ID_PREFIX + "invalid";
    }

    abstract ShortcutInfo getShortcutInfo();

    /**
     * Creates an Intent that will launch MainActivtiy and immediately play {@param songs} in either shuffle or normal mode
     *
     * @param shortcutType Describes the type of shortcut to create (ShuffleAll, TopTracks, custom playlist, etc.)
     */
    Intent getPlaySongsIntent(int shortcutType) {
        Intent intent = new Intent(context, AppShortcutLauncherActivity.class);
        intent.setAction(Intent.ACTION_VIEW);

        Bundle b = new Bundle();
        b.putInt(AppShortcutLauncherActivity.KEY_SHORTCUT_TYPE, shortcutType);

        intent.putExtras(b);

        return intent;
    }
}
