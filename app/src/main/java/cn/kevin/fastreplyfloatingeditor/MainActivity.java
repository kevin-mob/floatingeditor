package cn.kevin.fastreplyfloatingeditor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.kevin.floatingeditor.EditorHolder;
import cn.kevin.floatingeditor.FloatEditorActivity;
import cn.kevin.floatingeditor.IEditor;

public class MainActivity extends AppCompatActivity implements IEditor, View.OnClickListener {
    TextView tvShow;
    Button btReply1;
    Button btReply2;
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
    }

    private void setEvent() {
        btReply1.setOnClickListener(this);
        btReply2.setOnClickListener(this);
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
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.bt_reply1:
                FloatEditorActivity.openEditor(MainActivity.this, MainActivity.this,
                        new EditorHolder(R.layout.fast_reply_floating_layout,
                                R.id.tv_cancel, R.id.tv_submit, R.id.et_content));
                break;
            case R.id.bt_reply2:
                FloatEditorActivity.openEditor(MainActivity.this, MainActivity.this,
                        new EditorHolder(R.layout.fast_reply_floating_layout_2,
                                0, R.id.tv_submit, R.id.et_content));
                break;
            default:
        }
    }
}
