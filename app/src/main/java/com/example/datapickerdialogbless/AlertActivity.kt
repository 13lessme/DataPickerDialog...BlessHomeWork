package com.example.datapickerdialogbless

import android.content.Intent
import android.graphics.Color
import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_alert.*

class AlertActivity : AppCompatActivity(), AlertText.AlertTextListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)
    }
    fun showDialog(view: View) {
        val builder = AlertDialog.Builder(this@AlertActivity)
        builder.setTitle("App background color")
        builder.setMessage("Вы хотите поменять фон?")
        builder.setPositiveButton("Да"){ dialog, which ->  
            Toast.makeText(applicationContext, "Фон изменился", Toast.LENGTH_LONG).show()
            fon.setBackgroundColor(Color.CYAN)
        }
        builder.setNegativeButton("нет"){dialog, which -> 
            Toast.makeText(applicationContext, "Фон не изменеился", Toast.LENGTH_LONG).show()
        }
        builder.setNeutralButton("Отмена"){_, _ ->
            Toast.makeText(applicationContext, "отмена операции", Toast.LENGTH_LONG).show()
        }
        builder.create().show()
    }
    fun showDialogRadioButton(view: View) {
        val namesArray =
            arrayOf("Первый", "Второй", "Третий")
        val builder =
            AlertDialog.Builder(this@AlertActivity)
        builder.setTitle("выберите поле из списка: ")
            .setSingleChoiceItems(
                namesArray, -1
            ){dialog, item ->
                Toast.makeText(
                    this@AlertActivity, "Вы выбрали: " + namesArray[item],
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setPositiveButton("ОК"){dialog, id ->
            }
            .setNegativeButton("Отмена"){dialog, id ->  }
       builder.create().show()
    }
    fun showAlertTextFields(view: View) {
        val exampleDialog = AlertText()
        exampleDialog.show(supportFragmentManager, " alertText")
    }

    override fun applyTexts(address: String?, city: String?, comment: String?) {
        Toast.makeText(this@AlertActivity, "Вы ввели: $address $city $comment", Toast.LENGTH_SHORT).show()
    }

}
