package org.iesfm.library.dao;

import org.iesfm.library.Member;

import java.util.List;

public interface MemberDAO {

    List<Member> list();

    Member getMember (String nif);

    void insert(Member member);
}
