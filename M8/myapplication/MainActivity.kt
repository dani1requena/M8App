package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin : Button = findViewById(R.id.btnSignIn)
        val txtUsername :EditText = findViewById(R.id.txtUsername)
        var txtMessage : TextView = findViewById(R.id.txtMessege)
        var txtPassword:EditText = findViewById(R.id.txtPassword)
        var txtLoginResult : TextView = findViewById(R.id.txtMessege);

        btnLogin.setOnClickListener{
            Log.i("User",txtUsername.getText().toString())
            Log.i("Password",txtPassword.getText().toString())
                 txtMessage.setText("")
            if(txtUsername.getText().toString() == "admin" && txtPassword.getText().toString() == "admin"){
                txtMessage.setText("Bienvenido!")

                val intent = Intent(this, BottomNavigation::class.java)
                startActivity(intent)

            }else{
                txtMessage.setText("Usuario incorrecto!")
            }
        }
    }
}