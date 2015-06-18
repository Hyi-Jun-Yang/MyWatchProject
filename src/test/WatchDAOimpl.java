package project.com.watch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WatchDAOimpl implements WatchDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	private static final String DRIVERNAME="oracle.jdbc.OracleDriver";
	private static final String USER="admin";
	private static final String PASSWORD="hi123456";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String FILE_UPLOAD_SQL=
			"insert into watch(user_id,user_name,file_upload) values(?,?,?)";
	private static final String MYVEDIO_SEARCH_SQL=
			"select * from watch where user_id=? ";
	private static final String WATCHLIST_SQL="select * from watch";
	private static final String FILE_SEARCH_SQL="select * from watch where upload_file like ?";
	
	public WatchDAOimpl() {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("watch conn success");
		} catch (ClassNotFoundException e) {
			System.out.println("watch conn fail");
			e.printStackTrace();
		}
	
	}
	


	@Override
	public int fileupload(WatchVO vo) {
		int flag =0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(FILE_UPLOAD_SQL);
			pstmt.setString(1,vo.getUser_id());
			pstmt.setString(2,vo.getUser_name());
			pstmt.setString(3,vo.getFile_upload());
			flag=pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			flag=-1;
			e.printStackTrace();
		} finally{
			
			if(pstmt!=null){		
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			
			if(conn!=null){		
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		
		return flag;
	}

	@Override
	public WatchVO watch(WatchVO vo) {
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(MYVEDIO_SEARCH_SQL);
			pstmt.setString(1, vo.getUser_id());
	
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			vo = new WatchVO();
			vo.setUser_id(rs.getString("user_id"));
			vo.setUser_name(rs.getString("user_name"));
			vo.setFile_upload(rs.getString("file_upload"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			if(rs!=null){		
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null){		
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null){		
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return vo;
	}

	@Override
	public List<WatchVO> watchList() {
		List<WatchVO> list = new ArrayList<WatchVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(WATCHLIST_SQL);
			rs = pstmt.executeQuery();
			WatchVO vo = null;
			while(rs.next()){
			vo = new WatchVO();
			vo.setUser_id(rs.getString("user_id"));
			vo.setUser_name(rs.getString("user_name"));
			vo.setFile_upload(rs.getString("file_upload"));
			list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			if(rs!=null){		
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null){		
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null){		
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

	@Override
	public List<WatchVO> watchList(String key, String value) {
		List<WatchVO> list = new ArrayList<WatchVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			if(key.compareTo("mylist")==0){
				pstmt = conn.prepareStatement(MYVEDIO_SEARCH_SQL);
				pstmt.setString(1, value);
			}
			else if(key.compareTo("videolist")==0){
				pstmt = conn.prepareStatement(FILE_SEARCH_SQL);
				pstmt.setString(1, "%"+value+"%");
			}else{
				pstmt = conn.prepareStatement(WATCHLIST_SQL);
			}
			
			rs = pstmt.executeQuery();
			WatchVO vo = null;
			while(rs.next()){
			vo = new WatchVO();
			vo.setUser_id(rs.getString("user_id"));
			vo.setUser_name(rs.getString("user_name"));
			vo.setFile_upload(rs.getString("file_upload"));
			list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			if(rs!=null){		
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null){		
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null){		
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

}
