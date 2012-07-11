package com.tutor.frame;

import java.util.HashMap;
import java.util.Iterator;

import android.view.View;




public class QZRightWindowManager {

	 /**
     * ���Ѷ�̬����KEY
     */
    public static final int FRIEND_TRENDS_WINDOW = 0;
    
	 /**
     * ������������KEY
     */
    public static final int HOME_PAGE_WINDOW = 1;
    
	 /**
     * ���ѹ�ϵ������KEY
     */
    public static final int FRIEND_LIST_WINDOW = 2;
    
	 /**
     * Ӧ����������KEY
     */
    public static final int APP_CENTER_WINDOW = 3;
    
    
    private HashMap<Integer, QZRightWindowBase> mHashMap;
    
	private QZRightWindowContainer mContainer;
	
	
	public QZRightWindowManager(){
		mHashMap = new HashMap<Integer, QZRightWindowBase>(); 
	}
	
	public void setmContainer(QZRightWindowContainer container) {
		this.mContainer = container;
	}
	
	public void showRightWindow(int num,QZRightWindowBase mQzRightWindowBase){
		if(!mHashMap.containsKey(num)){
			mHashMap.put(num, mQzRightWindowBase);
			if(!(mQzRightWindowBase instanceof QZRightWindow1)){
				mContainer.addView(mQzRightWindowBase);
			}
		}
		
		for (Iterator iter = mHashMap.keySet().iterator(); iter.hasNext();) {
			Object key = iter.next();
			QZRightWindowBase qzb = mHashMap.get(key);
			qzb.setVisibility(View.INVISIBLE);
		}
		
		mQzRightWindowBase.setVisibility(View.VISIBLE);
	}
	
}
