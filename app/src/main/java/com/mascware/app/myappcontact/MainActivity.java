package com.mascware.app.myappcontact;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int request_code = 1;
    private Button butongte;
    EditText textNombre;
    EditText textMail;
    EditText textTel ;
    EditText textDesc;
    DatePicker dataPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butongte = (Button) findViewById(R.id.buttongte);
        textNombre = (EditText) findViewById(R.id.textNombre);
        textMail = (EditText) findViewById(R.id.textMail);
        textTel = (EditText) findViewById(R.id.textTel);
        textDesc = (EditText) findViewById(R.id.textDesc);
        dataPicker=(DatePicker) findViewById(R.id.datePicker);
        butongte.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            accionSgte();
                                        }
                                    }
        );
    }

    private void accionSgte(){
        Intent intent = new Intent(MainActivity.this, ActivityConfirm.class);
        String messageAux = textNombre.getText().toString();

        intent.putExtra("nombre", messageAux);
        messageAux = textTel.getText().toString();
        intent.putExtra("tel", messageAux);
        messageAux = textMail.getText().toString();
        intent.putExtra("mail", messageAux);
        messageAux = textDesc.getText().toString();
        intent.putExtra("desc", messageAux);
        messageAux=Integer.toString(dataPicker.getDayOfMonth())+"/"+Integer.toString((dataPicker.getMonth()+1))+"/"
                    +Integer.toString(dataPicker.getYear());
        intent.putExtra("fecha",messageAux);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if ((requestCode == request_code) && (resultCode == RESULT_OK)){
            textNombre.setText(data.getStringExtra("nombre"));
            textTel.setText(data.getStringExtra("tel"));
            textMail.setText(data.getStringExtra("mail"));
            textDesc.setText(data.getStringExtra("desc"));

        }
    }
}
