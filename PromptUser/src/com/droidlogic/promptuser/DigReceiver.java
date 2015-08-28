/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * frank.chen@amlogic.com
 */

package com.droidlogic.promptuser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.File;
import java.io.FileReader;


public class DigReceiver extends BroadcastReceiver {
    private static final String TAG = "DigReceiver";

    @Override
    public void onReceive (Context context, Intent intent) {
        Log.d (TAG, "onReceive: " + intent.getAction() );

        if ("com.droidlogic.dig.DATA_CRASH".equals (intent.getAction())) {
            Intent i = new Intent(context, WipeConfirmActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } else if ("com.droidlogic.dig.DATA_READ_ONLY".equals (intent.getAction())) {
            Intent i = new Intent(context, RebootActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } else if ("com.droidlogic.dig.SYSTEM_CHANGED".equals (intent.getAction())) {
            String path = intent.getExtras().getString("error_file_path");
            Intent i = new Intent(context, RestoreSystemActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("error_file_path", path);
            context.startActivity(i);
        }
    }

}
