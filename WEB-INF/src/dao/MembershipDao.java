
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class MembershipDao {
	
	public List<Membership> membershipsList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public MembershipDao() {
		conn = null;
		st = null;
		ps = null;
		rs = null;
	}
	
	public List<Membership> getMembership() throws Exception {
		sql = "select * from membership";
		membershipsList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			Membership membership = new Membership();
			membership.setmId(rs.getInt(1));
			membership.setmName(rs.getString(2));
			membership.setmPrice(rs.getDouble(3));
			membership.setmAttractionsId(rs.getInt(4));
			membershipsList.add(membership);
		}
		SQLUtil.closeAll(conn, st, rs);
		return membershipsList;
	}
	
	public void addMembership(Membership membership) throws Exception {
		sql = "insert into membership (mname, mprice, mattractions_id) values (?, ?, ?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, membership.getmName());
		ps.setDouble(2, membership.getmPrice());
		ps.setInt(3, membership.getmAttractionsId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modMembership(Membership membership) throws Exception {
		sql = "update membership set mname = ?, mprice = ?, mattractions_id = ? where mid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, membership.getmName());
		ps.setDouble(2, membership.getmPrice());
		ps.setInt(3, membership.getmAttractionsId());
		ps.setInt(4, membership.getmId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delMembership(Membership membership) throws Exception {
		sql = "delete from membership where mid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, membership.getmId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}