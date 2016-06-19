package com.sdt.junc.util.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.sdt.junc.util.DataStack;

public class ArrayDataStack implements DataStack {

	//核心存储容器
	protected List<byte[]> dataStack=null;
	//内部游标
	protected int course;
	
	public ArrayDataStack(){
        this.dataStack=new LinkedList<byte[]>();
    }
	
	@Override
	public void add(byte[] bytes) {
		
		this.dataStack.add(bytes);
	}

	@Override
	public void add(byte[] bytes, int offset) {
		
		int tempDataLen=bytes.length-offset;
        byte[] tempData = new byte[tempDataLen];
        System.arraycopy(bytes,offset,tempData,0,tempDataLen);
        this.dataStack.add(tempData);
	}

	@Override
	public void add(byte[] bytes, int offset, int dataLen) {
        byte[] tempData = new byte[dataLen];
        System.arraycopy(bytes,offset,tempData,0,dataLen);
        this.dataStack.add(tempData);  		
	}

	@Override
	public void add(byte b) {
		
		byte[] bytes = new byte[]{b};
		this.add(bytes);
	}

	@Override
	public void add(DataStack dataStack) {
		
		this.add(dataStack.getData());
	}

	@Override
	public void clear() {
		this.course = 0;
		this.dataStack.clear();
	}

	@Override
	public void delete(int dataLen) {
		
		if(dataLen>=this.getData().length){
			this.clear();
		}else{
			byte[] dataBytes = this.getData();
			byte[] tempBytes = new byte[dataBytes.length-dataLen];
			System.arraycopy(dataBytes, 0, tempBytes, 0, tempBytes.length);
			this.dataStack.clear();
			this.add(tempBytes);
		}
	}

	@Override
	public byte[] getData() {
		 
		int byteLen = this.getDataLength();
        byte[] datas = new byte[byteLen];
        int byteLenOffset = 0;
        for(byte[] bytes:this.dataStack){
            System.arraycopy(bytes, 0, datas, byteLenOffset, bytes.length);
            byteLenOffset+=bytes.length;
        }
        return datas;
	}

	@Override
	public int getDataLength() {
		
        int byteLen = 0;
        for(byte[] bytes:this.dataStack){
            byteLen+=bytes.length;
        }
        return byteLen;
	}

	@Override
	public DataStack getDataStack() {
		
		return this;
	}

	@Override
	public void insert(int allDataOffset, byte[] bytes) {
		
		if(allDataOffset>=this.getDataLength()){
			this.add(bytes);
		} else {
			byte[] tempData = this.getData();
			byte[] firstBytes = new byte[allDataOffset];
			System.arraycopy(tempData, 0, firstBytes, 0, firstBytes.length);
			byte[] secondBytes = new byte[tempData.length-allDataOffset];
			System.arraycopy(tempData, firstBytes.length, secondBytes, 0, secondBytes.length);
			this.dataStack.clear();
			dataStack.add(firstBytes);
			dataStack.add(bytes);
			dataStack.add(secondBytes);
		}
	}

	@Override
	public void insert(int allDataOffset, byte[] bytes, int offset) {
		
		int tempDataLen=bytes.length-offset;
        byte[] tempData = new byte[tempDataLen];
        System.arraycopy(bytes,offset,tempData,0,tempDataLen);
        this.insert(allDataOffset,tempData);
	}

	@Override
	public void insert(int allDataOffset, byte[] bytes, int offset, int dataLen) {
		
        byte[] tempData = new byte[dataLen];
        System.arraycopy(bytes,offset,tempData,0,dataLen);
        this.insert(allDataOffset,tempData);
	}

	@Override
	public void insert(int allDataOffset, byte b) {
		
		byte[] bytes = new byte[]{b};
		this.insert(allDataOffset,bytes);
	}

	@Override
	public void insert(int allDataOffset, DataStack dataStack) {
		
		this.insert(allDataOffset,dataStack.getData());
	}

	@Override
	public int getCourse() {
		
		return course;
	}

	@Override
	public byte[] getData(int dataLen) {
		
		return Arrays.copyOf(this.getData(), dataLen);
	}

	@Override
	public byte[] getData(int offset, int dataLen) {
		
		return Arrays.copyOfRange(this.getData(), offset, offset+dataLen);
	}

	@Override
	public void initCourse() {
		
		this.course = 0;
	}

	@Override
	public byte[] pop(int dataLen) {
		
		byte[] bytes = Arrays.copyOfRange(this.getData(), this.course, this.course+dataLen);
		this.course += dataLen;
		return bytes;
	}

	@Override
	public void setCourse(int course) {
		
		this.course=course;
	}
}
