package web_study_08.service;

import java.util.List;

import web_study_08.dao.MemberDao;
import web_study_08.dao.impl.MemberDaoImpl;
import web_study_08.dto.Member;

public class MemberServcie {
    private MemberDao dao = MemberDaoImpl.getInstance();
    
    public List<Member> showMemberLists(){
        return dao.selectMemberByAll();
    }
}
