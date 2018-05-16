package com.huatec.greendao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.huatec.greendao.gen.CategoryDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ListView listview;
    private CategoryDao categoryDao;
    private int tag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.lv);

        categoryDao = GreenDaoManager.getInstance().getDaoSession().getCategoryDao();

        queryAll();
    }

    /**
     * 增加操作
     * @param view
     */
    public void add(View view){
        categoryDao.insert(new Category("牛奶" + tag,100));
        categoryDao.insert(new Category("红酒" + tag,200));
        categoryDao.insert(new Category("啤酒" + tag,500));
        categoryDao.insert(new Category("饮料" +tag,400));
        categoryDao.insert(new Category("矿泉水" + tag,300));
        categoryDao.insert(new Category("纯净水" + tag,1000));

        Toast.makeText(this, "增加了6条新数据", Toast.LENGTH_SHORT).show();

        queryAll();
    }

    /**
     * 删除操作
     * @param view
     */

    public void delete(View view){
        final EditText editText = new EditText(MainActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(MainActivity.this);
        inputDialog.setTitle("根据id删除数据").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long id = Integer.valueOf(editText.getText().toString());
                        categoryDao.deleteByKey(id);
                        queryAll();
                        Toast.makeText(MainActivity.this,
                                "删除成功",
                                Toast.LENGTH_SHORT).show();
                    }
                }).show();


    }

    /**
     * 更新
     * @param view
     */
    public void update(View view){
        final EditText editText = new EditText(MainActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(MainActivity.this);
        inputDialog.setTitle("根据id修改数据").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long id = Integer.valueOf(editText.getText().toString());

                        Category entity = categoryDao.load(id);
                        entity.setName("New" + entity.getName());
                        categoryDao.update(entity);
                        queryAll();
                        Toast.makeText(MainActivity.this,
                                "更新成功",
                                Toast.LENGTH_SHORT).show();
                    }
                }).show();

    }

    /**
     * 查询全部
     * @param view
     */
    public void query(View view){
       queryAll();
    }

    /**
     * 查询全部
     */
    private void queryAll(){
        List<Category> list = categoryDao.loadAll();
        if(list.size() == 0){
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
        }
        List<String> data = new ArrayList<>();
        for(Category cat: list){
            data.add("id:" + cat.getCat_id()+ "     name:" + cat.getName() + "      count:" + cat.getGoods_count());
        }
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,data);
        listview.setAdapter(adapter);
    }

}
