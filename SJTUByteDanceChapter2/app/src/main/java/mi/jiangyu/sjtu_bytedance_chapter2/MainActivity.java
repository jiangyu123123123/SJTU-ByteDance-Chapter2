package mi.jiangyu.sjtu_bytedance_chapter2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,SearchActivity.class);
//                startActivity(intent);
//            }
//        });

        RecyclerView recyclerView=findViewById(R.id.list);
        final ViewAdapter viewAdapter=new ViewAdapter();
        recyclerView.setAdapter(viewAdapter);//绑定
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//必须包含
        final List<String> list=new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add(i+"");
        }
        viewAdapter.notifyItems(list);
        SearchLayout searchLayout=findViewById(R.id.search);
        searchLayout.setOnInputChangedListener(new SearchLayout.OnInputChangedListener() {
            @Override
            public void onChanged(String text) {
                Log.d("TAG","onChanged"+text);
                List<String> filters=new ArrayList<>();
                for (String str:list){
                    if (str.contains(text)){
                        filters.add(str);
                    }
                }
                viewAdapter.notifyItems(filters);
            }
        });

    }
}