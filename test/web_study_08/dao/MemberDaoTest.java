package web_study_08.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_08.dao.impl.MemberDaoImpl;
import web_study_08.dto.Member;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {

    @Test
    public void testSelectMemberByAll() {
        System.out.println("testSelectMemberByAll()");
        List<Member> list = MemberDaoImpl.getInstance().selectMemberByAll();
        Assert.assertNotNull(list);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void testSelectMemberByNo() {
        System.out.println("testSelectMemberByNo()");
        Member member = MemberDaoImpl.getInstance().selectMemberByNo(new Member("somi"));
        Assert.assertNotNull(member);
        System.out.println(member);
    }

    @Test
    public void test1InsertMember() {
        System.out.println("test1InsertMember()");
        //'박규영', 'parkgy', '1234', 'pgy@gmail.com', '010-1111-2222', 0
        Member newMember = new Member("박규영", "parkgy", "1234", "pgy@gmail.com", "010-1111-2222", 0);
        int res = MemberDaoImpl.getInstance().insertMember(newMember);
        Assert.assertEquals(1, res);
    }

    @Test
    public void test3DeleteMember() {
        System.out.println("test3DeleteMember()");
        int res = MemberDaoImpl.getInstance().deleteMember(new Member("parkgy"));
        Assert.assertEquals(1, res);
    }

    @Test
    public void test2UpdateMember() {
        System.out.println("test2UpdateMember()");
        Member modifyMember = MemberDaoImpl.getInstance().selectMemberByNo(new Member("parkgy"));
        System.out.println("before : " + modifyMember);
        //(NAME, USERID, PWD, EMAIL, PHONE, ADMIN)
        modifyMember.setName("문채영");
        modifyMember.setPwd("3333");
        modifyMember.setEmail("mcy@gmailcom");
        modifyMember.setPhone("010-1111-2222");
        modifyMember.setAdmin(1);
        int res = MemberDaoImpl.getInstance().updateMember(modifyMember);
        Member afterMember = MemberDaoImpl.getInstance().selectMemberByNo(new Member("parkgy"));
        System.out.println("after : " + afterMember);
        Assert.assertEquals(1, res);
    }

}
