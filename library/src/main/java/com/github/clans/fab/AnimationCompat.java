package com.github.clans.fab;

import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;


class AnimationCompat {

    private AnimationCompat() {
    }

    static Animation loadScaleUpAnimation(Context context, int resId) {
        Animation anim = AnimationUtils.loadAnimation(context, resId);
        anim.setInterpolator(new OvershootInterpolator());
        anim.setDuration(Util.getAnimationDuration(context, anim.getDuration()));
        return anim;
    }

    static Animation loadScaleDownAnimation(Context context, int resId) {
        Animation anim = AnimationUtils.loadAnimation(context, resId);
        anim.setInterpolator(new AccelerateInterpolator(2.5f));
        anim.setDuration(Util.getAnimationDuration(context, anim.getDuration()));
        return anim;
    }

    static Animation loadSlideInAnimation(Context context, int resId) {
        Animation anim = AnimationUtils.loadAnimation(context, resId);
        anim.setInterpolator(new OvershootInterpolator());
        anim.setDuration(Util.getAnimationDuration(context, anim.getDuration()));
        return anim;
    }

    static Animation loadSlideOutAnimation(Context context, int resId) {
        Animation anim = AnimationUtils.loadAnimation(context, resId);
        anim.setInterpolator(new AccelerateInterpolator(2.5f));
        anim.setDuration(Util.getAnimationDuration(context, anim.getDuration()));
        return anim;
    }

}
