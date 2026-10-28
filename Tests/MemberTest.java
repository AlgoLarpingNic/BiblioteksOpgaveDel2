import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {


    Member member;
    @BeforeEach
    void setupMember() {
        member = new Member("Mike Oxlong",69);

    }
    @Test
    void testGetMemberName() {
        //arrange
        setupMember();

        //act
        String resultName = member.getName();

        //assert
        assertEquals("Mike Oxlong",resultName);
    }

    @Test
    void testGetMemberId() {
        //arrange
        setupMember();

        //act
        int resultId = member.getMemberId();

        //assert
        assertNotEquals(70, resultId);
    }
}
