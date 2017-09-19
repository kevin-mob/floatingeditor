package cn.kevin.fastreplyfloatingeditor;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.kevin.floatingeditor.DefaultEditorHolder;
import cn.kevin.floatingeditor.EditorHolder;
import cn.kevin.floatingeditor.FloatEditorActivity;
import cn.kevin.floatingeditor.EditorCallback;
import cn.kevin.floatingeditor.InputCheckRule;

public class MainActivity extends AppCompatActivity implements EditorCallback, View.OnClickListener {
    TextView tvShow;
    Button btReply1;
    Button btReply2;
    Button btReply3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setEvent();
    }


    private void initView() {
        tvShow = (TextView) findViewById(R.id.tv);
        btReply1 = (Button) findViewById(R.id.bt_reply1);
        btReply2 = (Button) findViewById(R.id.bt_reply2);
        btReply3 = (Button) findViewById(R.id.bt_reply3);
    }

    private void setEvent() {
        btReply1.setOnClickListener(this);
        btReply2.setOnClickListener(this);
        btReply3.setOnClickListener(this);

    }

    @Override
    public void onCancel() {
        Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSubmit(String content) {
        tvShow.setText(content);
    }

    @Override
    public void onAttached(ViewGroup rootView) {

    }

    EditorCallback editorCallback1 = new EditorCallback() {
        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSubmit(String content) {
            tvShow.setText(content);
        }

        @Override
        public void onAttached(ViewGroup rootView) {

        }
    };

    EditorCallback editorCallback2 = new EditorCallback() {
        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSubmit(String content) {
            tvShow.setText(content);
        }

        @Override
        public void onAttached(final ViewGroup rootView) {
            final View flFaces = rootView.findViewById(R.id.fl_faces);
            rootView.findViewById(R.id.iv_face).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(flFaces.getVisibility() == View.VISIBLE){
                        flFaces.setVisibility(View.GONE);
                    }else {
                        flFaces.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    };

    EditorCallback editorCallback3 = new EditorCallback() {
        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSubmit(String content) {
            tvShow.setText(content);
        }

        @Override
        public void onAttached(final ViewGroup rootView) {
            TextView title = (TextView) rootView.findViewById(DefaultEditorHolder.DEFAULT_TITLE);
            title.setText(R.string.send);
            EditText editText = (EditText) rootView.findViewById(DefaultEditorHolder.DEFAULT_ID_WRITE);
            editText.setHint(R.string.input_hint);
        }
    };

    InputCheckRule inputCheckRule = new InputCheckRule(20, 1);

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.bt_reply1:
                FloatEditorActivity.openEditor(MainActivity.this, editorCallback1,
                        new EditorHolder(R.layout.fast_reply_floating_layout,
                                R.id.tv_cancel, R.id.tv_submit, R.id.et_content));
                break;
            case R.id.bt_reply2:
                FloatEditorActivity.openEditor(MainActivity.this, editorCallback2,
                        new EditorHolder(R.layout.fast_reply_floating_layout_2,
                                0, R.id.tv_submit, R.id.et_content));
                break;
            case R.id.bt_reply3:
                FloatEditorActivity.openDefaultEditor(MainActivity.this, editorCallback3, inputCheckRule);
                break;
            default:
        }
    }
}
