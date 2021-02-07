
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class StrategyDao {
	
	public List<Strategy> strategysList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public StrategyDao() {
		conn = null;
		st = null;
		ps = null;
		rs = null;
	}
	
	public List<Strategy> getStrategy() throws Exception {
		sql = "select * from strategy";
		strategysList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			Strategy strategy = new Strategy();
			strategy.setsId(rs.getInt(1));
			strategy.setsTitle(rs.getString(2));
			strategy.setsText(rs.getString(3));
			strategy.setsDataTime(rs.getString(4));
			strategy.setsPlace(rs.getString(5));
			strategy.setsReading(rs.getString(6));
			strategy.setsBUserTableId(rs.getInt(7));
			strategysList.add(strategy);
		}
		SQLUtil.closeAll(conn, st, rs);
		return strategysList;
	}
	
	public void addStrategy(Strategy strategy) throws Exception {
		sql = "insert into strategy (stitle, stext, sdatatime, splace, sreading, sbusertable_id) values (?, ?, ?, ?, ?, ?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, strategy.getsTitle());
		ps.setString(2, strategy.getsText());
		ps.setString(3, strategy.getsDataTime());
		ps.setString(4, strategy.getsPlace());
		ps.setString(5, strategy.getsReading());
		ps.setInt(6, strategy.getsBUserTableId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modStrategy(Strategy strategy) throws Exception {
		sql = "update strategy set stitle = ?, stext = ?, sdatatime = ?, splace = ?, sreading = ?, sbusertable_id = ? where sid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, strategy.getsTitle());
		ps.setString(2, strategy.getsText());
		ps.setString(3, strategy.getsDataTime());
		ps.setString(4, strategy.getsPlace());
		ps.setString(5, strategy.getsReading());
		ps.setInt(6, strategy.getsBUserTableId());
		ps.setInt(7, strategy.getsId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delStrategy(Strategy strategy) throws Exception {
		sql = "delete from strategy where sid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, strategy.getsId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}