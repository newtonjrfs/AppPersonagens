package newton.com.apppersonagens;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] listaNomes = {"Felpuro", "Fofura", "Lesmo", "Bugado", "Uruca", "Racing", "iOS"};

    int[] listaIcones = {R.drawable.felpudo, R.drawable.fofura, R.drawable.lesmo,
            R.drawable.bugado, R.drawable.uruca, R.drawable.carrinho, R.drawable.ios};

    String[] listaDescricoes = {"Felpuro e um cara legal", "Fofura eu nao conheco", "Lesmo tambem e massa",
            "Bugado e chato", "Uruca e igual o Wash", "Racing e e correr", "iOS e android"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView minhaLista = findViewById(R.id.listaPersonagens);
        final MeuAdaptador meuAdaptador = new MeuAdaptador(getApplicationContext(), R.layout.corpodalista);
        int i = 0;
        for (String nome : listaNomes) {
            DadosPersonagem dadosPersonagem;
            dadosPersonagem = new DadosPersonagem(listaIcones[i], nome);
            meuAdaptador.add(dadosPersonagem);
            i++;
        }

        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        minhaLista.setAdapter(meuAdaptador);
    }
}
class viewPersonagem{
    ImageView icone;
    TextView titulo;
}

class DadosPersonagem{
    int icone;
    String titulo;

    public DadosPersonagem(int icone, String titulo) {
        this.icone = icone;
        this.titulo = titulo;
    }

    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

class MeuAdaptador extends ArrayAdapter {

    public MeuAdaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View minhaView;
        minhaView = convertView;
        viewPersonagem viewPersonagem;

        if (convertView == null){

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            minhaView = inflater.inflate(R.layout.corpodalista,parent,false);

            viewPersonagem = new viewPersonagem();
            viewPersonagem.icone = minhaView.findViewById(R.id.listIcone);
            viewPersonagem.titulo = minhaView.findViewById(R.id.listNome);

            minhaView.setTag(viewPersonagem);

        }else{
            viewPersonagem = (viewPersonagem) minhaView.getTag();
        }

        DadosPersonagem dadosPersonagem;
        dadosPersonagem = (DadosPersonagem) this.getItem(position);

        viewPersonagem.icone.setImageResource(dadosPersonagem.getIcone());
        viewPersonagem.titulo.setText(dadosPersonagem.getTitulo());

        return minhaView;
    }
}