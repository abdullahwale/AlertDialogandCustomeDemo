package com.example.hp.alertdialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {
    EditText  etUSername,etuserPassword;
    ExampleDilogListner listner;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder adb= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog,null);
        adb.setView(view)
                .setTitle("Login Dialog")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username=etUSername.getText().toString();
                        String userpass=etuserPassword.getText().toString();
                        listner.ApplyText(username,userpass);
                    }
                });
etUSername= view.findViewById(R.id.etUserName);
etuserPassword=view.findViewById(R.id.etPassword);
return adb.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listner= (ExampleDilogListner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+
            "Must Implement ExampleDialogListner");
        }
    }

    public interface ExampleDilogListner{
        void ApplyText(String name, String pass);
    }
}
