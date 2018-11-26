package hkit.kr.dialogex01;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int REQUSET_CODE_MODIFY = 100;
    final int REQUSET_CODE_ADD = 101;
    //final이 붙으면 변수는 대문자로 만든다.

    TextView idTextView;
    TextView pwTesxtView;
    TextView emTesxtView;//전역 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("메인페이지");

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(OnClickListener);

        idTextView = findViewById(R.id.idTextView);//레이아웃과 연결한다.
        pwTesxtView = findViewById(R.id.pwTesxtView);
        emTesxtView = findViewById(R.id.emTesxtView);
    }

//onCreate 밑에 오버라이드(재정의) 메소드를 클릭 후 onActivityResult 즉 값을 새로 넘겨 받을 때
    // Modify에 있는 intent를  data에 자동 설정 되어 있다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==REQUSET_CODE_MODIFY) {
            String id = data.getStringExtra("id");
            String pw = data.getStringExtra("pw");
            String email = data.getStringExtra("email");

            idTextView.setText(id);
            pwTesxtView.setText(pw);
            emTesxtView.setText(email);
        }else if(requestCode==REQUSET_CODE_ADD){

        }
        //requestCode 조건문 실행시 사용
        //resultCode
    }

    View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String id = idTextView.getText().toString();//액티비티에 입력된 문자를 가져온다.
            String pw = pwTesxtView.getText().toString();
            String email = emTesxtView.getText().toString();



            Intent intent = new Intent(getBaseContext(), ModifyActivity.class);
            intent.putExtra("id",id); //Modify에 값을 넘겨준다.
            intent.putExtra("pw", pw);
            intent.putExtra("email",email);
       //     startActivity(intent);

            startActivityForResult(intent,10);
        //startActivityForResult 오버라이드가 된 값을 가지고 온다. 화면을 뛰었다가 onActivityResult 값을 가지고 온다.
            // 뒤 10은


        }
    };
}
