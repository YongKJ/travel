
import java.util.List;
import java.util.ArrayList;

public class MembershipService {
	
	public MembershipDao meDao;
	public List<Membership> membershipsList;
    public judgeService judge;
	
	public MembershipService() {
		meDao = new MembershipDao();
		membershipsList = new ArrayList<>();
        judge = new judgeService();
	}
	
	public List<Membership> getMembership() throws Exception {
		membershipsList = meDao.getMembership();
		return membershipsList;
	}
	
	public boolean addMembership(Membership membership) throws Exception {
        int mAttractionsId = membership.getmAttractionsId();
        boolean mAttractionsIdFlag = judge.judgeAttractions(mAttractionsId);
        
		if(mAttractionsIdFlag) {
			meDao.addMembership(membership);
            return true;
		}
        return false;
	}
	
	public boolean modMembership(Membership membership) throws Exception {
        int membershipId = membership.getmId();
        boolean membershipIdFlag = judge.judgeMembership(membershipId);
        
		if(membershipIdFlag) {
			meDao.modMembership(membership);
            return true;
		}
        return false;
	}
	
	public boolean delMembership(Membership membership) throws Exception {
        int membershipId = membership.getmId();
        boolean membershipIdFlag = judge.judgeMembership(membershipId);
        
		if(membershipIdFlag) {
			meDao.delMembership(membership);
            return true;
		}
        return false;
	}
	
}