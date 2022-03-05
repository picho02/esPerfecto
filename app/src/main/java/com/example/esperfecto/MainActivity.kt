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
                binding.tvResultado.text = "Si es Perfecto los divisores son ${numeros}"
            }else{
                binding.tvResultado.text = "No es perfecto los divisores son ${numeros}"
            }

        }else{
            binding.etNumero.error = "ingresa un numero"
            binding.etNumero.requestFocus()
        }

    }
    private fun validaCampo():Boolean{
        return binding.etNumero.text.toString() != ""
    }
    private fun esPerfecto(num:Int):Boolean{
        if(num != 0){
        numeros.clear()
        for (i in 1 until num){
            if (num%i == 0){
                numeros.add(i)
            }
        }
        var sumaNum = 0
        for(i in 0 until numeros.size){
            sumaNum += numeros[i]
        }
        return sumaNum == num
    }else{

        return false
    }
    }
}