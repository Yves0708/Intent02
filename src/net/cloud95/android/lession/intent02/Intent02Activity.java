package net.cloud95.android.lession.intent02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Intent02Activity extends Activity {

    private EditText planet_text01, planet_text02, planet_text03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent02);

        processViews();
    }

    // 使用startActivityForResult啟動Activity元件，在它結束以後會呼叫這個方法
    // 第一個參數是呼叫startActivityForResult方法時的第二個參數，請求代碼
    // 第二個參數是執行結果
    // 第三個參數是包含回傳資料的Intent物件
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 使用resultCode參數判斷執行結果，RESULT_OK表示使用者執行選擇項目
        if(resultCode == Activity.RESULT_OK){
        	// 使用參數Intent物件讀取資料
        	String planet = data.getStringExtra("planet");
        	// 參數requestCode就是按鈕的資源編號
        	switch(requestCode){
        	case R.id.button01:
        		planet_text01.setText(planet);
        		break;
        	case R.id.button02:
        		planet_text02.setText(planet);
        		break;
        	case R.id.button03:
        		planet_text03.setText(planet);
        		break;
        	}
         // 使用resultCode參數判斷執行結果，RESULT_CANCELED表示使用者按下返回鍵
        }else if(resultCode == Activity.RESULT_CANCELED){
        	Toast.makeText(this, "RESULT_CANCELED", Toast.LENGTH_LONG).show();
        }
            
            
       
        
    }

    public void clickButton(View view) {
        // 建立啟動PlanetActivity元件的Intent物件
    	Intent intent = new Intent(Intent02Activity.this,PlanetActivity.class);
        // 取得使用者選擇的按鈕元件編號
    	int id = view.getId();
        // 啟動PlanetActivity元件，使用按鈕元件編號為請求代碼
    	startActivityForResult(intent,id);
    }

    private void processViews() {
        planet_text01 = (EditText) findViewById(R.id.planet_text01);
        planet_text02 = (EditText) findViewById(R.id.planet_text02);
        planet_text03 = (EditText) findViewById(R.id.planet_text03);
    }

}
