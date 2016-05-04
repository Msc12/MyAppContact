package com.mascware.app.myappcontact;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityConfirm extends AppCompatActivity {
    TextView textNombre;
    TextView textTel ;
    TextView textMail;
    TextView textDesc ;
    TextView textFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_confirm);
         textNombre = (TextView) findViewById(R.id.infoNombre);
         textTel = (TextView) findViewById(R.id.infotel);
         textMail = (TextView) findViewById(R.id.infoMail);
         textDesc = (TextView) findViewById(R.id.infoDesc);
         textFecha =(TextView) findViewById(R.id.infoFecha);
        final Intent intent = getIntent();
        String messageAux=intent.getStringExtra("nombre");
        textNombre.setText(textNombre.getText()+" " +messageAux);
         messageAux=intent.getStringExtra("tel");
        textTel.setText(textTel.getText()+" " +messageAux);
         messageAux=intent.getStringExtra("mail");
        textMail.setText(textMail.getText()+" " +messageAux);
        messageAux=intent.getStringExtra("desc");
        textDesc.setText(textDesc.getText()+" " +messageAux);
        messageAux=intent.getStringExtra("fecha");
        textFecha.setText(textFecha.getText()+" " +messageAux);
        Button botonEdit = (Button) findViewById(R.id.buttonEdit);
        botonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
