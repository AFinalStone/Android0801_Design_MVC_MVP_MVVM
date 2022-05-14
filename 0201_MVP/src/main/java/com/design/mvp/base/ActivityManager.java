package com.design.mvp.base;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author syl
 * @time 2019/6/22 5:06 PM
 */

public class ActivityManager {

    private static ActivityManager INSTANCE = new ActivityManager();

    public static ActivityManager getInstance() {
        return INSTANCE;
    }

    private Set<Activity> allActivities;

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 退出所有的Activity
     */
    public void exitAllActivities() {
        if (allActivities != null) {
            for (Activity act : allActivities) {
                act.finish();
            }
            allActivities.clear();
        }
    }

    public boolean isEmpty() {
        if (allActivities == null || allActivities.isEmpty())
            return true;
        return false;
    }

}
