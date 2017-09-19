package cn.kevin.floatingeditor;

/**
 * Created by like on 2017/9/18.
 */

public class DefaultEditorHolder {

    public static final int DEFAULT_LAYOUT = R.layout.view_component_write;
    public static final int DEFAULT_TITLE = R.id.tv_title;
    public static final int DEFAULT_ID_CANCEL = R.id.tv_cancel;
    public static final int DEFAULT_ID_SEND = R.id.tv_send;
    public static final int DEFAULT_ID_WRITE = R.id.et_write;

    public static EditorHolder createDefaultHolder() {
        return new EditorHolder(DEFAULT_LAYOUT, DEFAULT_ID_CANCEL, DEFAULT_ID_SEND, DEFAULT_ID_WRITE);
    }


}
