package cn.kevin.floatingeditor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * 创建日期：2017/9/13.
 *
 * @author kevin
 */

public class FloatEditorActivity extends Activity implements View.OnClickListener {
    public static final String KEY_EDITOR_HOLDER = "editor_holder";
    private View cancel;
    private View submit;
    private EditText etContent;
    private static IEditor mEditorListener;
    private EditorHolder holder;
    private boolean isCancelClicked;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        holder = (EditorHolder) getIntent().getSerializableExtra(KEY_EDITOR_HOLDER);
        if(holder == null){
            throw new RuntimeException("EditorHolder params not found!");
        }
        setContentView(holder.layoutResId);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.BOTTOM);

        initView();
        setEvent();
    }

    private void initView() {
        cancel = findViewById(holder.cancelViewId);
        submit = findViewById(holder.submitViewId);
        etContent = (EditText) findViewById(holder.editTextId);
    }

    private void setEvent() {
        if(cancel != null)
            cancel.setOnClickListener(this);

        submit.setOnClickListener(this);
    }


    public static void openEditor(Context context, IEditor editorListener, EditorHolder holder){
        Intent intent = new Intent(context, FloatEditorActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(KEY_EDITOR_HOLDER, holder);
        mEditorListener = editorListener;
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == holder.cancelViewId){
            mEditorListener.onCancel();
            isCancelClicked = true;
        }else if(id == holder.submitViewId){
            mEditorListener.onSubmit(etContent.getText().toString());
        }
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!isCancelClicked){
            mEditorListener.onCancel();
        }
        mEditorListener = null;
    }
}
