package com.sdt.junc.util;

/**
 * @author yp
 *
 */

public interface DataStack {
	
	/**
	 * 从数据堆栈结尾添加数据
	 * @param bytes 添加的数据
	 */
	public void add(byte[] bytes);
	
	/**
	 * 从数据堆栈结尾添加数据
	 * @param bytes 添加的数据
	 * @param offset 添加的数据起始位置（从0开始）
	 */
	public  void add(byte[] bytes,int offset);
	
	/**
	 * 从数据堆栈结尾添加数据
	 * @param bytes 添加的数据
	 * @param offset 添加的数据起始位置(从0开始)
	 * @param dataLen 添加的数据长度
	 */
	public  void add(byte[] bytes,int offset,int dataLen);
	
	/**
	 * 从数据堆栈结尾添加数据
	 * @param b 添加的数据
	 */
	public  void add(byte b);
	
	/**
	 * 从数据堆栈结尾添加数据
	 * @param dataStack 添加的数据
	 */
	public  void add(DataStack dataStack);
	
	/**
	 * 从数据堆栈中插入数据
	 * @param allDataOffset 数据堆栈的插入位置(包括0,当位置大于等于数据堆栈长度时，从后面插入数据)
	 * @param bytes 插入的数据
	 */
	public  void insert(int allDataOffset, byte[] bytes);
	
	/**
	 * 从数据堆栈中插入数据
	 * @param allDataOffset 数据堆栈的插入位置(包括0,当位置大于等于数据堆栈长度时，从后面插入数据)
	 * @param bytes 插入的数据
	 * @param offset 插入的数据的起始位置
	 */
	public  void insert(int allDataOffset, byte[] bytes,int offset);
	
	/**
	 * 从数据堆栈中插入数据
	 * @param allDataOffset 数据堆栈的插入位置(包括0,当位置大于等于数据堆栈长度时，从后面插入数据)
	 * @param bytes 插入的数据
	 * @param offset 插入的数据的起始位置
	 * @param dataLen 插入数据的长度
	 */
	public  void insert(int allDataOffset, byte[] bytes,int offset,int dataLen);
	
	/**
	 * 从数据堆栈中插入数据
	 * @param allDataOffset 数据堆栈的插入位置(包括0,当位置大于等于数据堆栈长度时，从后面插入数据)
	 * @param b 插入的数据
	 */
	public  void insert(int allDataOffset, byte b);
	
	/**
	 * 从数据堆栈中插入数据
	 * @param allDataOffset 数据堆栈的插入位置(包括0,当位置大于等于数据堆栈长度时，从后面插入数据)
	 * @param dataStack 插入的数据
	 */
	public  void insert(int allDataOffset, DataStack dataStack);
	
	/**
	 * 从结尾删除数据
	 * @param dataLen 删除数据长度，当长度大于数据堆栈总长度，全部删除
	 */
	public  void delete(int dataLen);
	
	
	/**
	 * 取得数据堆栈
	 * @return 数据堆栈
	 */
	public  DataStack getDataStack();
	
	/**
	 * 取得数据堆栈中数据
	 * @return 数据堆栈数据
	 */
	public  byte[] getData();
	
	/**
	 * 取得数据堆栈中数据，从0开始
	 * @param dataLen 获得的数据长度
	 * @return 数据堆栈数据
	 */
	public  byte[] getData(int dataLen);
	
	/**
	 * 取得数据堆栈中数据
	 * @param offset 获取数据的起始位置，从0开始
	 * @param dataLen 获得的数据长度
	 * @return 数据堆栈数据
	 */
	public  byte[] getData(int offset,int dataLen);
	
	/**
	 * 弹出数据堆栈中数据，从0位置开始，实现先进先出，实现游标内部移动，获取的数据堆栈副本数据
	 * @param dataLen 获得的数据长度
	 * @return 数据堆栈数据
	 */
	public  byte[] pop(int dataLen);

	/**
	 * 返回内部游标数值，与pop方法相关
	 * @return 内部游标数值
	 */
	public int getCourse();
	
	/**
	 * 设定内部游标数值
	 * @param course 要设定内部游标数值
	 */
	public void setCourse(int course);
	
	/**
	 * 初始化内部游标数值
	 */
	public void initCourse();
	
	/**
	 * 取得数据堆栈长度
	 * @return 数据堆栈长度
	 */
	public  int getDataLength();
	
	/**
	 * 清除数据堆栈中所有数据
	 */
	public  void clear();
}
