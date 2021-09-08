package com.jsp.action.pds;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

public class PdsRemoveAction implements Action {
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="pds/remove_success";
		
		int pno = Integer.parseInt(request.getParameter("pno"));

		PdsVO pds = pdsService.getPds(pno);
		
		List<AttachVO> attachList = pds.getAttachList();
		
		if(attachList != null) {
			for(AttachVO attach : attachList) { //파일과 DB를 모두 지워야 함
		
				String storedFilePath = attach.getUploadPath() + File.separator + attach.getFileName();
				File file = new File(storedFilePath);
				
				if(file.exists()) {
					file.delete();
				}
			}
		}
		
		pdsService.remove(pno);
		return url;
	}

}
