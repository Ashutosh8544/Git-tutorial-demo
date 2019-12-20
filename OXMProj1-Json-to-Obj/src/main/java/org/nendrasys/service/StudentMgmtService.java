package org.nendrasys.service;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.nendrasys.model.Student;

public interface StudentMgmtService {
	public List<String> convertJsonToJavaObjects(List<String> listString) throws Exception;
}
