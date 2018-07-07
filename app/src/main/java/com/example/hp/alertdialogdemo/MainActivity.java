package com.example.hp.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDilogListner{
Button btnClick,btnLoginCutom;
TextView tvUSer,tvPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoginCutom=(Button) findViewById(R.id.btnLogin);
        tvUSer=(TextView) findViewById(R.id.tvUsername);
        tvPass=(TextView) findViewById(R.id.tvPassword);

        btnLoginCutom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }

public void openDialog()
{

    ExampleDialog exampleDialog=new ExampleDialog();
    exampleDialog.show(getSupportFragmentManager(),"example dialog");
}

    @Override
    public void ApplyText(String name, String pass) {
        tvUSer.setText(name);
        tvPass.setText(pass);
    }

    public void DialogOpenMethod(View view)
    {
        btnClick=(Button) findViewById(R.id.btnOpenDialogAlert);
        AlertDialog.Builder  ADB= new AlertDialog.Builder(MainActivity.this);
        ADB.setMessage("Do you Want to Quit this App").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = ADB.create();
        alert.setTitle("PakAcademy79 Alert DialogBOx");
        alert.show();
    }

}
