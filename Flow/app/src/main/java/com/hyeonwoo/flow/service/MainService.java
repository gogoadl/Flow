package com.hyeonwoo.flow.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.hyeonwoo.flow.R;

public class MainService extends Service {
    private static final String CHANNEL_ID = "flo_channel";
    // 여기서 음악 재생

    private NotificationManager notificationManager;

    public MainService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Foreground Service")
                .setProgress(100, 0, false)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        startForeground(1000, notification);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
