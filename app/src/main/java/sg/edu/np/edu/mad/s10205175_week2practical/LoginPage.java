package sg.edu.np.edu.mad.s10205175_week2practical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Users");

        ((Button)findViewById(R.id.loginButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView inName = findViewById(R.id.inputUName);
                TextView inPw = findViewById(R.id.inputPw);
                String iName = inName.getText().toString(); //assume the username is the same as the user objects under "Users"
                String iPw = inPw.getText().toString();
                ref.child("mad").addValueEventListener(new ValueEventListener() { //specific for the "mad" user only in this case
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //{password=11877, username=mad}
                        if ((iName.equals(snapshot.child("username").getValue().toString())) && (iPw.equals(snapshot.child("password").getValue().toString()))){
                            Intent i = new Intent(LoginPage.this, ListActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(LoginPage.this,"Incorrect name or password",Toast.LENGTH_SHORT).show();
                            inName.setText("");
                            inPw.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w("fail", "Failed to read value.", error.toException());
                    }
                });
            }
        });

    }
}