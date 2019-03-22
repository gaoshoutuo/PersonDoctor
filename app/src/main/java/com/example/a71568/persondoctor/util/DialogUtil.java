package com.example.a71568.persondoctor.util;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.a71568.persondoctor.R;

public class DialogUtil {

    public static DialogUtil dialogUtil;

    public static DialogUtil getInstance(){
        if (dialogUtil==null)dialogUtil=new DialogUtil();

        return dialogUtil;
    }


    public void cMDialog(final Activity context, String cmName){//药品数量添加减少的方法
        View view= LayoutInflater.from(context).inflate(R.layout.cm_count_add_sale,null,false);

        final RadioButton cmAdd=view.findViewById(R.id.cm_medicine_add);
        final RadioButton cmSale=view.findViewById(R.id.cm_medicine_sale);
        final EditText cmCount=view.findViewById(R.id.cm_medicine_count);

        MaterialDialog.Builder builder= new MaterialDialog.Builder(context);
        builder.title(R.string.cm_dialog_title)
                .iconRes(R.drawable.more_64)
                .positiveText("修改完毕")
                .negativeText("我再想想")
                .onPositive(new MaterialDialog.SingleButtonCallback() {

                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if (cmCount.getText()==null)return;
                        if (cmAdd.isChecked()){
                            Toast.makeText(context,"add",Toast.LENGTH_SHORT).show();
                        }else if (cmSale.isChecked()){
                            Toast.makeText(context,"sale",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).onNegative(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

            }
        }).customView(view,true).show();
    }

}
