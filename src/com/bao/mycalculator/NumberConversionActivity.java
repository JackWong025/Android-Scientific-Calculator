package com.bao.mycalculator;

import com.bao.model.Model.Current;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * ��activityΪ����ת��
 */
public class NumberConversionActivity extends Activity {
	//������ʾ���ַ���
	private String editTextString="";
	private EditText editText=null;
	private TextView tv=null;
	//��ǰ�Ľ��ƣ�������com.bao.model.Model.Current����õ�ö����
	private Current currentSystem=Current.TEN;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_numberconversion);
		//ʵ����������ť�Լ�edittext,textview
		Button btnA=(Button)findViewById(R.id.btn_A);
		Button btnB=(Button)findViewById(R.id.btn_B);
		Button btnC=(Button)findViewById(R.id.btn_C);
		Button btnD=(Button)findViewById(R.id.btn_D);
		Button btnE=(Button)findViewById(R.id.btn_E);
		Button btnF=(Button)findViewById(R.id.btn_F);
		Button btn0=(Button)findViewById(R.id.btn_0);
		Button btn1=(Button)findViewById(R.id.btn_1);
		Button btn2=(Button)findViewById(R.id.btn_2);
		Button btn3=(Button)findViewById(R.id.btn_3);
		Button btn4=(Button)findViewById(R.id.btn_4);
		Button btn5=(Button)findViewById(R.id.btn_5);
		Button btn6=(Button)findViewById(R.id.btn_6);
		Button btn7=(Button)findViewById(R.id.btn_7);
		Button btn8=(Button)findViewById(R.id.btn_8);
		Button btn9=(Button)findViewById(R.id.btn_9);
		Button btnclean=(Button)findViewById(R.id.btn_c);
		Button btntwo=(Button)findViewById(R.id.btn_two);
		Button btneight=(Button)findViewById(R.id.btn_eight);
		Button btnten=(Button)findViewById(R.id.btn_ten);
		Button btnsixteen=(Button)findViewById(R.id.btn_sixteen);
		editText=(EditText)findViewById(R.id.et);
		tv=(TextView)findViewById(R.id.tv);
		
		//Ϊ������ť���ü�����
		//���ü�����
		btnA.setOnClickListener(numberListener);
		btnB.setOnClickListener(numberListener);
		btnC.setOnClickListener(numberListener);
		btnD.setOnClickListener(numberListener);
		btnE.setOnClickListener(numberListener);
		btnF.setOnClickListener(numberListener);
		btn0.setOnClickListener(numberListener);
		btn1.setOnClickListener(numberListener);
		btn2.setOnClickListener(numberListener);
		btn3.setOnClickListener(numberListener);
		btn4.setOnClickListener(numberListener);
		btn5.setOnClickListener(numberListener);
		btn6.setOnClickListener(numberListener);
		btn7.setOnClickListener(numberListener);
		btn8.setOnClickListener(numberListener);
		btn9.setOnClickListener(numberListener);
		btnclean.setOnClickListener(numberListener);
		btneight.setOnClickListener(numberListener);
		btnten.setOnClickListener(numberListener);
		btntwo.setOnClickListener(numberListener);
		btnsixteen.setOnClickListener(numberListener);	
	}
	/**
	 * �������а�ť�ļ�����
	 */
	OnClickListener numberListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_0:
				//��λ��Ϊ0
				if(editTextString!="") input("0");
				break;
			case R.id.btn_1:
				input("1");
				break;
			case R.id.btn_2:
				if(currentSystem!=Current.TWO) input("2");
				break;
			case R.id.btn_3:
				if(currentSystem!=Current.TWO) input("3");
				break;
			case R.id.btn_4:
				if(currentSystem!=Current.TWO) input("4");
				break;
			case R.id.btn_5:
				if(currentSystem!=Current.TWO) input("5");
				break;
			case R.id.btn_6:
				if(currentSystem!=Current.TWO) input("6");
				break;
			case R.id.btn_7:
				if(currentSystem!=Current.TWO) input("7");
				break;
			case R.id.btn_8:
				if(currentSystem!=Current.TWO&&currentSystem!=Current.EIGHT) input("8");
				break;
			case R.id.btn_9:
				if(currentSystem!=Current.TWO&&currentSystem!=Current.EIGHT) input("9");
				break;
			case R.id.btn_A:
				if(currentSystem==Current.SIXTEEN) input("A");
				break;
			case R.id.btn_B:
				if(currentSystem==Current.SIXTEEN) input("B");
				break;
			case R.id.btn_C:
				if(currentSystem==Current.SIXTEEN) input("C");
				break;
			case R.id.btn_D:
				if(currentSystem==Current.SIXTEEN) input("D");
				break;
			case R.id.btn_E:
				if(currentSystem==Current.SIXTEEN) input("E");
				break;
			case R.id.btn_F:
				if(currentSystem==Current.SIXTEEN) input("F");
				break;
			//�������հ�ť
			case R.id.btn_c:
				editTextString="";
				editText.setText(editTextString);
				break;
			//����ǽ���ת���İ�ť
			case R.id.btn_two:
				conversion(Current.TWO);
				break;
			case R.id.btn_eight:
				conversion(Current.EIGHT);
				break;
			case R.id.btn_ten:
				conversion(Current.TEN);
				break;
			case R.id.btn_sixteen:
				conversion(Current.SIXTEEN);
				break;
			default:
				break;
			}
			if(
			((currentSystem==Current.SIXTEEN)&&editTextString.length()>6)||
			((currentSystem==Current.TEN)&&editTextString.length()>7)||
			((currentSystem==Current.EIGHT)&&editTextString.length()>8)||
			((currentSystem==Current.TWO)&&editTextString.length()>24)
			){
				Toast.makeText(NumberConversionActivity.this, "���ֱ�Ū̫����...", Toast.LENGTH_SHORT).show();
				editTextString="";
				editText.setText(editTextString);
			}
			//�����Ϣ�������
			Log.i("TAG", "editTextString---->"+editTextString);
			Log.i("TAG", "currentSystem---->"+currentSystem);
		}
	};
/**
 * �������֣�������ʾ
 * @param string ���������
 */
	protected void input(String string) {
		editTextString=editTextString+string;
		editText.setText(editTextString);
	}
/**
 * ת������  ���ת���ɹ�����1  ����ת������0
 * @param string Ŀ�����
 */
	protected int conversion(Current target) {
		Log.i("TAG", currentSystem+"ת����"+target);
		if(target==currentSystem) return 0;
		//�����ǰ�����Ϊ�գ�Ϊ��ʱ�������´��룬ֱ�Ӹ��µ�ǰ����
		if(editTextString!=""){
			//���ݵ�ǰ���ƺ�Ŀ����Ʒ���
			//�����ǰ��ʮ���ƣ�ֱ�ӵ���toBinaryString toOctalString toHexString�ȷ���
			if(currentSystem==Current.TEN){
				switch (target) {
				case TWO:
					editTextString= Integer.toBinaryString(Integer.parseInt(editTextString));
					editText.setText(editTextString);
					break;
				case EIGHT:
					editTextString=Integer.toOctalString(Integer.parseInt(editTextString));
					editText.setText(editTextString);
					break;
				case SIXTEEN:
					editTextString=Integer.toHexString(Integer.parseInt(editTextString));
					editText.setText(editTextString);
					break;
				default:
					break;
				}
			}
			//�����ǰ����ʮ���ƣ����ݵ�ǰ������parseIntת����ʮ���ƺ���ת����Ŀ�����
			else{
				switch (target) {
				case TWO:
					editTextString= Integer.toBinaryString(Integer.parseInt(editTextString,currentSystem.value));
					editText.setText(editTextString);
					break;
				case EIGHT:
					editTextString=Integer.toOctalString(Integer.parseInt(editTextString, currentSystem.value));
					editText.setText(editTextString);
					break;
				case TEN:
					editTextString=Integer.valueOf(editTextString,currentSystem.value).toString();
					editText.setText(editTextString);
					break;
				case SIXTEEN:
					editTextString=Integer.toHexString(Integer.parseInt(editTextString, currentSystem.value));
					editText.setText(editTextString);
					break;
				default:
					break;
				}
			}
		}
		//���µ�ǰ����
		currentSystem=target;
		switch (target) {
		case TWO:
			tv.setText("������");
			break;
		case EIGHT:
			tv.setText("�˽���");
			break;
		case TEN:
			tv.setText("ʮ����");
			break;
		case SIXTEEN:
			tv.setText("ʮ������");
			break;
		default:
			break;
		}
		return 1;
	} //ת����������
}

