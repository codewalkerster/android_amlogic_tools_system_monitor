package com.amlogic.promptuser;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.os.SystemProperties;
import android.util.Log;
import android.content.Intent;
import android.os.SystemProperties;

public class BootActivity extends Activity {
    final static String TAG = "BootActivity";

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

	Log.i( TAG, "onCreate" );
	
	if ( SystemProperties.getBoolean("ro.init.mountdatafail", false) ) {
		startActivity(new Intent(this , WipeConfirmActivity.class));
	}
    }
}

