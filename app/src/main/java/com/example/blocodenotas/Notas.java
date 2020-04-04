package com.example.blocodenotas;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Notas {
    SharedPreferences preferencias;
    SharedPreferences.Editor editorPreferencias;
    Context contexto;
    private static final String PREFERENCIAS_FILE ="Notas";

    public Notas(Context c) {
        this.contexto = c;
        preferencias = this.contexto.getSharedPreferences(PREFERENCIAS_FILE, Context.MODE_PRIVATE);
        editorPreferencias = preferencias.edit();
    }
    public void salvaNota(String s) {
        editorPreferencias.putString("Notas", s);
        editorPreferencias.commit();
    }
    public String recuperaNota(){
        if (this.preferencias.contains("nota")){
            String s= contexto.getResources().getString(R.string.nota_recuperada);
            Toast.makeText(contexto,s,Toast.LENGTH_LONG).show();
            return this.preferencias.getString("nota","");
        } else{
            return "";
        }
    }
}
