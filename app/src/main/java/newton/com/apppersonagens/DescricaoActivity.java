package newton.com.apppersonagens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescricaoActivity extends AppCompatActivity {

    TextView nomeDoPersonagem;
    TextView descricaoDoPersonagem;
    ImageView iconeDoPersonagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);

        nomeDoPersonagem = findViewById(R.id.desc_nome);
        descricaoDoPersonagem = findViewById(R.id.desc_desc);
        iconeDoPersonagem = findViewById(R.id.desc_icone);

        Bundle extras = getIntent().getExtras();

        if(extras!=null){

            String nomePersonagem = extras.getString("nomePersonagem");
            String descricaoPersonagem = extras.getString("descricaoPersonagem");
            int iconeId = extras.getInt("iconePersonagem");


            nomeDoPersonagem.setText(nomePersonagem);
            descricaoDoPersonagem.setText(descricaoPersonagem);
            iconeDoPersonagem.setImageResource(iconeId);

        }
        }
}
