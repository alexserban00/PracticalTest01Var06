package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();

        int nrBife = 0;
        boolean gained = false;

        if (b.getString(Constants.NUMERE1Text).equals("*")) {
            nrBife += 1;

            if (b.getString(Constants.NUMERE2Text).equals(b.getString(Constants.NUMERE3Text))
                    || b.getString(Constants.NUMERE2Text).equals("*")
                    || b.getString(Constants.NUMERE3Text).equals("*")) {
                gained = true;
            }
        }

        if (b.getString(Constants.NUMERE2Text).equals("*")) {
            nrBife += 1;
            if (b.getString(Constants.NUMERE1Text).equals(b.getString(Constants.NUMERE3Text))
                    || b.getString(Constants.NUMERE1Text).equals("*")
                    || b.getString(Constants.NUMERE3Text).equals("*")) {
                gained = true;
            }
        }

        if (b.getString(Constants.NUMERE3Text).equals("*")) {
            nrBife += 1;

            if (b.getString(Constants.NUMERE1Text).equals(b.getString(Constants.NUMERE2Text))
                    || b.getString(Constants.NUMERE1Text).equals("*")
                    || b.getString(Constants.NUMERE2Text).equals("*")) {
                gained = true;
            }
        }

        if (b.getString(Constants.NUMERE1Text).equals(b.getString(Constants.NUMERE2Text))
                && b.getString(Constants.NUMERE2Text).equals(b.getString(Constants.NUMERE3Text)))
        {
            gained = true;
        }

        Intent out = new Intent();
        if (gained) {
            switch (nrBife) {
                case 0:
                    nrBife = 100;
                    break;
                case 1:
                    nrBife = 50;
                    break;
                case 2:
                    nrBife = 10;
                    break;
                default:
                    nrBife = 0;
                    break;
            }
            out.putExtra(Constants.RESULT_SECONDARY_ACTIVITY, String.valueOf(nrBife));
            setResult(RESULT_OK, out);
        }
        else {
            setResult(RESULT_CANCELED, out);
        }

        finish();
    }
}