package com.firmtech.cellc.rima;

/**
 * Created by Emmanuel Adigun on 2016/09/14.
 */

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class RiMAFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = "RiMAFirebaseInstanceIdService";

    @Override
    public void onTokenRefresh() {
        //Get hold of the registration token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        //Log the token
        Log.d(TAG, "Refreshed token: " + refreshedToken);
    }
    private void sendRegistrationToServer(String token) {
        //Implement this method if you want to store the token on your server
    }
}
