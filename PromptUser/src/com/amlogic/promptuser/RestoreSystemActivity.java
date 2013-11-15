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
import android.widget.TextView;

public class RestoreSystemActivity extends Activity {
    final static String TAG = "RestoreSystemActivity";

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

	Log.i( TAG, "onCreate" );
	
	setContentView(R.layout.restore_system_activity);

	String strErrorFile = getIntent().getStringExtra("error_file_path");
	if( strErrorFile != null ) {
		((TextView)findViewById(R.id.erorr_file_tv)).setText(strErrorFile);
	}

	findViewById(R.id.confirm_btn).setOnClickListener(new View.OnClickListener() {
         	public void onClick(View v) {
 			restoreSystem();
			//finish();
         	}
     		});
    }

    private void restoreSystem() {
	Log.i( TAG, "Restore System" );
        sendBroadcast(new Intent("android.intent.action.SYSTEM_RESTORE"));
    }
}

