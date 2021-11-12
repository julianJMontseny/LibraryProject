import org.iesfm.library.Member;
import org.iesfm.library.dao.LibraryConfiguration;
import org.iesfm.library.dao.jdbc.JDBCMemberDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {LibraryConfiguration.class})
public class MemberDAOTest {

    private JDBCMemberDAO memberDAO;

    @Test
    public void insertMemberTest(){
        Member member = new Member(
                "0000X",
                "Cupertino",
                "Cucciano"
        );

        memberDAO.insert(member);

    }

}
