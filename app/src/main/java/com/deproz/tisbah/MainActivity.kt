package com.deproz.tisbah

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.ViewSwitcher
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    val pray = arrayListOf("ASTAGFURLLAH", "ALHAMDULILAH", "LAILLA ILALAHU","LAHAOLA WALAQUWATA ILABILAH", "YADAFIU HASLAM","ROBISIDNI ILIMAN", "YA AFFIS AFFINA","YA RASSAQ RASSIQNA","YA SALAM SALIMNA")
    var currentText = 0

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var added = 0

       add.setOnClickListener {
           added++
           cot.text = added.toString()
       }
        reset.setOnClickListener {
            added=0
            cot.text = added.toString()
        }

        nex.setOnClickListener {

        }

        val inAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)
        swit.setFactory(object: ViewSwitcher.ViewFactory{
            override fun makeView(): View {
                val switcherTextView = TextView(this@MainActivity)
                switcherTextView.textSize=20f
                switcherTextView.gravity= Gravity.CENTER
                switcherTextView.setTextColor(Color.WHITE)
                return switcherTextView
            }

        })

        swit.inAnimation=inAnimation
        swit.outAnimation=outAnimation

        swit.setText(pray[currentText])
        nex.setOnClickListener {
            if (currentText !=8)
                currentText++
            else
                currentText = 0
            swit.setText(pray[currentText])
        }
        swit.setText(pray[currentText])
        prev.setOnClickListener {
            if (currentText >0)
                currentText--
            else
                currentText = 8
            swit.setText(pray[currentText])
        }

        MobileAds.initialize(this)
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val adView = AdView(this (getString(R.string.adView)))
        adView.adSize = AdSize.SMART_BANNER
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"


    }

    private operator fun invoke(string: String): Context? {
        return null

    }
}


