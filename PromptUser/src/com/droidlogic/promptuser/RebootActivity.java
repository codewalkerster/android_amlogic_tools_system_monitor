package com.droidlogic.promptuser;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.os.SystemProperties;
import android.util.Log;
import android.content.Intent;
import android.os.PowerManager;

public class RebootActivity extends Activity {
    final static String TAG = "RbootActivity";

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

	Log.i( TAG, "onCreate" );
	
	setContentView(R.layout.reboot_activity);

	findViewById(R.id.confirm_btn).setOnClickListener(new View.OnClickListener() {
         	public void onClick(View v) {
 			reboot();
         	}
     		});
    }

    private void reboot() {
	Log.i( TAG, "reboot" );
   	PowerManager pm=(PowerManager) getSystemService(POWER_SERVICE);  
	pm.reboot("");  
    }
}

