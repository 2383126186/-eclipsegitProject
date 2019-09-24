package mapper;

import java.util.List;

import com.entity.Collectors;
import com.entity.Comments;
import com.entity.Task;
import com.entity.User;

public interface Mapper {
	//判断是不是管理员
	User queryIfAdministrator(User u);
	//判断用户是否存在
	User queryIfUser(User u);
	//判断手机是否存在
	User queryIfPhone(User u);
	//添加用户
	int addUser(User u);
	//判断用户是否存在
	User queryIfUserExist(User u);
	//修改用户密码
	int amendUserUpass(User u);
	//查询所有未接订单
	List<Task> queryAllTask();
	//获取接单人id
	User queryAcceptId(User u);
	//转换为以接取
	int amendTask(List<Object> li);
	//添加我的订单
	int addMyTask(Task t);
	//完善信息
	int addAmendUser(User u);
	//查看是否是自己的订单
	Task queryIfMyTask(Task t);
	//查询我的订单
	List<Task> queryAllMyTask(User u);
	//搜索订单
	Task seekMyTask(Task t);
	//修改订单
	int amendMyTask(Task t);
	//预约订单
	int appointmentMyTask(Task t);
	//查询所有分页
	List<Task> queryAllTask5();
	//删除指定的订单
	int removeAssignTask(User u);
	//查询我的接单
	List<Task> queryMyReceiving(User u);
	//输入搜索
	List<Task> pagingMyReceivingTask(Task t);
	//修改订单为已完成
	int amendMyAccomplish(Task t);
	//收藏订单
	int collectMyTask(Collectors c);
	//我的收藏
	List<Collectors> queryMyCollec(User u);
	//取消订单
	int cancelMyCollect(Collectors t);
	//判断是不是管理员
	User IfAdministrator(User u);
	//管理员查询所有订单
	List<Task> administratorLookTask();
	//管理员查询所有用户
	List<User> administratorLookUser();
	//管理员删除用户
	int administratorDeleteUser(User u);
	//查询订单状态
	Task queryTaskState(Task t);
	//提示
	Task taskHint(Task t);
	//修改提示状态
	int amendTaskHintState(Task t);
	//修改提示状态(中介)
	int amendTaskHintStateComplete(Task t);
	//添加订单
	int addMyComments(Comments c);
	//显示信息
	List<Comments> showMyMessage(Task t);
	//放弃订单
	int cancelMyTask(Task t);
}
