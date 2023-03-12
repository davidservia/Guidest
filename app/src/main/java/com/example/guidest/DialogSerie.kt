package com.example.guidest

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.guidest.databinding.DialogInputBinding

class DialogSerie(
    private val onSubmitClickListener: (Float) -> Unit
): DialogFragment() {
    private lateinit var binding: DialogInputBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogInputBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.bAddQuantity.setOnClickListener{
            onSubmitClickListener.invoke(binding.etAmount.text.toString().toFloat())
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
}