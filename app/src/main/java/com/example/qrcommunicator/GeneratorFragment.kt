package com.example.qrcommunicator

import android.content.Context.MODE_PRIVATE
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import io.github.g0dkar.qrcode.QRCode
import java.io.File
import java.io.FileInputStream


class GeneratorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_qr_generator, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonGenerate:Button=requireView().findViewById(R.id.button_generate_qr)
        val editTextTextToQR:EditText=requireView().findViewById(R.id.edit_text_text_to_qr)
        val imageViewQR: ImageView =requireView().findViewById(R.id.image_view_qr)

        buttonGenerate.setOnClickListener {
            Log.d("0", "ITEMBUTTON")
            val fileOut = activity?.openFileOutput("example.bmp", MODE_PRIVATE)

            val cellSize = 30 // pixels

            if (fileOut != null) {
                QRCode(editTextTextToQR.text.toString())
                    .render(cellSize, margin = cellSize)
                    .writeImage(fileOut, "BMP")
            }

            fileOut?.close()

            val fileIn = FileInputStream(File(activity?.filesDir, "example.bmp"))

            val bitmap = BitmapFactory.decodeStream(fileIn)

            imageViewQR.setImageBitmap(bitmap)

            fileIn.close()
        }
    }

}