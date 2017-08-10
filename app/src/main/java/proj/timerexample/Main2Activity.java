package proj.timerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {
Button btn;
    int c=1;
    LinearLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn= (Button) findViewById(R.id.btn);
        l1= (LinearLayout) findViewById(R.id.lin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                Button button=new Button(getApplicationContext());
                button.setId(c);
                button.setText("Hello"+c);
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                button.setLayoutParams(layoutParams);
                l1.addView(button);
            }
        });

    }
}
