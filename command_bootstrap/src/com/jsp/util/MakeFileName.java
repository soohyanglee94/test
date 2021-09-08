package com.jsp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jsp.dto.AttachVO;

public class MakeFileName {

	public static String toUUIDFileName(String fileName, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}
	
	public static String parseFileNameFromUUID(String fileName, String delimeter) {
		String[] uuidFileName = fileName.split(delimeter);
		//split 뒤의 값
		return uuidFileName[uuidFileName.length - 1];
		 //여기서 -1은 왜해주는거지
	}
	
	public static List<AttachVO> parseFileNameFromAttaches(List<AttachVO> attachList,String delimeter){
		List<AttachVO> renamedAttachList = new ArrayList<AttachVO>();
		
		if(attachList!=null) {
			for(AttachVO attach : attachList) {
				String fileName = attach.getFileName(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimeter); //uuid가 제거된 filename
				attach.setFileName(fileName);
				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}
}
