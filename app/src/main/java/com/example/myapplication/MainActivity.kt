package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirmpassword: EditText
    lateinit var phone: EditText
    lateinit var register: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name=findViewById(R.id.etname)
        email=findViewById(R.id.etemail)
        password=findViewById(R.id.etpassword)
        confirmpassword=findViewById(R.id.etconfirmpassword)
        phone=findViewById(R.id.etphonenumber)
        register=findViewById(R.id.btnregister)
        password.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0) <6){
                password.error = ("Passowrd must be more than  6 digits")
            }else{
                password.error = null
            }
        }
        register .setOnClickListener {
        var name=name.text.toString()
            var email=email.text.toString()
            var password=password.text.toString()
            var confirmpassword=confirmpassword.text.toString()
            var phone=phone.text.toString()
            if (TextUtils.isEmpty(name)){
                this.name.requestFocus()
                Toast.makeText(this, "plz enter your name",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(email) || !email.contains("@")){
                Toast.makeText(this, "Either the password is empty or it is less than 6 digits",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (TextUtils.isEmpty(password) || password.length<6){
                Toast.makeText(this, "Either the password is empty or it is less than 6 digits",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (TextUtils .isEmpty(confirmpassword) || !password.equals(confirmpassword)){
                Toast.makeText(this, "plz enter password correctly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (TextUtils .isEmpty(phone) || phone.length<10){
                Toast.makeText(this, "plz enter number correctly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                this.finish()


            }

        }
    }
}