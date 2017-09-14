package cn.kevin.floatingeditor;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;

import java.io.Serializable;

/**
 * 创建日期：2017/9/14.
 *
 * @author kevin
 */

public class EditorHolder implements Serializable{
    int layoutResId;
    int cancelViewId;
    int submitViewId;
    int editTextId;
    public EditorHolder(@LayoutRes int layoutResId, @IdRes int cancelViewId,
                        @IdRes int submitViewId, @IdRes int editTextId){
        this.layoutResId = layoutResId;
        this.cancelViewId = cancelViewId;
        this.submitViewId = submitViewId;
        this.editTextId = editTextId;
    }
}
