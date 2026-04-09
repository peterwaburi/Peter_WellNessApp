package com.example.peter_wellnessapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {

    private var myInterstitialAd : InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // code comes here

        // initialize mobile ads
        MobileAds.initialize(this)

        // Load Interstitial Ad
        loadInterstitialAd()

        //variable for ui to store the ads
        val adView : AdView=findViewById(R.id.adview)
        //variable to store ad from admob
        val adRequest= AdRequest.Builder().build()
        //show the ad in our view from adMob
        adView.loadAd(adRequest)

        val healthy_recipe_btn : Button = findViewById(R.id.healthy_recipes)
        // Create a click listener
        healthy_recipe_btn.setOnClickListener {
            val intent = Intent(applicationContext, HealthyRecipesActivity::class.java)
            startActivity(intent)

            //show interstitital ad before moviong
            showInterstitialAd()

        }

        //end of healthy recipes btn

        val nutrition_advice_btn : Button =findViewById(R.id.nutrition_advice)
        nutrition_advice_btn.setOnClickListener {
            val intent = Intent(applicationContext, NutritionAdviceActivity::class.java)
            startActivity(intent)

            showInterstitialAd()
        }

        val contact_us_btn : Button = findViewById(R.id.contact_us)
        contact_us_btn.setOnClickListener {
            val intent = Intent(applicationContext, ContactUsActivity::class.java)
            startActivity(intent)
        }

        val meditationBtn :Button=findViewById(R.id.meditation)
        meditationBtn.setOnClickListener {
            val intent= Intent(applicationContext, MeditationActivity::class.java)
            startActivity(intent)
        }

        val hydrationBtn : Button=findViewById(R.id.hydration_alert)
        hydrationBtn.setOnClickListener {
            val intent = Intent(applicationContext, HydrationAlertActivity::class.java)
            startActivity(intent)
        }
        val dailymotivationBtn :Button=findViewById(R.id.daily_motivation)
        dailymotivationBtn.setOnClickListener {
            val intent= Intent(applicationContext, DailyMotivationActivity::class.java)
            startActivity(intent)
        }
        val startexerciseBtn :Button =findViewById(R.id.start_exercise)
        startexerciseBtn.setOnClickListener {
            val intent= Intent(applicationContext, StartExerciseActivity::class.java)
            startActivity(intent)
        }
        val weeklygoalsBtn :Button=findViewById(R.id.weekly_goals)
        weeklygoalsBtn.setOnClickListener {
            val intent= Intent(applicationContext, WeeklyGoalsActivity::class.java)
            startActivity(intent)
        }
        val checkprogressBtn :Button=findViewById(R.id.check_progress)
        checkprogressBtn.setOnClickListener {
            val intent= Intent(applicationContext, CheckProgressActivity::class.java)
            startActivity(intent)
        }
        val aboutusBtn :Button=findViewById(R.id.about_us)
        aboutusBtn.setOnClickListener {
            val intent=Intent(applicationContext, AboutUsActivity::class.java)
            startActivity(intent)
        }
        val ourserviecesBtn :Button=findViewById(R.id.our_services)
        ourserviecesBtn.setOnClickListener {
            val intent= Intent(applicationContext, OurServiecesActivity::class.java)
            startActivity(intent)
        }
        val signinBtn :Button=findViewById(R.id.sign_in)
        signinBtn.setOnClickListener {
            val intent= Intent(applicationContext, SignInActivity::class.java)
            startActivity(intent)
        }
        val signupBtn :Button=findViewById(R.id.sign_up)
        signupBtn.setOnClickListener {
            val intent= Intent(applicationContext, SignUpActivity::class.java)
            startActivity(intent)
        }


    }

    // Function to load interstitial Ad
    fun loadInterstitialAd(){
        //Request from admob
        val adRequest = AdRequest.Builder().build()
        //Function to load the add
        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback(){
                override fun onAdLoaded(ad: InterstitialAd) {
                    myInterstitialAd=ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    myInterstitialAd=null

                }
            }
        )
    }

    // function to show interstitial ad
    fun showInterstitialAd() {
        if (myInterstitialAd !=null){
            myInterstitialAd?.show(this)
        }else{
            Toast.makeText(this,"Interstitial Ad failed to load", Toast.LENGTH_SHORT).show()
        }
    }
}