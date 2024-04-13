package com.example.qrc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateQRCodeActivity extends AppCompatActivity {
    private ImageView qrCodeIV;
    private TextInputEditText dataEdt;
    private Button generateQRBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);
        qrCodeIV =findViewById(R.id.idIVQRCode);
        dataEdt = findViewById(R.id.idEDtData);
        generateQRBtn = findViewById(R.id.idBtnGenerateQR);

        generateQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(dataEdt.getText().toString(), BarcodeFormat.QR_CODE,300,300);
                    BarcodeEncoder barcodeEncoder  = new BarcodeEncoder();
                    Bitmap bitmap= barcodeEncoder.createBitmap(bitMatrix);
                    qrCodeIV.setImageBitmap(bitmap);

                } catch (WriterException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        });
    }
}