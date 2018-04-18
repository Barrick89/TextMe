package com.mahausch.textme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String ANONYMOUS = "anonymous";
    public static final int DEFAULT_MSG_LENGTH_LIMIT = 1000;

    private MessageAdapter messageAdapter;

    @BindView(R.id.recyclerView)
    private RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    private ProgressBar progressBar;

    @BindView(R.id.photoPickerButton)
    private ImageButton photoPickerButton;

    @BindView(R.id.messageEditText)
    private EditText messageEditText;

    @BindView(R.id.sendButton)
    private Button sendButton;

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        username = ANONYMOUS;

        List<TextMeMessage> messages = new ArrayList<>();
        messageAdapter = new MessageAdapter(this, messages);
        recyclerView.setAdapter(messageAdapter);
    }
}
