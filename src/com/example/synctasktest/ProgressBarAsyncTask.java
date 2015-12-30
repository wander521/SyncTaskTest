package com.example.synctasktest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

//Params ��������ִ�е��������������HTTP�����URL��
//Progress ��̨����ִ�еİٷֱȡ�
//Result ��ִ̨���������շ��صĽ��������String��
/**
 * ���ɸ���Ķ��󣬲�����execute����֮�� ����ִ�е���onProExecute���� ���ִ��doInBackgroup����
 * 
 */
public class ProgressBarAsyncTask extends AsyncTask<Integer, Integer, String> {

	private TextView textView;
	private ProgressBar progressBar;
	private ProgressDialog progressDialog;
//	private ProgressDialog pdialog;

	public ProgressBarAsyncTask(TextView textView, ProgressDialog progressDialog) {
		super();
//		pdialog = new ProgressDialog(Context);
		this.textView = textView;
		this.progressBar = progressBar;
		this.progressDialog = progressDialog;
		
//		pdialog.show();
	}

	/**
	 * �����Integer������ӦAsyncTask�еĵ�һ������ �����String����ֵ��ӦAsyncTask�ĵ���������
	 * �÷�������������UI�̵߳��У���Ҫ�����첽�����������ڸ÷����в��ܶ�UI���еĿռ�������ú��޸�
	 * ���ǿ��Ե���publishProgress��������onProgressUpdate��UI���в���
	 */
	@Override
	protected String doInBackground(Integer... params) {
		NetOperator netOperator = new NetOperator();
		int i = 0;
		for (i = 10; i <= 100; i += 10) {
			netOperator.operator();
			publishProgress(i);
		}
//		return i + params[0].intValue() + "";
		return String.valueOf(i) ;
	}

	/**
	 * �����String������ӦAsyncTask�еĵ�����������Ҳ���ǽ���doInBackground�ķ���ֵ��
	 * ��doInBackground����ִ�н���֮�������У�����������UI�̵߳��� ���Զ�UI�ռ��������
	 */
	@Override
	protected void onPostExecute(String result) {
		textView.setText("�첽����ִ�н���" + result);
//		progressBar.setVisibility(View.GONE);
		progressDialog.dismiss();
	}

	// �÷���������UI�̵߳���,����������UI�̵߳��� ���Զ�UI�ռ��������
	@Override
	protected void onPreExecute() {
		textView.setText("��ʼִ���첽�߳�");
//		progressBar.setVisibility(View.VISIBLE);
		progressDialog.show();
	}

	/**
	 * �����Intege������ӦAsyncTask�еĵڶ�������
	 * ��doInBackground�������У���ÿ�ε���publishProgress�������ᴥ��onProgressUpdateִ��
	 * onProgressUpdate����UI�߳���ִ�У����п��Զ�UI�ռ���в���
	 */
	@Override
	protected void onProgressUpdate(Integer... values) {
		int vlaue = values[0];
//		progressBar.setProgress(vlaue);
	}

}