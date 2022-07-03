package sg.edu.np.edu.mad.s10205175_week2practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button followbutton = findViewById(R.id.button2);
        userclass user1 = initial();
        followstatus(user1, followbutton);
        //Button messaging = findViewById(R.id.button3);
        followbutton.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view) {
        String ToastText;
        if (user1.followed == false) {
            user1.followed = true;
            ToastText = "Followed";
        } else {
            user1.followed = false;
            ToastText = "Unfollowed";
        }
        followstatus(user1, followbutton);

        Toast tTEXT = Toast.makeText(MainActivity.this,ToastText,Toast.LENGTH_SHORT);
        tTEXT.show();
    }

            });

        Intent receivingEnd = getIntent();
        Integer genInt = receivingEnd.getIntExtra("genInt",0);
        TextView txt = findViewById(R.id.textView2);
        txt.setText(String.format("MAD %s",genInt));//java string formatting, like python printf

        //event onclick listener for message button
        Button messageButton = findViewById(R.id.button3);
        messageButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent NewAct = new Intent(MainActivity.this, MessageGroup.class);
            startActivity(NewAct);
        }
    });

    };

    public userclass initial()
    {
        userclass initialization = new userclass("name","description",0,false);
        return initialization;
    }

    public void followstatus (userclass userclass, Button button2)
        {
            TextView txt = findViewById(R.id.button2);
            if(userclass.followed == false)
        {
        txt.setText("Follow");
        }
        else
        {
        txt.setText("Unfollow");
        }
        };
    public void message (userclass userclass, Button button3)
    {
        TextView txt = findViewById(R.id.button3);

    };



};








