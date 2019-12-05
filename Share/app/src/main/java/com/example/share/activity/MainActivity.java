package com.example.share.activity;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.share.R;
import com.example.share.fragment.HomeFragment;
import com.example.share.fragment.SetFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends BaseActivity {

    private Fragment homeFragment;
    private Fragment setFragment;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        homeFragment = new HomeFragment();
        setFragment = new SetFragment();

        RadioGroup rgMain = findViewById(R.id.rgMain);
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbHome: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMain, homeFragment).commit();
                        break;
                    }
                    case R.id.rbSet: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.flMain, setFragment).commit();
                        break;
                    }
                }
            }
        });
        rgMain.check(R.id.rbHome);


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String channelId = "app1";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "app1", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        String nowStr = simpleDateFormat.format(new Date());
        Set<String> remainSet = getSharedPreferences().getStringSet("remainSet", new HashSet<String>());
        int i = 0;
        for (String remain : remainSet) {
            try {
                i++;
                String[] remains = remain.split("&&");
                String dateStr = remains[0];
                String course = remains[1];

                if (nowStr.equals(dateStr)) {
                    Notification notification = new NotificationCompat.Builder(MainActivity.this, channelId)
                            .setContentTitle("Course remain")
                            .setContentText(course + "  " + dateStr)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                            .build();
                    manager.notify(i, notification);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        isGrantExternalRW(this, 1);
    }

    private static String[] PERMISSIONS_CAMERA_AND_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    public static boolean isGrantExternalRW(Activity activity, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int storagePermission = activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int cameraPermission = activity.checkSelfPermission(Manifest.permission.CAMERA);
            //检测是否有权限，如果没有权限，就需要申请
            if (storagePermission != PackageManager.PERMISSION_GRANTED ||
                    cameraPermission != PackageManager.PERMISSION_GRANTED) {
                //申请权限
                activity.requestPermissions(PERMISSIONS_CAMERA_AND_STORAGE, requestCode);
                //返回false。说明没有授权
                return false;
            }
        }
        //说明已经授权
        return true;
    }
}
