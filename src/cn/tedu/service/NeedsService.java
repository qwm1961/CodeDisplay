package cn.tedu.service;

import java.util.List;

import cn.tedu.bean.Needs;
import cn.tedu.bean.Page;
import cn.tedu.dao.NeedsDao;

public class NeedsService {
	/**
	 * 分页查询所有需求
	 */
	public List<Needs> selectAllNeedByPage(Page p) {
		NeedsDao nd = new NeedsDao();
		List<Needs> list = nd.selectNeeds(p.getIndex(),p.getRows());
		return list;
		
	}

	public String add(Needs needs) {
		NeedsDao nd2 = new NeedsDao();
		int result = nd2.addNeed(needs);
		if (result > 0) {
			return "添加成功";
		}
		return "添加失败";
	}
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public Needs selectNedById(int id) {
		NeedsDao nd3 = new NeedsDao();
		Needs list = nd3.selectNedId(id);
		return list;
	}

	public String editNeeds(Needs needs3) {
		NeedsDao nd4 = new NeedsDao();
		int n = nd4.updateNedById(needs3,needs3.getId());
		if (n > 0) {
			return "修改成功";
		}
		return "修改失败";
	}

	public String deletNeed(int id2) {
		NeedsDao nd4 = new NeedsDao();
		int result2 = nd4.deleteNedById(id2);
		if (result2 == 0) {
			return "删除失败";
		}
		return "删除成功";
	}
	
	public List<Needs> selectTitle(String title){
		NeedsDao nd5 = new NeedsDao();
		List<Needs> list = nd5.selectTitle(title);
		return list;
		
	}
}
