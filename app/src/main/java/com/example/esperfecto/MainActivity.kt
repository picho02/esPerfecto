package com.example.esperfecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.esperfecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var numeros = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View) {
        if(validaCampo()){
            var numero = binding.etNumero.text.toString().toInt()
            if (esPerfecto(numero)){
                binding.tvResultado.text = "Si es Perfecto"
            }else{
                binding.tvResultado.text = "No es perfecto"
            }

        }else{
            binding.etNumero.error = "ingresa un numero"
            binding.etNumero.requestFocus()
        }

    }
    private fun validaCampo():Boolean{
        if (binding.etNumero.text.toString() == "")return false
        else return true
    }
    private fun esPerfecto(num:Int):Boolean{
        numeros.clear()
        for (i in 1 until num){
            if (num%i == 0){
                numeros.add(i)
            }
        }
        var sumaNum = 0
        for(i in 0 until numeros.size){
            sumaNum = sumaNum + numeros[i]
        }
        if (sumaNum == num){
            return true
        }else{
            return false
        }
    }
}