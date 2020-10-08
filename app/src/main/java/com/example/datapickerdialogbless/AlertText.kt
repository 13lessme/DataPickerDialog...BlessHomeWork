package com.example.datapickerdialogbless

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import java.lang.ClassCastException

class AlertText : AppCompatDialogFragment() {
private var editTextAddress: EditText? = null
    private var editTextCity: EditText? = null
    private var editTextComment: EditText? = null
    private var listener: AlertTextListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.activity_alert_text, null)
        builder.setView(view)
            .setTitle("Добавить адрес")
            .setNegativeButton("Отмена"){dialog: DialogInterface?, which: Int ->  }
            .setPositiveButton("Принять") { dialogInterface, i ->
                val adress = editTextAddress!!.text.toString()
                val city = editTextCity!!.text.toString()
                val comment = editTextComment!!.text.toString()
                listener!!.applyTexts(adress,city,comment)
            }
        editTextAddress = view.findViewById(R.id.edtAddress)
        editTextCity = view.findViewById(R.id.edtCity)
        editTextComment = view.findViewById(R.id.edtComment)
        return builder.create()
        
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as AlertTextListener
        }catch (e: ClassCastException){
            throw ClassCastException(context.toString() + "Отсутствует implement AlertTextListener")
        }
    }
    interface AlertTextListener{
        fun applyTexts(
            address: String?,
            city:String?,
            comment: String?
        )
    }
    
}
