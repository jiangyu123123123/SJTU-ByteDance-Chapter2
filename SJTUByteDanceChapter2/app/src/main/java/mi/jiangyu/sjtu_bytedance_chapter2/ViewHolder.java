package mi.jiangyu.sjtu_bytedance_chapter2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//持有view的一个容器
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @Override
    public void onClick(View view) {

    }
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public void bind(String text){
        TextView textView=itemView.findViewById(R.id.text);
        textView.setText(text);
    }
}
