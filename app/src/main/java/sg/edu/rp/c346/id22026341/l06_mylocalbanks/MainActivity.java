package sg.edu.rp.c346.id22026341.l06_mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    TextView tvTitle;

    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        tvTitle = findViewById(R.id.textViewTitle);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
        registerForContextMenu(tvTitle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem language) {
        int id = language.getItemId();
        if(id == R.id.EnglishSelection)
        {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            tvTitle.setText("SELECT A BANK");
            return true;
        }
        else if(id == R.id.chineseSelection)
        {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            tvTitle.setText("选择以下银行");
            return true;
        }
        return super.onOptionsItemSelected(language);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if(v == tvDBS)
        {
            wordClicked = "DBS";
        }
        else if(v == tvOCBC)
        {
            wordClicked = "OCBC";
        }
        else if(v == tvUOB)
        {
            wordClicked = "UOB";
        }
    }

    public boolean onContextItemSelected(MenuItem bank) {
        if(wordClicked.equalsIgnoreCase("DBS"))
        {
            if(bank.getItemId()==0)
            {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            }
            else if(bank.getItemId()==1)
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18001111));
                startActivity(intentCall);
            }
        }
        else if(wordClicked.equalsIgnoreCase("OCBC"))
        {
            if(bank.getItemId()==0)
            {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            }
            else if(bank.getItemId()==1)
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18003633));
                startActivity(intentCall);
            }
        }
        else if(wordClicked.equalsIgnoreCase("UOB"))
        {
            if(bank.getItemId()==0)
            {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }
            else if(bank.getItemId()==1)
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18002221));
                startActivity(intentCall);
            }
        }
        return super.onContextItemSelected(bank);
    }
}