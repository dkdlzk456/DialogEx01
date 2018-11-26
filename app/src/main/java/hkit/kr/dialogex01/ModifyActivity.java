package hkit.kr.dialogex01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ModifyActivity extends AppCompatActivity {

    EditText ideditText;
    EditText pweditText;
    EditText emeditText;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        //레이아웃과 연결하기
        ideditText = findViewById(R.id.edTextid);
        pweditText = findViewById(R.id.edTextpw);
        emeditText = findViewById(R.id.edTextem);

        setTitle("수정페이지");
        button1 = findViewById(R.id.modifButton);
        button2 = findViewById(R.id.closeButton);

        Intent intent = getIntent(); //main에서 넘겨준 값을 받는다.
        String id = intent.getStringExtra("id");

        String pw = intent.getStringExtra("pw");
        String email = intent.getStringExtra("email");


        //버튼 이벤트 연결
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(closeClickListener);


        //화면에 뿌려주기
        ideditText.setText(id);
        pweditText.setText(pw);
        emeditText.setText(email);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String id = ideditText.getText().toString();//입력된 값을 가져온다.
            String pw = pweditText.getText().toString();
            String email = emeditText.getText().toString();

            Intent data = new Intent();
            data.putExtra("id", id);
            data.putExtra("pw", pw);
            data.putExtra("email", email);
            setResult(Activity.RESULT_OK, data); //수정한 값을 다시 보내주기
            finish();

        }
    };
    View.OnClickListener closeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
