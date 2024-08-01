package db.student.service;

import java.util.ArrayList;

import db.student.model.vo.SubjectVO;

public interface SubjectService {

	boolean insertSubject(String subject);

	boolean deleteSubject(String subject);

	ArrayList<SubjectVO> selectSubjectNameList();

	boolean updateSubject(String subject, String newSubject);

}
