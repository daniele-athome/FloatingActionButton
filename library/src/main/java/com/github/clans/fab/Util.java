package com.github.clans.fab;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

final class Util {
    private final static int DEFAULT_ANIMATOR_SETTING = 1;

    private Util() {
    }

    static int dpToPx(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * scale);
    }

    static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    @SuppressWarnings("deprecation")
    static long getAnimationDuration(Context context, long duration) {
        final float animatorSpeed;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            animatorSpeed = Settings.Global.getFloat(
                context.getContentResolver(),
                Settings.Global.ANIMATOR_DURATION_SCALE,
                DEFAULT_ANIMATOR_SETTING);
        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            animatorSpeed = Settings.System.getFloat(
                context.getContentResolver(),
                Settings.System.ANIMATOR_DURATION_SCALE,
                DEFAULT_ANIMATOR_SETTING);
        }
        else {
            animatorSpeed = Settings.System.getFloat(
                context.getContentResolver(),
                Settings.System.WINDOW_ANIMATION_SCALE,
                DEFAULT_ANIMATOR_SETTING);
        }

        return (long) Math.floor(duration * animatorSpeed);
    }
}
