package com.nidigitalstudio.jokempostudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");

    }
    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");

    }
    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");

    }

    public void opcaoSelecionada (String escolhaUsuario){


        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        //System.out.println(opcaoUsuario);
        //gerar escolha do app
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);

        String escolhaApp = opcoes[numero];

        switch(escolhaApp){
            case"pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case"papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case"tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (escolhaApp=="pedra" && escolhaUsuario == "tesoura")
                || (escolhaApp == "papel" && escolhaUsuario == "pedra")
                ||(escolhaApp == "tesoura" && escolhaUsuario=="papel")
                ) {//vitoria do app
            textResultado.setText("Nao foi dessa vez, tente novamente");

        }else if (
                (escolhaUsuario=="pedra" && escolhaApp == "tesoura")
                || (escolhaUsuario == "papel" && escolhaApp == "pedra")
                ||(escolhaUsuario == "tesoura" && escolhaApp=="papel")
                ){//vitoria do jogador
            textResultado.setText("PARABENS");

        }else {//empate
            textResultado.setText("Uhhhhh, foi quase ");

        }

    }
}
