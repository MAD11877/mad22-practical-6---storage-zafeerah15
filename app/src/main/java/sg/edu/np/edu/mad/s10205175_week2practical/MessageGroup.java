package sg.edu.np.edu.mad.s10205175_week2practical;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
        Button grp1button , grp2button;
        grp1button = findViewById(R.id.grp1button);
        grp2button = findViewById(R.id.grp2button);


        grp1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repFragments(new groupFragment());
            }
        });

        grp2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repFragments(new group1Fragment());
            }
        });
    }
    public void repFragments(groupFragment frag){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,frag);
        ft.commit();
    }
}
