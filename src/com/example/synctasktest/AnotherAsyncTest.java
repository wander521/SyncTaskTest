package com.example.synctasktest;

import android.R.integer;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class AnotherAsyncTest extends AsyncTask<Void, Integer, Boolean> {
	Context context;
	private ProgressDialog progressDialog;
	public AnotherAsyncTest(ProgressDialog progressDialog){
		super();
		this.progressDialog = progressDialog;
	}
	@Override
	protected void onPreExecute() {
		progressDialog.show(); // ��ʾ���ȶԻ���
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		try {
			NetOperator netOperator = new NetOperator();
//			int i = 0;
			for (int i = 0; i <= 100; i += 10) {
				netOperator.operator();
				publishProgress(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

//		try {
//			while (true) {
//				int downloadPercent = doDownload(); // ����һ���鹹�ķ���
//				publishProgress(downloadPercent);
//				if (downloadPercent >= 100) {
//					break;
//				}
//			}
//		} catch (Exception e) {
//			return false;
//		}
		return true;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// ������������ؽ���
		progressDialog.setMessage("Downloaded " + values[0] + "%");
	}

	@Override
	protected void onPostExecute(Boolean result) {
		progressDialog.setMessage("Downloaded Complete");
		progressDialog.dismiss(); // �رս��ȶԻ���		
		// ��������ʾ���ؽ��
//		if (result) {
//			Toast.makeText(context, "Download succeeded", Toast.LENGTH_SHORT)
//					.show();
//		} else {
//			Toast.makeText(context, " Download failed", Toast.LENGTH_SHORT)
//					.show();
//		}
	}
}