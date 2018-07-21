package com.sjw.mygreendao;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sjw.mygreendao.daobean.User;
import com.sjw.mygreendao.greendaoopr.DaoManager;
import com.sjw.mygreendao.utils.SnackbarUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text_userid;
    private EditText edit_text_username;
    private EditText edit_text_userage;
    private EditText edit_text_userscore;

    private TextInputLayout textInputUserid;
    private TextInputLayout textInputUsername;
    private TextInputLayout textInputUserage;
    private TextInputLayout textInputUserscore;

    String userId;
    String userName;
    String userAge;
    String userScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text_userid = (EditText) findViewById(R.id.edit_text_userid);
        edit_text_username = (EditText) findViewById(R.id.edit_text_username);
        edit_text_userage = (EditText) findViewById(R.id.edit_text_userage);
        edit_text_userscore = (EditText) findViewById(R.id.edit_text_userscore);

        textInputUserid = (TextInputLayout) findViewById(R.id.textInputUserid);
        textInputUsername = (TextInputLayout) findViewById(R.id.textInputUsername);
        textInputUserage = (TextInputLayout) findViewById(R.id.textInputUserage);
        textInputUserscore = (TextInputLayout) findViewById(R.id.textInputUserscore);

    }

    public void insert(View view) {
        userId = edit_text_userid.getText().toString();
        userName = edit_text_username.getText().toString();
        userAge = edit_text_userage.getText().toString();
        userScore = edit_text_userscore.getText().toString();

        textInputUsername.setErrorEnabled(false);
        if (!validateUsername(userName)) {
            SnackbarUtils.Long(view, "用户名不能为空").info().show();

        } else {
            DaoManager.getInstance().insertUser(new User(null, userName, Integer.parseInt(userAge), Double.parseDouble(userScore), "1"));

        }


    }

    public void query(View view) {

        List<User> list = DaoManager.getInstance().searchAllUser();
        String result = "";
        for (int i = 0; i < list.size(); i++) {
//            TextView tv = new TextView(this);
//            tv.setText("项" + (i + 1) + ":" + list.get(i).toString());
//            SnackbarUtils.Long(view, "向Snackbar布局中添加View").addView(tv, i).show();
            result += "项" + (i + 1) + ":" + list.get(i).toString();

        }

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

    }

    public void delete(View view) {
        userId = edit_text_userid.getText().toString();
        DaoManager.getInstance().deleteByKeyUser(Long.parseLong(userId));
    }

    public void update(View view) {
        userId = edit_text_userid.getText().toString();
        userName = edit_text_username.getText().toString();
        userAge = edit_text_userage.getText().toString();
        userScore = edit_text_userscore.getText().toString();
        textInputUsername.setErrorEnabled(false);
        if (!validateUsername(userName)) {
            SnackbarUtils.Long(view, "用户名不能为空").info().show();
        } else {
            DaoManager.getInstance().updateUser(new User(Long.parseLong(userId), userName, Integer.parseInt(userAge), Double.parseDouble(userScore), "1"));

        }


    }

    /**
     * 验证用户名
     *
     * @param value
     * @return
     */
    private boolean validateUsername(String value) {
        if (TextUtils.isEmpty(value)) {
            showError(textInputUsername, "用户名不能为空");
            return false;
        }
        return true;
    }

    /**
     * 显示错误提示，并获取焦点
     *
     * @param textInputLayout
     * @param error
     */
    private void showError(TextInputLayout textInputLayout, String error) {
        textInputLayout.setError(error);
        textInputLayout.getEditText().setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();
    }


}
