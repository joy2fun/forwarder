package com.example.forwarder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Bundle intentExtras = intent.getExtras();

        if (intentExtras != null) {
        	/* Get Messages */
            Object[] sms = (Object[]) intentExtras.get("pdus");
            
            for (int i = 0; i < sms.length; ++i) {
            	/* Parse Each Message */
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                String phone = smsMessage.getOriginatingAddress();
                String message = smsMessage.getMessageBody();
                // Toast.makeText(context, phone + ": " + message, Toast.LENGTH_SHORT).show();

                NetJob job = new NetJob();
                job.execute(phone, message, Config.getEndpointUrl(context));
            }
        }
	}
}
