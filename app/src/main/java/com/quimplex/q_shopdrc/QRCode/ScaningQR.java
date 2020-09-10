package com.quimplex.q_shopdrc.QRCode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.zxing.Result;
import com.quimplex.q_shopdrc.Fragments.Menu2Fragment;
import com.quimplex.q_shopdrc.Fragments.Menu3Fragment;


import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScaningQR extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zXingScannerView=new ZXingScannerView(this);
        setContentView(zXingScannerView);

    }

    @Override
    public void handleResult(Result result) {
        Menu2Fragment.res.setText(result.getText());
        onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }
}
