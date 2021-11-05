package org.iesfm.library.dao;

import org.iesfm.library.Member;

import java.util.List;

public interface MemberDAO {

    public Member getMember (String nif);

    List<Member> list();
}
