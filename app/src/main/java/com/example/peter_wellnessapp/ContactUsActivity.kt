package com.example.peter_wellnessapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class ContactUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_us)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // my code
        val callBtn : Button= findViewById(R.id.call_btn)
        callBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, "tel:0140078589".toUri())
            startActivity(intent)
        }


        val smsBtn :Button=findViewById(R.id.sms_btn)
        smsBtn.setOnClickListener {
            val intent=Intent(Intent.ACTION_SENDTO).apply{
                data= "smsto:0140078589".toUri()
                putExtra("sms_body","Hello, this is a test message")
            }
            startActivity(intent)

        }

        val whatsappBtn :Button = findViewById(R.id.whatsapp_btn)
        whatsappBtn.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, "https://wa.me/254140078589".toUri())
            startActivity(intent)
        }
    }
}