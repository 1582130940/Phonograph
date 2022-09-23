package com.kabouzeid.gramophone.appshortcuts;

import android.content.Context;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.util.TypedValue;

import androidx.core.graphics.drawable.IconCompat;

import com.kabouzeid.appthemehelper.ThemeStore;
import com.kabouzeid.gramophone.R;
import com.kabouzeid.gramophone.util.ImageUtil;
import com.kabouzeid.gramophone.util.PreferenceUtil;

/**
 * @author Adrian Campos
 */
public final class AppShortcutIconGenerator {

    public static Icon generateThemedIcon(Context context, int iconId) {
        if (PreferenceUtil.getInstance(context).coloredAppShortcuts()) {
            return generateUserThemedIcon(context, iconId).toIcon();
        } else {
            return generateDefaultThemedIcon(context, iconId).toIcon();
        }
    }

    private static IconCompat generateDefaultThemedIcon(Context context, int iconId) {
        // Return an Icon of iconId with default colors
        return generateThemedIcon(context, iconId,
                context.getColor(R.color.app_shortcut_default_foreground),
                context.getColor(R.color.app_shortcut_default_background)
        );
    }

    private static IconCompat generateUserThemedIcon(Context context, int iconId) {
        // Get background color from context's theme
        final TypedValue typedColorBackground = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedColorBackground, true);

        // Return an Icon of iconId with those colors
        return generateThemedIcon(context, iconId,
                ThemeStore.primaryColor(context),
                typedColorBackground.data
        );
    }

    private static IconCompat generateThemedIcon(Context context, int iconId, int foregroundColor, int backgroundColor) {
        // Get and tint foreground and background drawables
        Drawable vectorDrawable = ImageUtil.getTintedVectorDrawable(context, iconId, foregroundColor);
        Drawable backgroundDrawable = ImageUtil.getTintedVectorDrawable(context, R.drawable.ic_app_shortcut_background, backgroundColor);

        AdaptiveIconDrawable adaptiveIconDrawable = new AdaptiveIconDrawable(backgroundDrawable, vectorDrawable);
        return IconCompat.createWithAdaptiveBitmap(ImageUtil.createBitmap(adaptiveIconDrawable));
    }

}
