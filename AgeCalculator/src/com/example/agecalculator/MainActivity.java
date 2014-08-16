package com.example.agecalculator;



import android.os.Bundle;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;



import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity implements OnClickListener{


	private TextView txt1,txt2,txt3,txt4,txt5,txt6;
	private Button btn1;
    static final int DATE_START_DIALOG_ID = 0;
	private int start_year=1991;
	private int start_month=11;
	private int start_day=4;
	private Agecalculation age=null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		age=new Agecalculation();
		setContentView(R.layout.activity_main);
		
		txt1=(TextView)findViewById(R.id.txt1);
		txt1.setText(age.getCurrentDate());
		txt2=(TextView)findViewById(R.id.txt2);
		//txt2.setText(age.setDOB(sYear, sMonth, sDay));
		txt3=(TextView)findViewById(R.id.txt3);
		
		txt4=(TextView)findViewById(R.id.txt4);
		txt5=(TextView)findViewById(R.id.txt5);
		txt6=(TextView)findViewById(R.id.txt6);
		btn1=(Button)findViewById(R.id.btn1);
		btn1.setOnClickListener(this);
		

	}

	@Override
	
	protected Dialog onCreateDialog(int id) {
		switch(id){
		case DATE_START_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, start_year,start_month,start_day);
		}
		
		
		return null;
		
		
	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListener
	 = new DatePickerDialog.OnDateSetListener() {
		
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			start_year=year;
			start_month=monthOfYear;
			start_day=dayOfMonth;
			age.setDOB(start_year, start_month, start_day);
			txt2.setText("Birth Date: "+start_day+"/"+(start_month+1)+"/"+start_year);
			calculateAge();
			
		}
	};
	
	/*public void Show(View v){
		
		
	}*/
	
	

	
	  //@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		
	switch (v.getId()) {
		case R.id.btn1:
		showDialog(DATE_START_DIALOG_ID);
		break;

		default:
		break;
		}
		
	}
	private void calculateAge(){
		age.CalculateYear();
		age.CalculateMonth();
		age.CaluculateDay();
		//Toast.makeText(getBaseContext(), "click the resulted button"+age.getResut(), Toast.LENGTH_LONG).show();
		txt3.setText(age.getResut());
		age.calculateTotalDay();
		txt4.setText(age.getDayResult());
		age.Calrem_month();
		age.Calrem_day();
		txt5.setText(age.getNextBirthday());
		age.horoscop();
		txt6.setText(age.gethoroscopresult());
	}
	
	
}


