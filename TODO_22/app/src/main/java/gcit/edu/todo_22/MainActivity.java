package gcit.edu.todo_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTitleTxt;
    private TextView mAuthorTxt;
    private  EditText mBookInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitleTxt = findViewById(R.id.titletxt);
        mAuthorTxt = findViewById(R.id.authortxt);
        mBookInput = findViewById(R.id.bookinput);
    }

    public void Searchbook(View view) {
        String queryString = mBookInput.getText().toString();
        new FetchBook(mTitleTxt, mAuthorTxt).execute(queryString);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null){
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isConnected()
        && queryString.length() != 0){
            new FetchBook(mTitleTxt, mAuthorTxt).execute(queryString);
            mAuthorTxt.setText("");
            mTitleTxt.setText("Loading......");
        }
        else {
            if (queryString.length() == 0){
                mAuthorTxt.setText("");
                mTitleTxt.setText("Please check your network connection");
            }
        }
    }
}