package cn.tedu.dao;

import java.util.List;

import cn.tedu.bean.Needs;
import cn.tedu.bean.School;
import cn.tedu.util.DBTools;

public class NeedsDao {
	
	/**
	 * 分页查询所有需求
	 */
	public List<Needs> selectNeeds(int start, int rows) {
		String sql = "select * from needs";
		Object[] obj= {start,rows};
		
		List<Needs> list = DBTools.query(sql, Needs.class);
		//System.out.println(list);
		return list;
	}

	public int addNeed(Needs needs) {
		String sql = "insert into needs (Title, State, Nschool, Information,Createtime,Crname) values (?,?,?,?,?,?)";
		Object[] obj= {needs.getTitle(),needs.getState(),needs.getNschool(),needs.getInformation(),needs.getCreatetime(),needs.getCrname()};
		int n = DBTools.update(sql, obj);
		return n;
	}

	public Needs selectNedId(int id) {
		String sql = "select * from needs where id = ?";
		Object[] obj = {id};
		List<Needs> list = DBTools.query(sql, Needs.class, obj);
		
		if(list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 编辑需求
	 */
	public int updateNedById(Needs needs3, int id) {
		String sql = "update needs set Title = ?,State = ?,Nschool = ?, Information = ? where Id = ?";
		Object[] obj = {needs3.getTitle(),needs3.getState(),needs3.getNschool(),needs3.getInformation(),needs3.getId()};
		int n = DBTools.update(sql, obj);
		return n;
	}

	/**
	 * 根据id删除数据
	 */
	public int deleteNedById(int id2) {
		String sql="delete from needs where Id=?";
		Object[] obj= {id2};
		int n = DBTools.update(sql, obj);
		return n;
	}

	public List<Needs> selectTitle(String title) {
		String sql = "select * from needs where Title like\"%\"?\"%\"";
		Object[] obj = {title};
		List<Needs> list = DBTools.query(sql, Needs.class, obj);
		return list;
	}
	
}
