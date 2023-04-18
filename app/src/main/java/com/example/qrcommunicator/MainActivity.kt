package com.example.qrcommunicator

    import android.annotation.SuppressLint
    import android.content.Intent
    import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
    import android.util.Log
    import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
    import com.google.android.material.navigation.NavigationBarView
    import io.github.g0dkar.qrcode.QRCode
import java.io.File
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {

    val GeneratorFragment=GeneratorFragment()
    val ScannerFragment=ScannerFragment()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*        val buttonGenerate:Button=findViewById(R.id.button_generate_qr)
        val editTextTextToQR:EditText=findViewById(R.id.edit_text_text_to_qr)
        val imageViewQR: ImageView =findViewById(R.id.image_view_qr)*/
        val navigationBarView:NavigationBarView=findViewById(R.id.bottom_navigation)

        supportFragmentManager.beginTransaction().replace(R.id.container,ScannerFragment).commit()

        navigationBarView.setOnItemSelectedListener {
                item ->
            when(item.itemId) {
                R.id.item_generator -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container,GeneratorFragment).commit()
/*                    println("ITEM1")
                    Log.d("0","ITEM1")
                    val intent= Intent(this,MainActivity::class.java)
                    this.startActivity(intent)*/
                    true
                }
                R.id.item_scanner -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container,ScannerFragment).commit()
                    true
                }
                R.id.item_history -> {
//                    TODO("Implement")
                    supportFragmentManager.beginTransaction().replace(R.id.container,ScannerFragment).commit()
                    true
                }
                R.id.item_settings -> {
//                    TODO("Implement")
                    supportFragmentManager.beginTransaction().replace(R.id.container,ScannerFragment).commit()
                    true
                }
                else -> {Log.d("0","ITEMFALSE")
                    false}
            }
        }











/*        buttonGenerate.setOnClickListener {
            val fileOut = FileOutputStream("example.bmp")


            val cellSize = 30 // pixels

            QRCode(editTextTextToQR.text.toString())
                .render(cellSize, margin = cellSize)
                .writeImage(fileOut,"BMP")

            fileOut.close()


            val fileIn = FileInputStream(File("example.bmp"))

            val bitmap = BitmapFactory.decodeStream(fileIn)

            imageViewQR.setImageBitmap(bitmap)

            fileIn.close()




            //imageViewQR.setImageBitmap(fileOut)
        }*/
/*        buttonGenerate.setOnClickListener {
            Log.d("0","ITEMBUTTON")
            val fileOut = openFileOutput("example.bmp", MODE_PRIVATE)

            val cellSize = 30 // pixels

            QRCode(editTextTextToQR.text.toString())
                .render(cellSize, margin = cellSize)
                .writeImage(fileOut, "BMP")

            fileOut.close()

            val fileIn = FileInputStream(File(filesDir, "example.bmp"))

            val bitmap = BitmapFactory.decodeStream(fileIn)

            imageViewQR.setImageBitmap(bitmap)

            fileIn.close()*/
            //val intent= Intent(this,ScannerActivity::class.java)
            //this.startActivity(intent)


    }



}