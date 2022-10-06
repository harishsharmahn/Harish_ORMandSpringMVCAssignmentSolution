package com.gl.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.customer.entity.CustDetail;

@Repository
public class CustServImpl implements CustService {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	CustServImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<CustDetail> findAll() {

		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<CustDetail> custDetail = session.createQuery("from customer").list();

		tx.commit();

		return custDetail;
	}

	@Transactional
	public CustDetail findById(int id) {

		CustDetail custDetail = new CustDetail();

		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		custDetail = session.get(CustDetail.class, id);

		tx.commit();

		return custDetail;
	}

	@Transactional
	public void save(CustDetail theCustDetail) {

		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theCustDetail);

		tx.commit();

	}

	@Transactional
	public void deleteById(int id) {

		Transaction tx = session.beginTransaction();

		// get transaction
		CustDetail custDetail = session.get(CustDetail.class, id);

		// delete record
		session.delete(custDetail);

		tx.commit();

	}

//		@Transactional
//		public List<CustDetail> searchBy(String Name, String Author) {
//
//			
//			Transaction tx = session.beginTransaction();
//			String query = "";
//			if (Name.length() != 0 && Author.length() != 0)
//				query = "from Book where name like '%" + Name + "%' or author like '%" + Author + "%'";
//			else if (Name.length() != 0)
//				query = "from Book where name like '%" + Name + "%'";
//			else if (Author.length() != 0)
//				query = "from Book where author like '%" + Author + "%'";
//			else
//				System.out.println("Cannot search without input data");
//
//			List<Book> book = session.createQuery(query).list();
//
//			tx.commit();
//
//			return book;
//		}

	// print the loop
	@Transactional
	public void print(List<CustDetail> custDetail) {

		for (CustDetail c : custDetail) {
			System.out.println(c);
		}
	}

	@Override
	public List<CustDetail> searchBy(String fname, String lname, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
