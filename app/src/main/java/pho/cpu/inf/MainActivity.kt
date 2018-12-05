package pho.cpu.inf

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import pho.cpu.inf.adapters.PageAdapter
import pho.cpu.inf.utils.Utils

class MainActivity : AppCompatActivity() {

    private var mViewPager: ViewPager? = null
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

//        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)

        val adapter = PageAdapter(this, supportFragmentManager)
//        adapter.addFragment(HomeFragment(), "Home")
//        adapter.addFragment(AboutUsFragment(), "About Us")
//        adapter.addFragment(ContactUsFragment(), "Contact Us")

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById<ViewPager?>(R.id.view_pager)
        mViewPager!!.adapter = adapter

//		val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
//		tabLayout.setupWithViewPager(mViewPager)
        tabs!!.setupWithViewPager(mViewPager)

        Utils.wrapTabIndicatorToTitle(tabs, 40, 40)

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
