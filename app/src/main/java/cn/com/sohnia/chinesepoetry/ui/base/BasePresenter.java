package cn.com.sohnia.chinesepoetry.ui.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class BasePresenter <V> {
    protected Reference<V> viewReference;

    public void attachView(V view){
        viewReference = new WeakReference<V>(view);
    }

    public void detachView(){
        if(viewReference != null){
            viewReference.clear();
            viewReference = null;
        }
    }

    protected V getView(){
        return viewReference.get();
    }

    public boolean isViewAttached(){
        return viewReference != null&&viewReference.get() != null;
    }
}
