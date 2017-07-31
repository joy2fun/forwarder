package com.example.forwarder;

import android.content.Context;

import java.util.Date;

public class CallReceiver extends PhonecallReceiver {

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
        NetJob job = new NetJob();
        job.execute(number, "Incoming call.",  Config.getEndpointUrl(ctx));
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {

    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
        NetJob job = new NetJob();
        job.execute(number, "Missing call.",  Config.getEndpointUrl(ctx));
    }

}