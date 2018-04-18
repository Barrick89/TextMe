package com.mahausch.textme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
}
