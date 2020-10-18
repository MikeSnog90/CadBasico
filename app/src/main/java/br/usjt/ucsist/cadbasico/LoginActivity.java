package br.usjt.ucsist.cadbasico;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.orhanobut.hawk.Hawk;

public class LoginActivity extends AppCompatActivity {
    private TextView textViewNovoCadastro;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Hawk.init(this).build();

        textViewNovoCadastro = findViewById(R.id.textViewNovoCadastro);
        buttonLogin = findViewById(R.id.buttonLogin);


    }



    @Override
    public void onResume() {
        super.onResume();
        if (Hawk.contains("tem_cadastro")){
            if(Hawk.get("tem_cadastro")){
                habilitarLogin();
            }else{
                desabilitarLogin();
            }
        }else{
            desabilitarLogin();
        }
    }


    //abaixo é onde habilito e desabilito o login

    private void habilitarLogin(){
        textViewNovoCadastro.setVisibility(View.GONE);
        buttonLogin.setEnabled(true);
        buttonLogin.setBackgroundColor(getColor(R.color.colorPrimary));
    }

    private void desabilitarLogin(){
        textViewNovoCadastro.setVisibility(View.VISIBLE);
        buttonLogin.setEnabled(false);
        buttonLogin.setBackgroundColor(R.color.gray);
    }

    //abaixo é onde faço a transição das Telas

    public void novoCadastro(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity (intent);
    }

    public void login(View view) {
        Intent intent = new Intent( this, MainActivity.class);
        startActivity (intent);
    }
}