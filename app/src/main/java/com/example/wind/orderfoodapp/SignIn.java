package com.example.wind.orderfoodapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wind.orderfoodapp.Modelo.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    EditText edtNumero, edtContraseña;
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtNumero = (MaterialEditText) findViewById(R.id.edtTelefono);
        edtContraseña = (MaterialEditText) findViewById(R.id.edtContraseña);
        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);

        //Iniciar Firebase...
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabla_usuarios = database.getReference("Usuario");

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Porfavor espere...");

                tabla_usuarios.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Comprobar si el usuario existe en la base de datos.
                        if (dataSnapshot.child(edtNumero.getText().toString()).exists()){
                            //Obtener informacion de usuario.
                            mDialog.dismiss();
                            Usuario user = dataSnapshot.child(edtNumero.getText().toString()).getValue(Usuario.class);
                            if(user.getContraseña().equals(edtContraseña.getText().toString())){
                                Toast.makeText(SignIn.this,"Inicio exitoso !",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(SignIn.this,"Inicio Fallido !!!",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignIn.this,"Usuario no existe en la abse de datos",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
