package com.bao.mycalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;
import bsh.EvalError;
import bsh.Interpreter;
/**
 * ��activityΪ��ѧ���㣬����˻����ļ��㹦�ܣ��Լ�һ��ViewFlipper���û�ѡ����Ӹ߼��Ĺ���
 */
public class CalculatorActivity extends Activity {
	//�ò���ֵ�ж�ǰһ�����Ƿ�������ʵ������С���㣩��������ʵ����Ϊ������㣬���Ϊʵ����
	private boolean isDouble=false;
	//�ò���ֵ�ж���������Ƿ��мӼ��˳����ţ����ڸ߼����ܵļ��㣬�����������30���ٰ�sin���õ����Ϊ0.5�������30+����ᱨ��
	private boolean haveSymbol=false;
	//����������ַ�����Ҫ���������ֶ���Double����
	private String editTextAllDoubleString="";
	private Double result=0.0;
	private EditText editText=null;
	private ViewFlipper flipper = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		//ʵ����������ť�Լ�edittext
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
		Button btndel=(Button)findViewById(R.id.btn_del);
		Button btnplus=(Button)findViewById(R.id.btn_plus);
		Button btntimes=(Button)findViewById(R.id.btn_times);
		Button btndivide=(Button)findViewById(R.id.btn_divide);
		Button btnminus=(Button)findViewById(R.id.btn_minus);
		Button btnequals=(Button)findViewById(R.id.btn_equals);
		Button btndot=(Button)findViewById(R.id.btn_dot);
		Button btnsin=(Button)findViewById(R.id.btn_sin);
		Button btncos=(Button)findViewById(R.id.btn_cos);
		Button btntan=(Button)findViewById(R.id.btn_tan);
		Button btnarcsin=(Button)findViewById(R.id.btn_arcsin);
		Button btnarccos=(Button)findViewById(R.id.btn_arccos);
		Button btnarctan=(Button)findViewById(R.id.btn_arctan);
		Button btnsqr=(Button)findViewById(R.id.btn_sqr);
		Button btnPI=(Button)findViewById(R.id.btn_PI);
		Button btnsqrt=(Button)findViewById(R.id.btn_sqrt);
		Button btnE=(Button)findViewById(R.id.btn_E);
		Button btnlg=(Button)findViewById(R.id.btn_lg);
		Button btnln=(Button)findViewById(R.id.btn_ln);
		editText=(EditText)findViewById(R.id.et);

		
		//���ü�����
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
		btndot.setOnClickListener(numberListener);
		btnplus.setOnClickListener(numberListener);
		btnminus.setOnClickListener(numberListener);
		btntimes.setOnClickListener(numberListener);
		btndivide.setOnClickListener(numberListener);
		btnequals.setOnClickListener(numberListener);
		btnclean.setOnClickListener(numberListener);
		btndel.setOnClickListener(numberListener);
		btnPI.setOnClickListener(numberListener);
		btnE.setOnClickListener(numberListener);
		
		btnsin.setOnClickListener(advancedListener);
		btncos.setOnClickListener(advancedListener);
		btntan.setOnClickListener(advancedListener);
		btnarcsin.setOnClickListener(advancedListener);
		btnarccos.setOnClickListener(advancedListener);
		btnarctan.setOnClickListener(advancedListener);
		btnsqr.setOnClickListener(advancedListener);
		btnsqrt.setOnClickListener(advancedListener);
		btnlg.setOnClickListener(advancedListener);
		btnln.setOnClickListener(advancedListener);
		//���´���ʵ��viewflipper�ķ�ҳ����
		flipper = (ViewFlipper)findViewById(R.id.viewflipper_id);
	    Button button = (Button)findViewById(R.id.btn_viewfilpper);
	    //����Flipper��ҳ�Ķ�̬Ч�����������������뿪������Ч��,�ο�CSDN����
        flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.push_left_in));
        flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.push_left_out));
	    button.setOnClickListener(new View.OnClickListener() {         
	        public void onClick(View arg0) {
	            //ÿ�ε��button����ViewFlipper�е���ʾ����Ϊ��һ��Ԫ�أ������������Ԫ�أ���ͷ��ʼ
	            flipper.showNext();
	        }
	    });
	}
	/**
	 * ���������Լ��Ӽ��˳���ť�ļ�����
	 */
	OnClickListener numberListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			//��������ֻ��߷�����ֱ��������ַ�����
			case R.id.btn_0:
				input("0");
				break;
			case R.id.btn_1:
				input("1");
				break;
			case R.id.btn_2:
				input("2");
				break;
			case R.id.btn_3:
				input("3");
				break;
			case R.id.btn_4:
				input("4");
				break;
			case R.id.btn_5:
				input("5");
				break;
			case R.id.btn_6:
				input("6");
				break;
			case R.id.btn_7:
				input("7");
				break;
			case R.id.btn_8:
				input("8");
				break;
			case R.id.btn_9:
				input("9");
				break;
			case R.id.btn_plus:
				input("+");
				break;
			case R.id.btn_minus:
				input("-");
				break;
			case R.id.btn_times:
				input("*");
				break;
			case R.id.btn_divide:
				input("/");
				break;
			//�����Բ���ʦ�
			case R.id.btn_PI:
				if(!isDouble) input("3.1415");
				isDouble=true;
				break;
			//�������Ȼ����e
			case R.id.btn_E:
				if(!isDouble) input("2.7182");
				isDouble=true;
				break;
			//����ǵȺ���ִ�м���
			case R.id.btn_equals:
				if(editTextAllDoubleString!="") calculate();				
				break;
			//�����С���������С���㲢�ı�isDouble��ֵ
			case R.id.btn_dot:
				if(!isDouble){
					input(".");
					isDouble=true;
				}				
				break;
			//�������հ�ť
			case R.id.btn_c:
				cleanEditText();
				break;
			//�������˻��˰�ť
			case R.id.btn_del:
				delEditText();
				break;
			default:
				break;
			}
			//�����Ϣ�������
			Log.i("TAG", "haveSymbol---->"+haveSymbol);
			Log.i("TAG", "isDouble---->"+isDouble);
			Log.i("TAG", "editTextAllDoubleString---->"+editTextAllDoubleString);
		}
	};
	/**
	 * ���������ֻ������ŵĴ�����
	 * @param string ��������ֻ�������
	 */
	private void input(String string) {
		//��������˼Ӽ��˳���
		if(string=="+"||string=="-"||string=="*"||string=="/"){
			haveSymbol=true;
			//���ǰһ�����ֲ���ʵ��
			if(!isDouble){
				//��ǰһ������ת��Ϊʵ��,�˴����뽫isDouble��Ϊtrue����Ϊ��ʱ�Ѿ���������һ�����ˡ�Ĭ��Ϊfalse
				editTextAllDoubleString=editTextAllDoubleString+".0"+string;
				editText.setText(editTextAllDoubleString);
			}
			else{
				editTextAllDoubleString=editTextAllDoubleString+string;
				editText.setText(editTextAllDoubleString);
			}
			isDouble=false;
		}
		else{
			editTextAllDoubleString=editTextAllDoubleString+string;
			editText.setText(editTextAllDoubleString);
		}

	}
	/**
	 * �ú������ڻ���������ڵ��ַ���
	 * ����1��ʾ���˷��ż�
	 * ����2��ʾ����С����
	 * ����3��ʾΪ�գ��������
	 * ����4��ʾ��������
	 */
	protected int delEditText() {
		//������������
		if(editTextAllDoubleString.endsWith("+")||editTextAllDoubleString.endsWith("-")||editTextAllDoubleString.endsWith("*")||editTextAllDoubleString.endsWith("/"))
		{
			editTextAllDoubleString=editTextAllDoubleString.substring(0,editTextAllDoubleString.length()-1);
			if(editTextAllDoubleString.contains("+")||editTextAllDoubleString.contains("-")||editTextAllDoubleString.contains("*")||editTextAllDoubleString.contains("/")){
				haveSymbol=true;
			}else{
				haveSymbol=false;
			}
			//�������ʾ����
			editText.setText(editTextAllDoubleString);
			//ǰ��һ�����϶���ʵ��
			isDouble=true;
			return 1;

		}
		//�����С����
		else if(editTextAllDoubleString.endsWith(".")){
				editTextAllDoubleString=editTextAllDoubleString.substring(0,editTextAllDoubleString.length()-1);
				isDouble=false;
				//�������ʾ����
				editText.setText(editTextAllDoubleString);
				return 2;
			}
			else if(editTextAllDoubleString.length()==0){
				//do nothing
				Toast.makeText(CalculatorActivity.this, "��û���ˣ��㻹ɾʲô...", Toast.LENGTH_SHORT).show();
				return 3;
				}
				//�������ͨ����
				else{
					editTextAllDoubleString=editTextAllDoubleString.substring(0,editTextAllDoubleString.length()-1);
					//�������ʾ����
					editText.setText(editTextAllDoubleString);
					return 4;
				}
				
	}
	/**
	 * �ú���������������
	 */
	protected void cleanEditText() {
		editTextAllDoubleString="";
		haveSymbol=false;
		isDouble=false;
		editText.setText(editTextAllDoubleString);		
	}
	/**
	 * �����ַ�����ֵ
	 */
	protected void calculate() {
		//���ǰһ�����ֲ���ʵ��
		if(!isDouble){
			//��ǰһ������ת��Ϊʵ��,�˴����뽫isDouble��Ϊtrue����Ϊ��ʱ�Ѿ���������һ�����ˡ�Ĭ��Ϊfalse
			editTextAllDoubleString=editTextAllDoubleString+".0";
			editText.setText(editTextAllDoubleString);
		}
		//�˴����������һ���������http://www.beanshell.org/bsh-core-2.0b4.jar 
		//����javascript��eval�������÷����ɼ���ĳ���ַ���,ʹ�÷�������
		//����һ��������
		Interpreter interpreter = new Interpreter();
		try {
			//�����������ʽ
			result = (Double) interpreter.eval(editTextAllDoubleString);
			setResultNumber(result);
		} catch (EvalError e) {
			e.printStackTrace();
		}
	}
	/**
	 * ����������ʾ�������
	 * @param result Ҫ���õ��ַ���
	 */
	private void setResultNumber(Double result) {
		Log.i("TAG", "result---->"+result);
		//��Double���͵ļ�����ת��Ϊ�ַ�������,������λС��
		DecimalFormat df=new DecimalFormat("#.####");
		editTextAllDoubleString=df.format(result);
		//������������Ҫ��
		if(Double.isNaN(result)||result==Double.POSITIVE_INFINITY||result==Double.NEGATIVE_INFINITY){
			Toast.makeText(CalculatorActivity.this, "�����ʽ���󣡽���޷���ʾ��", Toast.LENGTH_SHORT).show();
			cleanEditText();
		}
		//������������ʾ
		else{
			editText.setText(editTextAllDoubleString);
			//��ʱ�ж�������е����Ƿ�С���㣬��isDouble��ֵ����
			haveSymbol=false;
			if(editTextAllDoubleString.contains(".")){
				isDouble=true;
			}else{
				isDouble=false;
			}
		}
		//��ӡ������,�������
		Log.i(getPackageName(), "editTextAllDoubleString--->"+editTextAllDoubleString);
		
	}

	/**
	 * ���ø߼����㹦�ܵİ�ť������
	 */
	OnClickListener advancedListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			//���������ں��м�����Ż�Ϊ������ʾ����,�����
			if(haveSymbol||editTextAllDoubleString==""){
				Toast.makeText(CalculatorActivity.this, "��������һ������", Toast.LENGTH_SHORT).show();
				cleanEditText();
			}
			else{
				if(!isDouble){
					editTextAllDoubleString=editTextAllDoubleString+".0";
				}
				switch (v.getId()) {
				case R.id.btn_sin:
					result=Math.sin(Double.parseDouble(editTextAllDoubleString)*Math.PI/180);
					setResultNumber(result);
					break;
				case R.id.btn_cos:
					result=Math.cos(Double.parseDouble(editTextAllDoubleString)*Math.PI/180);
					setResultNumber(result);
					break;
				case R.id.btn_tan:
					result=Math.tan(Double.parseDouble(editTextAllDoubleString)*Math.PI/180);
					setResultNumber(result);
					break;
				case R.id.btn_arcsin:
					result=Math.asin(Double.parseDouble(editTextAllDoubleString))*180/Math.PI;
					setResultNumber(result);
					break;
				case R.id.btn_arccos:
					result=Math.acos(Double.parseDouble(editTextAllDoubleString))*180/Math.PI;
					setResultNumber(result);
					break;
				case R.id.btn_arctan:
					result=Math.tan(Double.parseDouble(editTextAllDoubleString))*180/Math.PI;
					setResultNumber(result);
					break;
				case R.id.btn_sqr:
					result=Math.pow(Double.parseDouble(editTextAllDoubleString), 2.0);
					setResultNumber(result);
					break;
				case R.id.btn_sqrt:
					result=Math.sqrt(Double.parseDouble(editTextAllDoubleString));
					setResultNumber(result);
					break;
				case R.id.btn_ln:
					result=Math.log(Double.parseDouble(editTextAllDoubleString));
					setResultNumber(result);
					break;
				case R.id.btn_lg:
					result=Math.log10(Double.parseDouble(editTextAllDoubleString));
					setResultNumber(result);
					break;

				default:
					break;
				}

			}
		}
	};
}
