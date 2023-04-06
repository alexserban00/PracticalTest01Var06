package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    private EditText numere1;
    private EditText numere2;
    private EditText numere3;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private Button play;

    private TextView gain;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        numere1 = findViewById(R.id.numere1);
        numere2 = findViewById(R.id.numere2);
        numere3 = findViewById(R.id.numere3);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        play = findViewById(R.id.Play);
        gain = findViewById(R.id.Gain);

        play.setOnClickListener(buttonClickListener);
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Play:
                    Random r = new Random();
                    if (checkBox1.isChecked()) {
                        numere1.setText(Constants.randValues[3]);
                    }
                    else {
                        numere1.setText(Constants.randValues[r.nextInt(3)]);
                    }

                    if (checkBox2.isChecked()) {
                        numere2.setText(Constants.randValues[3]);
                    }
                    else {
                        numere2.setText(Constants.randValues[r.nextInt(3)]);
                    }

                    if (checkBox3.isChecked()) {
                        numere3.setText(Constants.randValues[3]);
                    }
                    else {
                        numere3.setText(Constants.randValues[r.nextInt(3)]);
                    }

                    Toast.makeText(getApplicationContext(),
                                numere1.getText().toString() + ' '
                                    + numere2.getText().toString() + ' '
                                        + numere3.getText().toString(), Toast.LENGTH_SHORT).show();

                    Intent checkGainIntent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);
                    checkGainIntent.putExtra(Constants.NUMERE1Text, numere1.getText().toString());
                    checkGainIntent.putExtra(Constants.NUMERE2Text, numere2.getText().toString());
                    checkGainIntent.putExtra(Constants.NUMERE3Text, numere3.getText().toString());
                    startActivityForResult(checkGainIntent, Constants.REQUEST_SECONDARY_ACTIVITY);
                    break;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST_SECONDARY_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                gain.setText(data.getStringExtra(Constants.RESULT_SECONDARY_ACTIVITY));
                Toast.makeText(getApplicationContext(), "GAINED" + " " + data.getStringExtra(Constants.RESULT_SECONDARY_ACTIVITY), Toast.LENGTH_SHORT).show();
            }
            else {
                gain.setText("");
            }
        }
    }
}