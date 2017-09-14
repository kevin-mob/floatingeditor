package cn.kevin.floatingeditor;

/**
 * 创建日期：2017/9/13.
 *
 * @author kevin
 */

public interface IEditor {
    void onCancel();
    void onSubmit(String content);
}
