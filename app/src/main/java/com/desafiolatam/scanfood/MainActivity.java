package com.desafiolatam.scanfood;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private static final int RC_CAMERA_PERMISSION = 343;
    private ZXingScannerView mScannerView;

    @SuppressWarnings("all")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mScannerView = new ZXingScannerView(this);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
             startScanner();
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, RC_CAMERA_PERMISSION);
        }

    }

    private void startScanner(){
        mScannerView = findViewById(R.id.scannerXz);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }



    @Override
    public void onPause() {
        super.onPause();
        if (mScannerView != null) {
            mScannerView.stopCamera();
        }
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Toast.makeText(this, rawResult.getText(), Toast.LENGTH_SHORT).show();
        Log.v("codigo", rawResult.getText());
        Log.v("formato", rawResult.getBarcodeFormat().name());

        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (RC_CAMERA_PERMISSION == requestCode && PackageManager.PERMISSION_GRANTED == grantResults[0]) {
            startScanner();
        }
    }
}
