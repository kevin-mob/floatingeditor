package cn.kevin.floatingeditor;

import android.view.ViewGroup;

/**
 * 创建日期：2017/9/13.
 *
 * @author kevin
 */

public interface EditorCallback {
    void onCancel();
    void onSubmit(String content);
    void onAttached(ViewGroup rootView);
}
