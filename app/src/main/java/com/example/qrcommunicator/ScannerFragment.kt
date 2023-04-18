package com.example.qrcommunicator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.budiyev.android.codescanner.*
import java.net.URI


class ScannerFragment : Fragment() {

    private lateinit var codeScanner: CodeScanner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_scanner, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)

        codeScanner = CodeScanner(requireContext(), scannerView)




        // Parameters (default values)
        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.ALL_FORMATS // list of type BarcodeFormat,
        // ex. listOf(BarcodeFormat.QR_CODE)
        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not

        // Callbacks
        codeScanner.decodeCallback = DecodeCallback {
            activity?.runOnUiThread {
                try{
                    val url=Uri.parse(it.text)

                    val intent = Intent(Intent.ACTION_VIEW, url)
                    //val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"))
                    startActivity(intent)
                }
                catch (e:Exception){
                    val intent=Intent(context,ResultActivity::class.java).apply {
                        putExtra("Result",it.text)
                    }
                    context?.startActivity(intent)
                    //Toast.makeText(requireContext(), "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
                }
                //Toast.makeText(requireContext(), "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
            }
        }


        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }



    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

}