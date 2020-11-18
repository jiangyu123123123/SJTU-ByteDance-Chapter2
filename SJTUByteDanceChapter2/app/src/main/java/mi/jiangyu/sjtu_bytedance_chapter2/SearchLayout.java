package mi.jiangyu.sjtu_bytedance_chapter2;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SearchLayout extends LinearLayout {
    private static final String TAG="SearchLayout";
    private EditText mEditView;
    private TextView mCancel;
    //编辑框内容变化时，用于对外输出，为此要设置一个监听器
    private OnInputChangedListener onInputChangedListener;

    public SearchLayout(Context context) {
        super(context);
        initView();
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
    private void initView(){
        //这个绑定的方法为什么要这么写
        inflate(getContext(),R.layout.layout_search,this);
        EditText input=findViewById(R.id.input);
        mCancel=findViewById(R.id.cancel);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG, "beforeTextChanged: "+charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG, "onTextChanged: "+charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //文本变化完成的回调
                Log.d(TAG, "afterTextChanged: "+editable);
                if (onInputChangedListener!=null){
                    onInputChangedListener.onChanged(editable.toString());
                }
            }
        });
        mCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //取消按扭取消了什么
                ((Activity)getContext()).finish();
            }
        });
    }
    public void setOnInputChangedListener(OnInputChangedListener listener){
        this.onInputChangedListener=listener;

    }
    //这段接口写的看不懂
    public interface OnInputChangedListener {
        void onChanged(String text);
    }
}
