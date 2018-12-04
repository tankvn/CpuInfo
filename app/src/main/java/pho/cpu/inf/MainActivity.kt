package pho.cpu.inf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // remove title
        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_main)

        initAd()
    }

    fun initAd() {
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")

        mAdView = findViewById(R.id.adView)
        //mAdView.adSize = AdSize.BANNER
        //mAdView.adSize = AdSize.SMART_BANNER
        val adRequest = AdRequest.Builder()
            //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build()
        mAdView.loadAd(adRequest)
    }
}
