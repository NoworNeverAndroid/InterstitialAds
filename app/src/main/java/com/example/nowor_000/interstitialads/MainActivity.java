package com.example.nowor_000.interstitialads;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {



    private InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * 1-SE MUESTRA CUANDO PULSAMOS EL BOTON
                 */
                MostrarInterstitial();
            }
        });





        mInterstitialAd = new InterstitialAd(this);
        //AÑADIMOS EL IDENTIFICADOR
        mInterstitialAd.setAdUnitId(getString(R.string.ad_unit_id));




        PrepararInterstitial();



    }


    @Override
    protected void onRestart() {
        super.onRestart();
        /**
         * 2-SE MUESTRA CUANDO SE RESTAURA LA ACTIVITY
         */
        MostrarInterstitial();
    }

    @Override
    protected void onDestroy() {
        /**
         * 2-SE MUESTRA CUANDO SE RESTAURA LA ACTIVITY
         */
        super.onDestroy();
    }




    private void MostrarInterstitial() {

        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            PrepararInterstitial();
        }
    }

    private void PrepararInterstitial() {
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);
        }



    }




}
