package com.test.dao;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import com.test.entity.User;
public class LoginDaoImpl implements LoginDao{
	 private SessionFactory sessionFactory;
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
	
		/*
			public User queryUser(String id){
			String HQL = "from User as e where e.id=?0";
			List<User> users = find(HQL, id);//当心find出错
			return users.get(0);
		}
		*/
		public User searchUser(Map<String, Object> logininfo) {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			String username=(String) logininfo.get("username");
			
			
			User user=new User();
			String sqlString="select * from user where username='"+username+"'";
			Query query=session.createSQLQuery(sqlString)
					.addScalar("username", StringType.INSTANCE)
					.addScalar("password", StringType.INSTANCE)
					.addScalar("mark", StringType.INSTANCE)
					.addScalar("id", StringType.INSTANCE)
					.addScalar("cname", StringType.INSTANCE)
					.addScalar("department", StringType.INSTANCE)
					.addScalar("phone", StringType.INSTANCE);
			        
			query.setResultTransformer(Transformers.aliasToBean(User.class));
			    List<User> list=query.list();
				if(list.size()>0){
					user=list.get(0);
					
				}else{
					user=null;
				}
				 tr.commit();
			     session.close();
			     
			     return user;
			
		}
		
		
		//public List<User> searchUser(String username){
		//	Session session=sessionFactory.openSession();
		//	session.beginTransaction();
			
		//	String hql = "from User where username = '"+username +"'";
		//	Query query=session.createQuery(hql);
			
		//	List<User> userList = query.list();
			
		//	for(User user:userList){
		//		System.out.println("打印打印值："+user);
		//	}	
		//	session.getTransaction().commit();
		//	session. close();
		//	return userList;
		//}
		
		
	public User CheckUser(Map<String, Object> logininfo) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		String username=(String) logininfo.get("username");
		String password=(String) logininfo.get("password");
		
		User user=new User();
		String sqlString="select * from user where username='"+username+"' and password= '" +password+ "'";
		Query query=session.createSQLQuery(sqlString)
				.addScalar("username", StringType.INSTANCE)
				.addScalar("password", StringType.INSTANCE)
				.addScalar("mark", StringType.INSTANCE)
				.addScalar("id", StringType.INSTANCE)
				.addScalar("cname", StringType.INSTANCE)
				.addScalar("department", StringType.INSTANCE)
				.addScalar("phone", StringType.INSTANCE);
		        
		query.setResultTransformer(Transformers.aliasToBean(User.class));
		    List<User> list=query.list();
			if(list.size()>0){
				user=list.get(0);
				
			}else{
				user=null;
			}
			 tr.commit();
		     session.close();
		     
		     return user;
		
	}

	public int RegisterUser(User user) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		int executeUpdate = 0;
		try {
			String sqlString="insert into user (id,username,password,cname,mark,department,phone)  values ('"+UUID.randomUUID().toString().substring(0, 30)+"','"+user.getUsername()+"','" +user.getPassword()+ "','"+user.getCname()+"','"+user.getMark()+"','"+user.getDepartment()+"','"+user.getPhone()+"')";
			Query query=session.createSQLQuery(sqlString);
			executeUpdate = query.executeUpdate();
			System.out.println("executeUpdate："+executeUpdate);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			tr.commit();
		    session.close();
		}
		return executeUpdate;
	}

	public List<User> userList() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		String sqlString="select * from user";
		List<User> list=null;
		try {
			Query query=session.createSQLQuery(sqlString)
					.addScalar("username", StringType.INSTANCE)
					.addScalar("password", StringType.INSTANCE)
					.addScalar("mark", StringType.INSTANCE)
					.addScalar("id", StringType.INSTANCE)
					.addScalar("cname", StringType.INSTANCE)
					.addScalar("department", StringType.INSTANCE)
				    .addScalar("phone", StringType.INSTANCE);
			
			query.setResultTransformer(Transformers.aliasToBean(User.class));
			        list=query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			tr.commit();
		    session.close();
		}
		return list;
	}

	public int delete(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		
		int executeUpdate = 0;

		String sqlString="delete from user  where  id= '"+id+"'";
		try {
			Query query=session.createSQLQuery(sqlString);
			executeUpdate = query.executeUpdate();
			System.out.println("executeUpdate："+executeUpdate);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			tr.commit();
		    session.close();
		}
		return executeUpdate;
	}

	public int update(User user) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		int executeUpdate = 0;
		String sqlString="update user set password = '"+user.getPassword()+"', cname = '"+user.getCname()+"', mark = '"+user.getMark()+"',department='"+user.getDepartment()+"',phone='"+user.getPhone()+"'where  id= '"+user.getId()+"'";
		try {
			Query query=session.createSQLQuery(sqlString);
			executeUpdate = query.executeUpdate();
			System.out.println("executeUpdate："+executeUpdate);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			tr.commit();
		    session.close();
		}
		return executeUpdate;
	}
}
