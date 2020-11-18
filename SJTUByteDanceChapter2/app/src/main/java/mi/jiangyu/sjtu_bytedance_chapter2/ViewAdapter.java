package mi.jiangyu.sjtu_bytedance_chapter2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<String> mItems=new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //用于更新容器
        holder.bind(mItems.get(position));
    }
    //给adapter建立数据源
    public void notifyItems(List<String> list){
        mItems=list;
        notifyDataSetChanged();
    }
}
