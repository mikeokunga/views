package com.example.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class RegistationActivity : AppCompatActivity() {
    lateinit var Tvgotologin: TextView
    lateinit var Edtregemail: EditText
    lateinit var Edtregpassword: EditText
    lateinit var Edtregconfirmpasword: EditText
    lateinit var Btn_Register:Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registation)
        Tvgotologin=findViewById(R.id.TvSignupnextpage)
        Edtregemail=findViewById(R.id.EdtsignupEmail)
        Edtregpassword =findViewById(R.id.EdtsignupPassword)
        Edtregconfirmpasword=findViewById(R.id.EdtsignupconfirmPassword)
        Btn_Register=findViewById(R.id.BtnRegister)


        Tvgotologin.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        Btn_Register.setOnClickListener{
            signuppage()

        }
    }
    private fun signuppage() {
        val email = Edtregemail.text.toString()
        val password = Edtregpassword.text.toString()
        val confpassword = Edtregconfirmpasword.text.toString()

        if (email.isBlank() || password.isBlank() || confpassword.isBlank()) {
            Toast.makeText(this, "please password and email can't be blank", Toast.LENGTH_LONG)
                .show()
            return
        } else if (password != confpassword) {
            Toast.makeText(this, "Password do not match", Toast.LENGTH_LONG).show()
        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Signup is a success", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "Failed, Please try again", Toast.LENGTH_LONG).show()
            }
        }
    }
}
