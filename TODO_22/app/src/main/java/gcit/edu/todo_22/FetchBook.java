package gcit.edu.todo_22;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class FetchBook extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mTitleTxt;

   FetchBook(TextView titleText, TextView authorText){
       this.mAuthorTxt = new WeakReference<>(authorText);
       this.mTitleTxt = new WeakReference<>(titleText);
   }


    private WeakReference<TextView> mAuthorTxt;


    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;
            String title = null;
            String authors = null;
            while (i < itemsArray.length() &&
                    (authors == null && title == null)) {
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (title != null && authors != null){
                    mTitleTxt.get().setText(title);
                    mAuthorTxt.get().setText(authors);
                }
                else {
                    mTitleTxt.get().setText("No results found...");
                }
            }
            i++;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }
}
