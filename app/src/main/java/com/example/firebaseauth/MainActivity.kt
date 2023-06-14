package com.example.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var Txt_gotoregister:TextView
    lateinit var Edtloginemail: EditText
    lateinit var Edtloginpassword: EditText
    lateinit var Btn_Login:Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Txt_gotoregister=findViewById(R.id.Tvloginnextpage)
        Edtloginemail=findViewById(R.id.EdtloginEmail)
        Edtloginpassword =findViewById(R.id.EdtloginPassword)
        Btn_Login=findViewById(R.id.BtnLogin)

        Txt_gotoregister.setOnClickListener{
            val intent= Intent(this,RegistationActivity::class.java)
            startActivity(intent)
        }

    }
    private fun Loginpage(){

    }
}







































