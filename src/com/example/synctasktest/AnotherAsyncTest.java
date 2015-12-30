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
		progressDialog.show(); // 显示进度对话框
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
//				int downloadPercent = doDownload(); // 这是一个虚构的方法
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
		// 在这里更新下载进度
		progressDialog.setMessage("Downloaded " + values[0] + "%");
	}

	@Override
	protected void onPostExecute(Boolean result) {
		progressDialog.setMessage("Downloaded Complete");
		progressDialog.dismiss(); // 关闭进度对话框		
		// 在这里提示下载结果
//		if (result) {
//			Toast.makeText(context, "Download succeeded", Toast.LENGTH_SHORT)
//					.show();
//		} else {
//			Toast.makeText(context, " Download failed", Toast.LENGTH_SHORT)
//					.show();
//		}
	}
}