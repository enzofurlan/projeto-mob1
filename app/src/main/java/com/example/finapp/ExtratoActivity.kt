package com.example.finapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ExtratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_extrato)

        val transacoes = TransacaoStorage.transacoes
        val listViewExtrato = findViewById<ListView>(R.id.listViewExtrato)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            transacoes.map {
                "\nTipo: ${it.tipo} \nDescrição: ${it.descricao} \nValor: R$${it.valor}\n"
            }
        )
        listViewExtrato.adapter = adapter

        val buttonVoltar: Button = findViewById(R.id.buttonVoltar)
        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}