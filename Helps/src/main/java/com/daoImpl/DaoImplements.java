package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.daoInte.DaoInterface;
import com.entity.Collectors;
import com.entity.Comments;
import com.entity.Task;
import com.entity.User;
import com.util.UtilSqlSession;

import mapper.Mapper;

public class DaoImplements implements DaoInterface {
	// 判断是否是管理员
	@Override
	public User Login(User u) {
		try {
			UtilSqlSession.MySession().getMapper(Mapper.class).queryIfAdministrator(u);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return u;
	}

	// 判断用户名是否存在
	@Override
	public User ifUser(User u) {
		try {
			u = UtilSqlSession.MySession().getMapper(Mapper.class).queryIfUser(u);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return u;
	}

	// 判断手机号是否存在
	@Override
	public User ifPhone(User u) {
		try {
			u = UtilSqlSession.MySession().getMapper(Mapper.class).queryIfPhone(u);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return u;
	}

	// 添加用户（注册）
	@Override
	public boolean addUser(User u) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).addUser(u) == 1 ? true : false;
			;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 判断是有此用户
	@Override
	public User findUpass(User u) {
		try {
			u = UtilSqlSession.MySession().getMapper(Mapper.class).queryIfUserExist(u);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return u;
	}

	// 修改密码
	@Override
	public boolean alterUpass(User u) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).amendUserUpass(u) == 1 ? true : false;
			;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 显示所有订单
	@Override
	public List<Task> showorder() {
		List<Task> li;
		try {
			li = UtilSqlSession.MySession().getMapper(Mapper.class).queryAllTask();
		} finally {
			UtilSqlSession.MySession().close();
		}
		return li;
	}

	// 获取接单用户id
	@Override
	public User acquire(User u) {
		try {
			u = UtilSqlSession.MySession().getMapper(Mapper.class).queryAcceptId(u);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return u;
	}

	// 调用dao储存接取并转换为以接取
	@Override
	public boolean receiving(User u, Task t) {
		List<Object> li = new ArrayList<Object>();
		li.add(u);
		li.add(t);
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).amendTask(li) == 1 ? true : false;
			;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 储存订单
	@Override
	public boolean release(Task t) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).addMyTask(t) == 1 ? true : false;
			;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 填写完整信息
	@Override
	public boolean fullmessage(User u) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).addAmendUser(u) == 1 ? true : false;
			;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 判断是否为自己的订单
	@Override
	public Task iforder(Task t) {
		try {
			t = UtilSqlSession.MySession().getMapper(Mapper.class).queryIfMyTask(t);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return t;
	}

	// 显示我的订单
	@Override
	public List<Task> showmyorder(User u) {
		List<Task> li;
		try {
			li = UtilSqlSession.MySession().getMapper(Mapper.class).queryAllMyTask(u);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return li;
	}

	// 删除订单
	@Override
	public boolean delectorder(User u) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).removeAssignTask(u) == 1 ? true : false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 查找订单
	@Override
	public Task lookmyorder(Task t) {
		try {
			t = UtilSqlSession.MySession().getMapper(Mapper.class).seekMyTask(t);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return t;
	}

	// 修改订单
	@Override
	public boolean amendorder(Task t) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).amendMyTask(t) == 1 ? true : false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 预约订单
	@Override
	public boolean subscribe(Task t) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).appointmentMyTask(t) == 1 ? true : false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// ajax查询我的接单
	@Override
	public List<Task> myorderreceiving(User u) {
		List<Task> li;
		try {
			li = UtilSqlSession.MySession().getMapper(Mapper.class).queryMyReceiving(u);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return li;
	}

	// ajax订单搜索
	@Override
	public List<Task> seek(Task t) {
		List<Task> li;
		try {
			li = UtilSqlSession.MySession().getMapper(Mapper.class).pagingMyReceivingTask(t);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return li;
	}

	// 修改订单为已完成
	@Override
	public boolean orderorderachieve(Task t) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).amendMyAccomplish(t) == 1 ? true : false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 收藏订单
	@Override
	public boolean collector(Collectors c) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).collectMyTask(c) == 1 ? true : false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 我的收藏
	@Override
	public List<Collectors> collectors(User u) {
		List<Collectors> li = new ArrayList<Collectors>();
		try {
			li = UtilSqlSession.MySession().getMapper(Mapper.class).queryMyCollec(u);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return li;
	}

	// 取消收藏
	@Override
	public boolean cancel(Collectors c) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).cancelMyCollect(c) == 1 ? true : false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 判断是否是管理员
	@Override
	public User ifadministrator(User u) {
		try {
			u = UtilSqlSession.MySession().getMapper(Mapper.class).IfAdministrator(u);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return u;
	}

	// 管理员产看我的订单
	@Override
	public List<Task> lookorder() {
		List<Task> li = new ArrayList<Task>();
		try {
			li = UtilSqlSession.MySession().getMapper(Mapper.class).administratorLookTask();
		} finally {
			UtilSqlSession.MySession().close();
		}
		return li;
	}

	// 管理员查询所有用户
	@Override
	public List<User> lookuser() {
		List<User> li = new ArrayList<User>();
		try {
			li = UtilSqlSession.MySession().getMapper(Mapper.class).administratorLookUser();
		} finally {
			UtilSqlSession.MySession().close();
		}
		return li;
	}

	// 管理员删除用户
	public boolean delectuser(User u) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).administratorDeleteUser(u) == 1 ? true : false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 查询该单的状态
	@Override
	public Task lookstate(Task t) {
		try {
			t = UtilSqlSession.MySession().getMapper(Mapper.class).queryTaskState(t);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return t;

	}

	// 提示
	@Override
	public int Prompt(Task t) {
		try {
			t = UtilSqlSession.MySession().getMapper(Mapper.class).taskHint(t);
		} finally {
			UtilSqlSession.MySession().close();
		}
		if (t != null) {
			return 1;
		} else {
			return 0;
		}
	}

	// 修改提示状态
	@Override
	public boolean modifyprompt(Task t) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).amendTaskHintState(t)==1?true:false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 修改提示状态(完成订单)
	@Override
	public boolean ermodifyprompt(Task t) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).amendTaskHintStateComplete(t)==1?true:false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 储存评论
	@Override
	public boolean discuss(Comments c) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).addMyComments(c) == 1 ? true : false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	// 显示信息
	@Override
	public List<Comments> lookcomment(Task t) {
		List<Comments> li = new ArrayList<Comments>();
		try {
			li = UtilSqlSession.MySession().getMapper(Mapper.class).showMyMessage(t);
		} finally {
			UtilSqlSession.MySession().close();
		}
		return li;
	}

	// 放弃订单
	@Override
	public boolean giveorder(Task t) {
		boolean temp;
		try {
			temp = UtilSqlSession.MySession().getMapper(Mapper.class).cancelMyTask(t) == 1 ? true : false;
		} finally {
			UtilSqlSession.MySession().close();
		}
		return temp;
	}

	@Override
	public List<Task> queryAll5() {
		List<Task> li = new ArrayList<Task>();
		try {
			li = UtilSqlSession.MySession().getMapper(Mapper.class).queryAllTask5();
		} finally {
			UtilSqlSession.MySession().close();
		}
		return li;
	}

}
