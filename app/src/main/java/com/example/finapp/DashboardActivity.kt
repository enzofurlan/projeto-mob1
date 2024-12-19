package com.example.finapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val buttonCadastrar: Button = findViewById(R.id.buttonCadastrar)
        val buttonExtrato: Button = findViewById(R.id.buttonExtrato)
        val buttonSair: Button = findViewById(R.id.buttonSair)

        buttonCadastrar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        buttonExtrato.setOnClickListener {
            val intent = Intent(this, ExtratoActivity::class.java)
            startActivity(intent)
        }

        buttonSair.setOnClickListener {
            finish()
        }
    }
}