package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        val spinner = findViewById<Spinner>(R.id.spnElements)
        val list = listOf  ("English","Español","Srpski")
        val adaptador=ArrayAdapter(this, android.R.layout.simple_spinner_item,list)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    TODO("Not yet implemented")
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }



        //Si nunca has entrado que salte a lo que viene después del if
        if(prefs.getBoolean("login",false)==true){
            val intent = Intent(this, BottomNavigation::class.java)
            startActivity(intent)
        }

        val check: Boolean = prefs.getBoolean("default",false)
        val recordar: CheckBox = findViewById(R.id.checkbox_iniciada)

        val btnLogin : Button = findViewById(R.id.btnSignIn)
        val txtUsername :EditText = findViewById(R.id.txtUsername)
        var txtMessage : TextView = findViewById(R.id.txtMessege)
        var txtPassword:EditText = findViewById(R.id.txtPassword)
        var editor = prefs.edit()
        recordar.isChecked = check;


        btnLogin.setOnClickListener{
            val UserName :String = txtUsername.getText().toString();
            val Password :String = txtPassword.getText().toString();
            Log.i("User",txtUsername.getText().toString())
            Log.i("Password",txtPassword.getText().toString())
                 txtMessage.setText("")
            if(UserName == "admin" && Password == "admin"){
                txtMessage.setText("Bienvenido!")
                if(recordar.isChecked){
                    editor.putString("User", UserName);
                    editor.putString("Password", Password);
                    editor.putBoolean("login", true);
                    editor.commit()
                }
                editor.clear().commit()
                val intent = Intent(this, BottomNavigation::class.java)
                startActivity(intent)


            }else{
                txtMessage.setText("Usuario incorrecto!")
            }
        }
    }
}