
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AttentionDao {
	
	public List<Attention> attentionsList;
    public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public AttentionDao() {
		conn = null;
		st = null;
		ps = null;
		rs = null;
	}
    
    public void writeToLog(int str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
	
	public List<Attention> getAttention() throws Exception {
		sql = "select * from attention";
		attentionsList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			Attention attention = new Attention();
			attention.setaId(rs.getInt(1));
			attention.setaData(rs.getString(2));
			attention.setaAttractionsId(rs.getInt(3));
			attention.setaBUserTableId(rs.getInt(4));
			attentionsList.add(attention);
		}
		SQLUtil.closeAll(conn, st, rs);
		return attentionsList;
	}
	
	public void addAttention(Attention attention) throws Exception {
		sql = "insert into attention (adata, aattractions_id, abusertable_id) values (?, ?, ?)";//注意查看是否为英文的问号
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
//         writeToLog(0);
		ps.setString(1, attention.getaData());
//         writeToLog(8);
		ps.setInt(2, attention.getaAttractionsId());
//         writeToLog(9);
//         writeToLog(attention.getaBUserTableId());
		ps.setInt(3, attention.getaBUserTableId());
//         writeToLog(1);
		ps.executeUpdate();
//         writeToLog(2);
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modAttention(Attention attention) throws Exception {
		sql = "update attention set adata = ?, aattractions_id = ?, abusertable_id = ? where aid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, attention.getaData());
		ps.setInt(2, attention.getaAttractionsId());
		ps.setInt(3, attention.getaBUserTableId());
		ps.setInt(4, attention.getaId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delAttention(Attention attention) throws Exception {
		sql = "delete from attention where aid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, attention.getaId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}