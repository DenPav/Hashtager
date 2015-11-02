package com.example.denis.tweettestlist;

import android.app.Application;
import android.os.Environment;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by pr_denis on 29.10.15.
 */
public class App extends Application {

    /** Checks if external storage is available for read and write */
    public static boolean isExternalStorageWritable() {
        final String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /** Checks if external storage is available to at least read */
    public static boolean isExternalStorageReadable() {
        final String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        TwitterAuthConfig authConfig =  new TwitterAuthConfig("hRUrzQoQF3kEjtexGICy1hkQV", "8Z2jhuEE4hTYkg30J3t77efG6eTlEyBiSzVWeE3L5AS2EuUakE");
        Fabric.with(this, new Twitter(authConfig));
    }

}
