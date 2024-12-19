package com.example.finapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)

        val buttonVoltar: Button = findViewById(R.id.buttonCadastroVoltar)
        buttonVoltar.setOnClickListener {
            finish()
        }
    }

    fun salvarTransacao(view: View) {
        val spinnerTipo: Spinner = findViewById(R.id.spinnerTipo)
        val editTextDescricao: EditText = findViewById(R.id.editTextDescricao)
        val editTextValor: EditText = findViewById(R.id.editTextValor)

        if (editTextValor.length() == 0 || editTextDescricao.length() == 0) {
            Toast.makeText(
                this,
                "Insira uma descrição e um valor.",
                Toast.LENGTH_SHORT).show()
        }
        else {
            val tipo = spinnerTipo.selectedItem.toString()
            val descricao = editTextDescricao.text.toString()
            val valor = editTextValor.text.toString().toDouble()

            val transacao = Transacao(tipo, descricao, valor)
            // Fizemos a utilização de um objeto ao inves do Parcelable ou Serializable
            TransacaoStorage.transacoes.add(transacao)

            // Redireciona para a tela de extrato já com a transação salva
            val intent = Intent(this, ExtratoActivity::class.java)
            startActivity(intent)

            Toast.makeText(
                this,
                "Transação salva!",
                Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}