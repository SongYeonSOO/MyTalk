package ys.grad.mytalk;

import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.app.Service;
import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class TalkActivity extends Activity implements View.OnClickListener {
    EditText editView;
    TalkAdapter talkAdapter;
    RecyclerView talkRecyclerview;
    ArrayList<Talk> talks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_talk);

        editView = (EditText) findViewById(R.id.talk_edit_text);
        talkRecyclerview = (RecyclerView) findViewById(R.id.talk_recycler);
        talkAdapter = new TalkAdapter(talks);
        talkRecyclerview.setAdapter(talkAdapter);
        talkRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                if (editView.getText().toString().equals("")) {
                    break;
                }
                Log.d("TAG", "onClick: here");
                talks.add(new Talk(editView.getText().toString(), true));
                talks.add(new Talk("ANS: " + editView.getText().toString(), false));

                for (Talk t : talks) {
                    Log.d("TAG", "onClick: " + t.getTime() + " / " + t.getTalk() + " / " + t.isMe());
                }
                Log.d("TAG", "onClick: " + talkAdapter.getItemCount());
                talkAdapter.notifyDataSetChanged();
                editView.setText("");
                break;
        }
    }
}
