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

public class WipeConfirmActivity extends Activity {
    final static String TAG = "WipeConfirmActivity";

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

	Log.i( TAG, "onCreate" );
	
	setContentView(R.layout.wipe_data_activity);

	findViewById(R.id.confirm_btn).setOnClickListener(new View.OnClickListener() {
         	public void onClick(View v) {
 			wipeData();
			//finish();
         	}
     		});
    }

    private void wipeData() {
	Log.i( TAG, "MASTER_CLEAR" );
        sendBroadcast(new Intent("android.intent.action.MASTER_CLEAR"));
    }
}

