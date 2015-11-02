package com.example.denis.tweettestlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

/**
 * Created by pr_denis on 29.10.15.
 */
public class TwitterSessionStore {

    private static final String TOKEN = "token";
    private static final String TOKEN_SECRET = "tokenSecret";
    private static final String USER_ID = "iserID";
    private static final String USER_NAME = "userName";
    private static final String KEY = "twitter-session";

    /***
     * Save the Token and Token Secret
     *
     * @param session
     *            Twitter object with the token and token secret
     * @param context
     *            The context of the application
     * @return
     */
    public static boolean save (TwitterSession session, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(TOKEN, session.getAuthToken().token);
        editor.putLong(USER_ID, session.getUserId());
        editor.putString(USER_NAME, session.getUserName());

        return editor.commit();
    }

    /***
     * Restore and get TwitterSession back from Shared Preferences
     *
     * @param context
     *            The context of the application
     * @return true if the token and token secret are defined
     */
    @Nullable
    public static TwitterSession getSession(Context context) throws IllegalArgumentException{
        SharedPreferences editor = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        TwitterAuthToken token = new TwitterAuthToken(editor.getString(TOKEN, null), editor.getString(TOKEN_SECRET, null));
        String name = editor.getString(USER_NAME, null);
        Long id = editor.getLong(USER_ID, 524971209851543553L);

        TwitterSession session = new TwitterSession(token, id, name);
        return session;
    }

    /***
     * Clear the token and token secret
     *
     * @param context
     *            The context of the application
     */
//    public static void clear(TwitterSession session, Context context) {
//        session.setToken(null);
//        session.setTokenSecret(null);
//
//        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
//                .edit();
//        editor.clear();
//        editor.commit();
//    }
}
