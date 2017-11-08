package com.github.clans.fab;

import android.content.Context;
import android.support.annotation.AnimRes;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


class AnimationCompat {

    private AnimationCompat() {
    }

    static Animation loadAnimation(Context context, @AnimRes int resId) {
        Animation anim = AnimationUtils.loadAnimation(context, resId);
        anim.setDuration(Util.getAnimationDuration(context, anim.getDuration()));
        return anim;
    }

}
