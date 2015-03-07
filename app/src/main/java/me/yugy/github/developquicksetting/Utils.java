package me.yugy.github.developquicksetting;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.StringRes;
import android.util.Log;
import android.widget.Toast;

public class Utils {

    public static void toast(Context context, @StringRes int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static String getApkInstallPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isAppInstallInData(Context context) {
        return getApkInstallPath(context).startsWith("/data/");
    }

    public static void log(String log) {
        if (Conf.LOG_DEBUG_INFO_ENABLED) {
            Log.d(Conf.DEBUG_INFO_TAG, log);
        }
    }
}
